package pl.pjatk.movies.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movies.demo.models.Movie;
import pl.pjatk.movies.demo.services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    } // Co tutaj nie gra?

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> allMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/{title}")
    public ResponseEntity<Movie> addMovie(@RequestParam String title) {
        if (title.isEmpty())
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(movieService.addNewMovie(title));
    }

    @PostMapping("/{id}{title}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, String title) {
        if(movieService.updateMovie(id, title) == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        if(movieService.getMovieById(id) == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.accepted().build();
    }
}
