package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class ApplicationTest {
    private Application application;
    private Biblioteca biblioteca;
    private Menu menu;

    @Before
    public void setUp() {
        biblioteca = mock(Biblioteca.class);
        menu = mock(Menu.class);
        application = new Application(biblioteca, menu);
    }
    @Test
    public void shouldWelcomeUserOnStart() {
        application.startUserInterface();

        verify(biblioteca).displayWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuOnStart() {
        application.startUserInterface();

        verify(menu).displayOptions();
    }
}
