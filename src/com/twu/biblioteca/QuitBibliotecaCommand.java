package com.twu.biblioteca;

/**
 * Created by kprakobk on 4/30/15.
 */
public class QuitBibliotecaCommand implements Command {
    private Biblioteca biblioteca;

    public QuitBibliotecaCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.setRunning(false);
    }
}
