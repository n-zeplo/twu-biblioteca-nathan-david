package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by nzeplowi on 5/1/15.
 */
public class CheckInBookCommand implements Command {
    private Biblioteca biblioteca;

    public CheckInBookCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.checkInBook();
    }
}
