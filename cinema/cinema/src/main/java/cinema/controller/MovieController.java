package cinema.controller;

import cinema.entities.*;
import cinema.service.CinemaService;
import cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final CinemaService cinemaService;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.findAllMovies());
        return "movie/movie-list";
    }

    @GetMapping("/new")
    public String createMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movie/movie-create";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{movieId}/assign")
    public String assignMovieToCinema(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findMovieById(movieId);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        model.addAttribute("cinemas", cinemaService.findAllCinemas());
        return "movie/movie-assign-cinema";
    }

    @PostMapping("/{movieId}/assign")
    public String saveAssignedCinema(@PathVariable("movieId") Long movieId, @RequestParam("cinemaId") Long cinemaId) {
        movieService.assignCinemaToMovie(movieId, cinemaId);
        return "redirect:/movies";
    }

    @GetMapping("/{movieId}")
    public String showMovieInfo(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findMovieWithShowTimesById(movieId);
        Map<Hall, List<ShowTime>> showTimesByHall = movie.getShowTimes().stream()
                .collect(Collectors.groupingBy(ShowTime::getHall));
        model.addAttribute("movie", movie);
        model.addAttribute("cinemas", movie.getCinemas());
        model.addAttribute("showTimesByHall", showTimesByHall);
        return "/movie/movie-info";
    }

    @GetMapping("/{movieId}/details")
    public String showMovieDetails(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findMovieById(movieId);
        MovieDetail movieDetail = movie.getMovieDetail();
        model.addAttribute("movie", movie);
        model.addAttribute("detail", movieDetail);
        return "/movie/movie-detail";
    }
}
