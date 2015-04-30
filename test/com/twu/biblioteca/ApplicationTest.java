package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class ApplicationTest {
    private Application application;
    private Menu menu;

    @Before
    public void setUp() {
        menu = mock(Menu.class);
        application = new Application(menu);
    }
    @Test
    public void shouldWelcomeUserOnStart() {
        application.start();

        verify(menu).displayWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuOnStart() {
        application.start();

        verify(menu).startMenu();
    }
}
