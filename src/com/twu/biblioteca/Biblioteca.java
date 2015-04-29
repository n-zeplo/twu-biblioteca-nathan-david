package com.twu.biblioteca;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private ArrayList<Book> bookList;

    public Biblioteca(PrintStream printStream, ArrayList<Book> books) {
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

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}

