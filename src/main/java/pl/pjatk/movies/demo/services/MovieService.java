package pl.pjatk.movies.demo.services;

import org.springframework.stereotype.Service;
import pl.pjatk.movies.demo.models.Movie;
import pl.pjatk.movies.demo.repositories.IMovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> list;
    private final IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElse(null);
    }

    public Movie addNewMovie(String title) {
        return movieRepository.save(new Movie(title));
    }

    public Movie updateMovie(Integer id, String title) {
        Optional<Movie> movieById = movieRepository.findById(id);
        if (movieById.isPresent()) {
            movieById.get().setTitle(title);
            return movieRepository.save(movieById.get());
        }
        else
            return movieRepository.save(movieById.get());
    }

    public void deleteById(Integer id) {
        Movie movieById = getMovieById(id);
        movieRepository.delete(movieById);
    }
}