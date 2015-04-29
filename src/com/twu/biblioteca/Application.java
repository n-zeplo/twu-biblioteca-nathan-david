package com.twu.biblioteca;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Application {
    private final Biblioteca biblioteca;

    public Application(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void startUserInterface() {
        biblioteca.displayWelcomeMessage();
    }
}
