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
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private ArrayList<Book> books;
    private Book book1;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        book1 = new Book("Title", "Author", "Year");
        books = new ArrayList<Book>();
        books.add(book1);
        biblioteca = new Biblioteca(printStream, books);
    }
    @Test
    public void shouldWelcomeUserOnStartTest() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        Application application = new Application(biblioteca);

        application.startUserInterface();

        verify(biblioteca).displayWelcomeMessage();
    }
}
