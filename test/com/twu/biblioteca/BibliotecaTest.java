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
        String welcomeMessage = "Welcome to Biblioteca";

        Biblioteca biblioteca = new Biblioteca(printStream, welcomeMessage);
        biblioteca.startUserInterface();

        verify(printStream).println(welcomeMessage);

    }
}
