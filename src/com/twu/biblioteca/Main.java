package com.twu.biblioteca;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Ender's Game", "Someone", "1985"));
        books.add(new Book("The Hobbit", "J.R. Tolkien", "1940"));
        books.add(new Book("Harry Potter and the Story of the long Title", "Some British Lady", "1998"));
        Biblioteca biblioteca = new Biblioteca(System.out, books);
        Menu menu = new Menu(System.out, biblioteca);
        Application application = new Application(menu);

        application.startUserInterface();
    }
}
