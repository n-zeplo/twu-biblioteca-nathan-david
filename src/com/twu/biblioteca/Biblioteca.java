package com.twu.biblioteca;

import java.io.PrintStream;
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
        printStream.println("Input the book you would like to checkout:");
        String bookNumber = userInputStream.getUserInput();

        if (validBookForCheckout(bookNumber)) {
            moveBookToCheckedOutList(Integer.parseInt(bookNumber));
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    private void moveBookToCheckedOutList(Integer bookNumber) {
        Book checkedOutBook = bookList.remove(bookNumber - 1);
        checkedOutBooks.add(checkedOutBook);
    }

    private boolean validBookForCheckout(String bookNumber) {
        return bookNumber.matches("^[1-9]+") && bookList.size() >= Integer.parseInt(bookNumber);
    }

    public void checkInBook() {
        //List CheckedOutBooks();
        printStream.println("Input the book you would like to return:");
        String bookNumber = userInputStream.getUserInput();

        if (validBookForCheckIn(bookNumber)) {
            moveBookToBookList(Integer.parseInt(bookNumber));
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That book is not available.");
        }
    }

    private boolean validBookForCheckIn(String bookNumber) {
        return bookNumber.matches("^[1-9]+") && checkedOutBooks.size() >= Integer.parseInt(bookNumber);
    }


    private void moveBookToBookList(int bookNumber) {
        Book returningBook;
        returningBook = checkedOutBooks.remove(bookNumber - 1);
        bookList.add(returningBook);
    }
}

