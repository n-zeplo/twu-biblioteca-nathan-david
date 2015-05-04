package com.twu.biblioteca;

import com.twu.biblioteca.Media.Media;

import java.io.PrintStream;
import java.util.List;


public class Biblioteca {
    private PrintStream printStream;
    private List<Media> availableBooks;
    private List<Media> unavailableBooks;
    private List<Media> availableMovies;
    private UserInputStream userInputStream;

    public Biblioteca(PrintStream printStream, List<Media> books, List<Media> unavailableBooks, List<Media> availableMovies, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.availableBooks = books;
        this.unavailableBooks = unavailableBooks;
        this.availableMovies = availableMovies;
        this.userInputStream = userInputStream;
    }
    private void list(List<Media> mediaList){
        int counter = 1;
        for (Media medium : mediaList) {
            printStream.println(counter + ". " + medium.getInformation());
            counter++;
        }
    }
    public void listAvailableBooks() {
        list(availableBooks);
    }


    public void checkoutBook() {
        checkOut(availableBooks, unavailableBooks, "book");
    }

    private void checkOut(List<Media> availableMedia, List<Media> unavailableMedia, String mediaType) {
        String bookNumber = getBookNumberFromUser("Input the " + mediaType + " you would like to check out:");

        if (isValidBookNumberForList(bookNumber, availableMedia)) {
            moveBookBetweenLists(Integer.parseInt(bookNumber), availableMedia, unavailableMedia);
            printStream.println("Thank you! Enjoy the " + mediaType);
        } else {
            printStream.println("That " + mediaType + " is not available.");
        }
    }

    public void checkInBook() {
        checkIn(unavailableBooks, availableBooks, "book");
    }

    private void checkIn(List<Media> unavailableMedia, List<Media> availableMedia, String mediaType) {
        list(unavailableMedia);
        String bookNumber = getBookNumberFromUser("Input the " + mediaType + " you would like to return:");

        if (isValidBookNumberForList(bookNumber, unavailableMedia)) {
            moveBookBetweenLists(Integer.parseInt(bookNumber), unavailableMedia, availableMedia);
            printStream.println("Thank you for returning the " + mediaType + ".");
        } else {
            printStream.println("That is not a valid " + mediaType + " to return.");
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

    public void listMovies() {
        list(availableMovies);
    }
}

