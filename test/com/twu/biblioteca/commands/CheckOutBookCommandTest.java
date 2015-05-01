package com.twu.biblioteca.commands;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.commands.CheckOutBookCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 5/1/15.
 */
public class CheckOutBookCommandTest {
    @Test
    public void shouldCheckoutBookWhenExecute() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckOutBookCommand checkOutBookCommand = new CheckOutBookCommand(biblioteca);

        checkOutBookCommand.execute();

        verify(biblioteca).checkoutBook();
    }
}