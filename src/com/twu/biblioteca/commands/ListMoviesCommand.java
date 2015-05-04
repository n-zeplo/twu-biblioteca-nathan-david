package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by nzeplowi on 5/4/15.
 */
public class ListMoviesCommand implements Command{
    private Biblioteca biblioteca;

    public ListMoviesCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listMovies();
    }
}
