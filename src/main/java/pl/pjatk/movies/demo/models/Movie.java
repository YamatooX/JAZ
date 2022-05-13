package pl.pjatk.movies.demo.models;

public class Movie {

    private Integer id;
    private String title;
    private MovieCategory MovieCategory;

    public Movie() {
    }

    public Movie(Integer id, String title, MovieCategory MovieCategory) {
        this.id = id;
        this.title = title;
        this.MovieCategory = MovieCategory;
    }

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", MovieCategory=" + MovieCategory +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MovieCategory getCategory() {
        return MovieCategory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(MovieCategory MovieCategory) {
        this.MovieCategory = MovieCategory;
    }
}
