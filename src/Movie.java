/**
 * Created by alexanderhughes on 2/10/16.
 */
public class Movie {
    String title;
    String director;
    String star;
    String genre;
    int length;

    public Movie() {
    }

    public Movie(String title, String director, String star, String genre, int length) {
        this.title = title;
        this.director = director;
        this.star = star;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getStar() {
        return star;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }
}
