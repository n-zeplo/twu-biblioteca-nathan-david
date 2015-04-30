package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;


import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class MenuTest {


    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;
    private Option option;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        option = mock(Option.class);
        menu = new Menu(printStream, biblioteca, option);
    }

    @Test
    public void shouldWelcomeUserOnStartTest() {
        menu.displayWelcomeMessage();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldStartMenuByDisplayingOptions() {
        when(option.returnUserOption()).thenReturn("List Books", "Quit");

        menu.chooseOptions();

        verify(printStream, atLeastOnce()).println(Matchers.startsWith("Options:"));
    }

    @Test
    public void shouldCallListBooksWhenListBooksOptionIsCalled() {
        when(option.returnUserOption()).thenReturn("List Books", "Quit");

        menu.chooseOptions();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldDisplayMessageForInvalidUserInput(){
        when(option.returnUserOption()).thenReturn("Slimy", "List Books", "Quit");

        menu.chooseOptions();

        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldAllowUserToChooseAgainAfterInvalidInput() {
        when(option.returnUserOption()).thenReturn("Slimy", "List Books","Quit");

        menu.chooseOptions();

        verify(printStream, atLeast(2)).println(contains("List Books"));
    }

}