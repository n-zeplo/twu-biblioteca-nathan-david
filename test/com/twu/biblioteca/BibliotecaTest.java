package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {

        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printStream);
    }


    @Test
    public void shouldWelcomeUserOnStartTest() {
        biblioteca.startUserInterface();

        verify(printStream).println(contains("Welcome"));

    }

    @Test
    public void shouldPrintListOfBooksTest() {
        biblioteca.listBooks();

        verify(printStream).println(contains("1."));
        verify(printStream).println(contains("2."));
    }

}
