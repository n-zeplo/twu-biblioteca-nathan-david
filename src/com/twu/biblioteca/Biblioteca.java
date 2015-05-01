package com.twu.biblioteca;

import org.mockito.internal.util.collections.ArrayUtils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nzeplowi on 4/28/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private List<Book> bookList;
    private UserInputStream userInputStream;
    private List<Book> checkedOutBooks = new ArrayList<Book>();

    public Biblioteca(PrintStream printStream, List<Book> books, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.bookList = books;
        this.userInputStream = userInputStream;
    }

    public void listBooks() {
        int counter = 1;
        for (Book book : bookList) {
            this.printStream.println(counter + ". " + book);
            counter++;
        }
    }

    public void checkoutBook() {
        printStream.println("Input the book do you would like to checkout?");
        String bookNumber = userInputStream.getUserInput();

        if (bookNumber.matches("^[1-9]+")) {
            Book checkedOutBook = bookList.remove(Integer.parseInt(bookNumber) - 1);
            checkedOutBooks.add(checkedOutBook);
            printStream.println("Thank you! Enjoy the book");
        };
    }
}

