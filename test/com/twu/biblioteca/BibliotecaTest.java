package com.twu.biblioteca;

import com.twu.biblioteca.Media.Media;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.allOf;
import static org.mockito.Mockito.*;


/**
 * Created by nzeplowi on 4/28/15.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private ArrayList<Media> books;
    private Media media;
    private UserInputStream userInputStream;
    private ArrayList<Media> unavailableBooks;

    @Before
    public void setUp() {
        userInputStream = mock(UserInputStream.class);
        printStream = mock(PrintStream.class);
        media = mock(Media.class);
        books = new ArrayList<Media>();
        books.add(media);
        unavailableBooks = new ArrayList<Media>();
        unavailableBooks.add(media);
        biblioteca = new Biblioteca(printStream, books, unavailableBooks, userInputStream);
    }

    @Test
    public void shouldPrintEachBook() {
        biblioteca.listAvailableBooks();

        verify(printStream, times(books.size())).println(anyString());
    }

    @Test
    public void shouldPrintBookObjectsFromListBooks(){
        String stubbedResponse = "Test Media";
        when(media.getInformation()).thenReturn(stubbedResponse);
        biblioteca.listAvailableBooks();

        verify(printStream).println(contains(stubbedResponse));
    }

    @Test
    public void shouldGetUserInputOnCheckout() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();

        verify(userInputStream).getUserInput();
    }

    @Test
    public void shouldAskUserWhatBookTheyWantToCheckout() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();

        verify(printStream).println("Input the book you would like to check out:");
    }

    @Test
    public void shouldCheckoutSelectedBook() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();
        biblioteca.listAvailableBooks();

        verify(printStream, never()).println(contains("Title"));
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulCheckout() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulCheckout() {
        when(userInputStream.getUserInput()).thenReturn("3");

        biblioteca.checkoutBook();

        verify(printStream).println(contains("That book is not available."));
    }

    @Test
    public void shouldHaveBookAfterCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkInBook();

        assertTrue(unavailableBooks.isEmpty());
    }

    @Test
    public void shouldDisplaySuccessMessageOnSuccessfulCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("1");

        biblioteca.checkInBook();

        verify(printStream).println(contains("Thank you for returning the book."));
    }

    @Test
    public void shouldDisplayUnsuccessfulMessageOnUnsuccessfulCheckIn() {
        when(userInputStream.getUserInput()).thenReturn("Invalid Book Number");

        biblioteca.checkInBook();

        verify(printStream).println(contains("That is not a valid book to return."));
    }
}
