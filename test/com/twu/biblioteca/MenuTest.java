package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class MenuTest {


    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;
    private UserInputStream userInputStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        userInputStream = mock(UserInputStream.class);
        menu = new Menu(printStream, biblioteca, userInputStream);
    }

    @Test
    public void shouldWelcomeUserOnStartTest() {
        menu.displayWelcomeMessage();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldStartMenuByDisplayingOptions() {
        when(userInputStream.getUserInput()).thenReturn("List Books");

        menu.chooseOptions();

        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldCallListBooksWhenListBooksOptionIsCalled() {
        when(userInputStream.getUserInput()).thenReturn("List Books");

        menu.chooseOptions();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldDisplayMessageForInvalidUserInput(){
        when(userInputStream.getUserInput()).thenReturn("Slimy").thenReturn("List Books");

        menu.chooseOptions();

        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldAllowUserToChooseAgainAfterInvalidInput() {
        when(userInputStream.getUserInput()).thenReturn("Slimy", "List Books");

        menu.chooseOptions();

        verify(printStream, atLeast(2)).println(contains("List Books"));
    }

}