package com.twu.biblioteca;

import java.util.Collection;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private Collection<Book> bookList;

    public Biblioteca(Collection<Book> books) {
        this.bookList = books;
    }

    public String listBooks() {
        int counter = 1;
        String formattedBookList = "";

        for (Book book : bookList) {
            formattedBookList += counter +". " + book + "\n";
            counter++;
        }
        return formattedBookList;
    }
}

