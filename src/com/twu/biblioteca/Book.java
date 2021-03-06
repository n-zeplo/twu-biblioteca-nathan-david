package com.twu.biblioteca;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Book {

    private String title;
    private String author;
    private String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%-50s|%-20s|%-4s", title, author, year);
    }
}
