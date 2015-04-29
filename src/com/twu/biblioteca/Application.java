package com.twu.biblioteca;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Application {
    private final Menu menu;

    public Application(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        menu.displayWelcomeMessage();
        menu.startMenu();
    }
}
