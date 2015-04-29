package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class MenuTest {


    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, biblioteca);
    }
    @Test
    public void shouldWelcomeUserOnStartTest() {
        menu.displayWelcomeMessage();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldStartMenuByDisplayingOptions() {
        menu.startMenu();

        verify(printStream).println(contains("List Books"));
    }

}