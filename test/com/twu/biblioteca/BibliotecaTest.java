package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    @Test
    public void shouldWelcomeUserOnStartTest() {
        PrintStream printStream = mock(PrintStream.class);

        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.startUserInterface();

        verify(printStream).println(contains("Welcome"));

    }

    @Test
    public void shouldPrintListOfBooksTest() {
        PrintStream printStream = mock(PrintStream.class);

        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.listBooks();

        verify(printStream).println(contains("1."));
        verify(printStream).println(contains("2."));
    }
}
