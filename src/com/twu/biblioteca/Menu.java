package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private Option option;

    public Menu(PrintStream printStream, Biblioteca biblioteca, Option option) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.option = option;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome to Biblioteca!");
    }

    public void chooseOptions() {
        String userInput = "Run";
        while(!userInput.equals("Quit")) {
            displayOptions();
            userInput = option.returnUserOption();
            checkUserInput(userInput);
        }
    }

    private void displayOptions() {
        printStream.println("Options:\nList Books");
    }

    private void checkUserInput(String userInput) {
        if (userInput.equals("List Books")){
           printStream.println(biblioteca.listBooks());
        } else if(userInput.equals("Quit")) {
            return;
        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
