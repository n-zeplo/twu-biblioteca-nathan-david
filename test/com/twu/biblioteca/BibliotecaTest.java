package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

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
        biblioteca.startUserInterface();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldCallPrintLnForEachBook() {
        biblioteca.listBooks();

        verify(printStream, times(biblioteca.getBookList().size())).println(anyString());
    }

    @Test
    public void shouldPrintListOfBooksAfterWelcomeMessageTest() {
        shouldWelcomeUserOnStartTest();

        verify(printStream, times(biblioteca.getBookList().size() + 1 )).println(anyString());
    }

    @Test
    public void shouldPrintBookObjectsFromListBooks(){
        biblioteca.listBooks();

        verify(printStream).println(contains(book1.toString()));
    }

}
