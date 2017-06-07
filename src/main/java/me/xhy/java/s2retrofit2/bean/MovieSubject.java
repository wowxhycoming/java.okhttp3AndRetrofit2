package me.xhy.java.s2retrofit2.bean;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by xuhuaiyu on 2017/6/1.
 */
public class MovieSubject {

    private Rating rating;
    private String[] genres;
    private String title;
    private Date releaseDate;

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MovieSubject{" +
        "rating=" + rating +
        ", genres=" + Arrays.toString(genres) +
        ", title='" + title + '\'' +
        ", releaseDate=" + releaseDate +
        '}';
    }

}
