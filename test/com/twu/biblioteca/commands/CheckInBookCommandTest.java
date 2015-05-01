package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by nzeplowi on 5/1/15.
 */
public class CheckInBookCommandTest {
    @Test
    public void shouldCheckInBookWhenExecute() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckInBookCommand checkInBookCommand = new CheckInBookCommand(biblioteca);

        checkInBookCommand.execute();

        verify(biblioteca).checkInBook();
    }

}