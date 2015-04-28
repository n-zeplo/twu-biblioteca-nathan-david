package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
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

//    @Test
//    public void shouldPrintListOfBooksTest() {
//        PrintStream printStream = mock(PrintStream.class);
//
//        Biblioteca biblioteca = new Biblioteca(printStream, "Welcome to Biblioteca");
//        biblioteca.startUserInterface();
//
//        verify(biblioteca).listBooks();
//
//    }
}
