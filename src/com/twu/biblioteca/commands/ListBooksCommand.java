package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by kprakobk on 4/30/15.
 */
public class ListBooksCommand implements Command {
    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listAvailableBooks();
    }
}
