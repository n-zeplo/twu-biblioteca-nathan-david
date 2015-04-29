package com.twu.biblioteca;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private Collection<Book> bookList;

    public Biblioteca(PrintStream printStream, Collection<Book> books) {
        this.printStream = printStream;
        this.bookList = books;
    }

    public void listBooks() {
        int counter = 1;
        for (Book book : bookList) {
            this.printStream.println(counter +". " + book);
            counter++;
        }
    }

    public Collection<Book> getBookList() {
        return bookList;
    }
}

