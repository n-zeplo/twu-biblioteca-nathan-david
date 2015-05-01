package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.commands.Command;

/**
 * Created by kprakobk on 5/1/15.
 */
public class CheckOutBookCommand implements Command {
    private Biblioteca biblioteca;

    public CheckOutBookCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.checkoutBook();
    }
}
