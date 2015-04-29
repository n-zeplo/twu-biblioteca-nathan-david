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

    public void startUserInterface() {
        this.printStream.println("Welcome to Biblioteca!");
        this.listBooks();
    }

    public void listBooks() {
        for (int i = 0; i < bookList.size(); ++i) {
            this.printStream.println(i+1 + ". " + bookList.get(i).toString());
        }
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}

