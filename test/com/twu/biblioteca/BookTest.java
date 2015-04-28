package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class BookTest {

    @Test
    public void toStringShouldPrintTitleAuthorAndYearPublished() {
        Book book = new Book("Title", "Author", "Year");

        assertEquals(book.toString(), "Title, Author, Year");
    }
}
