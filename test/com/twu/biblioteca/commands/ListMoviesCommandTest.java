package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 5/4/15.
 */
public class ListMoviesCommandTest {

    private Biblioteca biblioteca;
    private ListMoviesCommand listMoviesCommand;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);
        listMoviesCommand = new ListMoviesCommand(biblioteca);

    }

    @Test
    public void shouldListMovies() {
        listMoviesCommand.execute();

        verify(biblioteca).listMovies();
    }
}
