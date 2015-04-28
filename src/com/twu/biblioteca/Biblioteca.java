package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void startUserInterface() {
        this.printStream.println("Welcome to Biblioteca!");
        this.listBooks();
    }

    public void listBooks() {
        this.printStream.println("1.");
        this.printStream.println("2.");
    }
}

