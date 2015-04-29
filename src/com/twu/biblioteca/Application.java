package com.twu.biblioteca;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Application {
    private final Biblioteca biblioteca;
    private final Menu menu;

    public Application(Biblioteca biblioteca, Menu menu) {
        this.biblioteca = biblioteca;
        this.menu = menu;
    }

    public void startUserInterface() {
        biblioteca.displayWelcomeMessage();
        menu.displayOptions();
    }
}
