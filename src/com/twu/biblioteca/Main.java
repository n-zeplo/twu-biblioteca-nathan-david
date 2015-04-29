package com.twu.biblioteca;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out, new ArrayList<Book>());
        Menu menu = new Menu();
        Application application = new Application(biblioteca, menu);

        application.startUserInterface();
    }
}
