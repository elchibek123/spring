package cinema.controller;

import cinema.entities.Movie;
import cinema.entities.MovieDetail;
import cinema.service.MovieDetailService;
import cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/details")
@RequiredArgsConstructor
public class MovieDetailController {
    private final MovieDetailService movieDetailService;
    private final MovieService movieService;

    @GetMapping("/{movieId}/details")
    public String showMovieDetails(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findMovieById(movieId);
        MovieDetail movieDetail = movie.getMovieDetail();
        model.addAttribute("movie", movie);
        model.addAttribute("detail", movieDetail);
        return "redirect:/movies/" + movieId + "/details";
    }

    @GetMapping("/{movieId}/new")
    public String createMovieDetail(@PathVariable("movieId") Long movieId, Model model) {
        Movie movie = movieService.findMovieById(movieId);
        model.addAttribute("movieDetail", new MovieDetail());
        model.addAttribute("movie", movie);
        return "movie/movie-detail-create";
    }

    @PostMapping("/{movieId}/save")
    public String saveMovie(@PathVariable("movieId") Long movieId,
                            @ModelAttribute("movieDetail") MovieDetail movieDetail,
                            Model model) {
        Movie movie = movieService.findMovieById(movieId);
        movieDetailService.saveMovieDetail(movieId, movieDetail);
        return "redirect:/movies/" + movieId + "/details";
    }
}
