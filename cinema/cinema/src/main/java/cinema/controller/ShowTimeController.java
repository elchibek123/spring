package cinema.controller;

import cinema.entities.Movie;
import cinema.entities.ShowTime;
import cinema.service.MovieService;
import cinema.service.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/show-times")
@RequiredArgsConstructor
public class ShowTimeController {
    private final ShowTimeService showTimeService;
    private final MovieService movieService;

    @GetMapping
    public String listShowTimes(Model model) {
        List<ShowTime> showTimes = showTimeService.findAllShowTimes();
        model.addAttribute("showTimes", showTimes);
        return "movie/showtime-list";
    }

    @GetMapping("/{movieId}/new")
    public String createShowTime(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findMovieById(movieId);
        model.addAttribute("showTime", new ShowTime());
        model.addAttribute("movie", movie);
        return "movie/movie-showtime-create";
    }
}
