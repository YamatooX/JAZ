package pl.pjatk.movies.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.movies.demo.models.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
