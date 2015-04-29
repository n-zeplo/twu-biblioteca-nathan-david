package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private UserInputStream userInputStream;
    private List<String> options;

    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInputStream = userInputStream;
        options = new ArrayList<String>();
        options.add("List Books");
        options.add("Quit");
    }

    public void displayWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca!");
    }

    public void startMenu() {
        displayMenu();
        String userInput = userInputStream.getUserInput();
        checkUserInput(userInput);
    }

    private void displayMenu() {
        int counter = 1;
        for (String option : options) {
            printStream.println(counter + ". " + option);
            counter++;
        }
    }

    private void checkUserInput(String userInput) {
        if (userInput.equals("List Books")){
            biblioteca.listBooks();
        } else {
            printStream.println("Select a valid option!");
        }
    }


}
