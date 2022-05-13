package pl.pjatk.movies.demo.services;

import org.springframework.stereotype.Service;
import pl.pjatk.movies.demo.models.Movie;
import pl.pjatk.movies.demo.models.MovieCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> list;

    public MovieService() {
        list = new ArrayList<Movie>();
        list.add(new Movie(1, "Twoje uszy", MovieCategory.HORROR));
        list.add(new Movie(2, "Twoje oczy", MovieCategory.ROMANCE));
        list.add(new Movie(3, "Twoje nogi", MovieCategory.DRAMA));
        list.add(new Movie(4, "Twoje noże", MovieCategory.ACTION));
        list.add(new Movie(5, "Twoje libido", MovieCategory.SCIFI));
    }


    public List<Movie> getAllMovies() {
        return list;
    }

    public Movie getMovieById(Integer id) {
        return list.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Movie addNewMovie(String title) {
        return new Movie(title);
    }

    public Movie updateMovie(Integer id, String title) {
        Movie movieById = getMovieById(id);
        if (movieById != null) {
            movieById.setTitle(title);
        }
        return movieById;
    }
    public void deleteById(Integer id){
        Movie movieById = getMovieById(id);
        if (getMovieById(id) != null) {
            list.remove(movieById);
        }
    }
}