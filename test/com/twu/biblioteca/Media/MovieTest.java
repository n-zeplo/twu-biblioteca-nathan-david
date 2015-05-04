package com.twu.biblioteca.Media;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by nzeplowi on 5/4/15.
 */
public class MovieTest {

    private Movie movie;
    private String title;
    private String year;
    private String director;
    private String rating;

    @Before
    public void setUp() throws Exception {
        title = "Ex Machina";
        year = "2015";
        director = "Australian Dude";
        rating = "10";
        movie = new Movie(title, year, director, rating);

    }

    @Test
    public void shouldContainMovieInformation() {
        assertThat(movie.getInformation(), allOf(containsString(title), containsString(year), containsString(director), containsString(rating)));

    }
}
