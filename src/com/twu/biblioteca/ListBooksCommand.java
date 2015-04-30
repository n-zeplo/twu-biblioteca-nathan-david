package com.twu.biblioteca;

/**
 * Created by kprakobk on 4/30/15.
 */
public class ListBooksCommand extends MenuCommand {
    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listBooks();
    }
}
