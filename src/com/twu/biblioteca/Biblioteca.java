package com.twu.biblioteca;

import com.twu.biblioteca.Media.Media;

import java.io.PrintStream;
import java.util.List;


public class Biblioteca {
    private PrintStream printStream;
    private List<Media> availableBooks;
    private List<Media> unavailableBooks;
    private UserInputStream userInputStream;

    public Biblioteca(PrintStream printStream, List<Media> books, List<Media> unavailableBooks, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.availableBooks = books;
        this.unavailableBooks = unavailableBooks;
        this.userInputStream = userInputStream;
    }
    private void list(List<Media> mediaList){
        int counter = 1;
        for (Media book : mediaList) {
            this.printStream.println(counter + ". " + book);
            counter++;
        }
    }
    public void listAvailableBooks() {
        list(availableBooks);
    }


    public void checkoutBook() {
        String bookNumber = getBookNumberFromUser("Input the book you would like to checkout:");

        if (isValidBookNumberForList(bookNumber, availableBooks)) {
            moveBookBetweenLists(Integer.parseInt(bookNumber), availableBooks, unavailableBooks);
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    public void checkInBook() {
        list(unavailableBooks);
        String bookNumber = getBookNumberFromUser("Input the book you would like to return:");

        if (isValidBookNumberForList(bookNumber, unavailableBooks)) {
            moveBookBetweenLists(Integer.parseInt(bookNumber), unavailableBooks, availableBooks);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private boolean isValidBookNumberForList(String bookNumber, List<Media> list) {
        return bookNumber.matches("^[1-9]+") && list.size() >= Integer.parseInt(bookNumber);
    }

    private String getBookNumberFromUser(String prompt) {
        printStream.println(prompt);
        return userInputStream.getUserInput();
    }

    private void moveBookBetweenLists(int bookNumber, List<Media> source, List<Media> destination) {
        Media bookToMove = source.remove(bookNumber - 1);
        destination.add(bookToMove);
    }
}

