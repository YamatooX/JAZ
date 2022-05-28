package pl.pjatk.movies.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String title;
    @Column(name = "category")
    private String movieCategory;

    public Movie() {
    }

    public Movie(Integer id, String title, String movieCategory) {
        this.id = id;
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", MovieCategory=" + movieCategory +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return movieCategory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String MovieCategory) {
        this.movieCategory = MovieCategory;
    }
}
