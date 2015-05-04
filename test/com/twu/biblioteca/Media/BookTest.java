package com.twu.biblioteca.Media;

import com.twu.biblioteca.Media.Book;
import com.twu.biblioteca.Media.Media;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class BookTest {

    @Test
    public void toStringShouldPrintTitleAuthorAndYearPublished() {
        Media book = new Book("Title", "Author", "Year");

        assertThat(book.getInformation(), allOf(containsString("Title"), containsString("Author"), containsString("Year")));
    }

    @Test
    public void toStringShouldFormatOutputToUseColumns() {
        Media book = new Book("Title", "Author", "Year");

        assertEquals(book.getInformation(), "Title                                             |Author              |Year");
    }
}
