package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private String welcomeMessage;
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream, String welcomeMessage) {
        this.printStream = printStream;
        this.welcomeMessage = welcomeMessage;
    }

    public void startUserInterface() {
        this.printStream.println(welcomeMessage);
    }
}

