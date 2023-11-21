package Streams;

public class Movie {
    private String title;
    private Genre genre;
    private int likes;

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public Genre getGenre() {
        return genre;
    }

    public Movie(String title, Genre genre, int likes) {
        this.title = title;
        this.genre = genre;
        this.likes = likes;
    }
}
