package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;

    public Menu(PrintStream printStream, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
    }

    public void displayWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca!");
    }

    public void startMenu() {
        printStream.println("List Books");
    }
}
