package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(userInputStream.getUserInput()).thenReturn("Quit");
        menu.startMenu();

        verify(printStream).println(contains("List Books"));
    }

    @Test
    public void shouldCallListBooksWhenListBooksOptionIsCalled() {
        when(userInputStream.getUserInput()).thenReturn("List Books", "Quit");

        menu.startMenu();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldContainAnOrderedListOfOptions() {
        when(userInputStream.getUserInput()).thenReturn("Quit");

        menu.startMenu();

        verify(printStream).println(contains("1."));
    }

    @Test
    public void shouldWarnUserWhenProvidedInvalidOption() {
        when(userInputStream.getUserInput()).thenReturn("Invalid Input!!", "Quit");

        menu.startMenu();

        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldHaveQuitAsAnOption() {
        when(userInputStream.getUserInput()).thenReturn("Quit");

        menu.startMenu();

        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void shouldQuitWhenQuitOptionIsSelected() {
        when(userInputStream.getUserInput()).thenReturn("Quit");

        menu.startMenu();

        verify(printStream).println(contains("Thank you"));
    }

    @Test
    public void shouldContinueRunningUntilUserQuits() {
        when(userInputStream.getUserInput()).thenReturn("List Books", "Quit");

        menu.startMenu();


        verify(printStream).println(contains("List Books"));
        verify(printStream).println(contains("Thank you"));
    }
}