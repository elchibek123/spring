package cinema.controller;

import cinema.entities.Cinema;
import cinema.entities.Hall;
import cinema.entities.Movie;
import cinema.entities.ShowTime;
import cinema.service.CinemaService;
import cinema.service.HallService;
import cinema.service.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cinemas")
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;
    private final HallService hallService;
    private final ShowTimeService showTimeService;

    @GetMapping
    public String listCinemas(Model model) {
        List<Cinema> cinemas = cinemaService.findAllCinemas();
        model.addAttribute("cinemas", cinemas);
        return "cinema/cinema-list";
    }

    @GetMapping("/new")
    public String createCinema(Model model) {
        Cinema cinema = new Cinema();
        model.addAttribute("cinema", cinema);
        return "cinema/cinema-create";
    }

    @PostMapping("/save")
    public String saveCinema(@ModelAttribute("cinema") Cinema cinema) {
        cinemaService.saveCinema(cinema);
        return "redirect:/cinemas";
    }

    @GetMapping("/{cinemaId}/edit")
    public String editCinema(@PathVariable("cinemaId") Long cinemaId, Model model) {
        Cinema cinema = cinemaService.findCinemaById(cinemaId);
        model.addAttribute("cinemas", cinema);
        return "/cinema/cinema-edit";
    }

    @PostMapping("/{cinemaId}/update")
    public String updateCinema(@PathVariable("cinemaId") Long cinemaId, @ModelAttribute("cinema") Cinema updatedCinema) {
        cinemaService.updateCinema(cinemaId, updatedCinema);
        return "redirect:/cinemas";
    }

    @PostMapping("/{cinemaId}/delete")
    public String deleteCinema(@PathVariable("cinemaId") Long cinemaId) {
        cinemaService.deleteCinema(cinemaId);
        return "redirect:/cinemas";
    }

    @GetMapping("/{cinemaId}")
    public String listMoviesByCinema(@PathVariable("cinemaId") Long cinemaId, Model model) {
        Cinema cinema = cinemaService.findCinemaById(cinemaId);
        List<Hall> hallsByCinemaId = hallService.findHallsByCinemaId(cinemaId);
        Map<Movie, List<ShowTime>> showTimesByMovie = new HashMap<>();
        Set<Movie> moviesInCinema = cinema.getMovies();
        for (Movie movie : moviesInCinema) {
            List<ShowTime> showTimes = showTimeService.findShowTimesByCinemaAndMovie(cinemaId, movie.getId());
            if (!showTimes.isEmpty()) {
                showTimesByMovie.put(movie, showTimes);
            }
        }
        model.addAttribute("cinema", cinema);
        model.addAttribute("halls", hallsByCinemaId);
        model.addAttribute("showTimesByMovie", showTimesByMovie);
        return "/movie/movie-list-by-cinema-id";
    }
}
