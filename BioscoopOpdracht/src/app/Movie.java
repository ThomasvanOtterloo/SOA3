package app;

public class Movie {
    private String title;
    private MovieScreening[] screenings;


    public Movie(String title) {
        this.title = title;
    }

    public void addScreening(MovieScreening screening) {

    }

    @Override
    public String toString() {
        return "app.Movie{" +
                "title='" + title + '\'' +
                '}';
    }

}
