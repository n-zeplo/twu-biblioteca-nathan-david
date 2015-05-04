package com.twu.biblioteca.Media;

/**
 * Created by nzeplowi on 5/4/15.
 */
public class Movie implements Media {
    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }


    @Override
    public String getInformation() {
        return String.format("%-25s|%-5s|%-20s|%-7s", name, year, director, rating);
    }
}
