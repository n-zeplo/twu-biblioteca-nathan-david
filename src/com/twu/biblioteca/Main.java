package com.twu.biblioteca;

import com.twu.biblioteca.Media.Book;
import com.twu.biblioteca.Media.Media;
import com.twu.biblioteca.Media.Movie;
import com.twu.biblioteca.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out, books(), new ArrayList<Media>(), movies(), new UserInputStream());
        Menu menu = new Menu(System.out, biblioteca, new UserInputStream(), initializeMapMenu(biblioteca));

        menu.start();
    }

    private static Map<String, Command> initializeMapMenu(Biblioteca biblioteca) {
        Map<String, Command> mapMenuCommand = new HashMap<String, Command>();
        mapMenuCommand.put("List Books", new ListBooksCommand(biblioteca));
        mapMenuCommand.put("List Movies", new ListMoviesCommand(biblioteca));
        mapMenuCommand.put("Check Out Book", new CheckOutBookCommand(biblioteca));
        mapMenuCommand.put("Check In Book", new CheckInBookCommand(biblioteca));

        return mapMenuCommand;
    }

    private static List<Media> books() {
        List<Media> books = new ArrayList<Media>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));

        return books;
    }

    private static List<Media> movies() {
        List<Media> movies = new ArrayList<>();
        movies.add(new Movie("Ex Machina", "2015", "Alex Garland", "10"));
        movies.add(new Movie("Eyes Wide Shut", "1998", "Stanley Kubrick", "10"));
        movies.add(new Movie("AI", "2001", "Stephen Speilberg", "4"));

        return movies;
    }
}
