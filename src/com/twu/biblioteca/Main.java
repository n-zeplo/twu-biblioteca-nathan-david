package com.twu.biblioteca;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out);
        biblioteca.startUserInterface();
    }
}
