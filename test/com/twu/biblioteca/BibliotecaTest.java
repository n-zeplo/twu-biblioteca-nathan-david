package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Collection<Book> books;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(printStream, books);
    }


    @Test
    public void shouldDisplayAllBookInformation(){
        Book book1 = new Book("Title", "Author", "Year");
        books.add(book1);
        Book book2 = new Book("Title2", "Author2", "Year2");
        books.add(book2);

        biblioteca.listBooks();

        verify(printStream).println(contains(book1.toString()));
        verify(printStream).println(contains(book2.toString()));

    }

}
