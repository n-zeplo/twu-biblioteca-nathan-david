package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private UserInputStream userInputStream;
    private List<String> options;
    private Map<String, MenuCommand> mapMenuCommand = new HashMap<String, MenuCommand>();


    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInputStream userInputStream) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInputStream = userInputStream;
        options = new ArrayList<String>();
        options.add("List Books");
        options.add("Quit");
        mapMenuCommand.put("List Books", new ListBooksCommand(this.biblioteca));

    }

    public void displayWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca!");
    }

    public void startMenu() {
        displayMenu();
        String userInput = userInputStream.getUserInput();
        while (!userInput.equals("Quit")) {
            checkUserInput(userInput);
            userInput = userInputStream.getUserInput();
        }
        printStream.println("Thank you");
    }

    private void displayMenu() {
        int counter = 1;
        for (String option : options) {
            printStream.println(counter + ". " + option);
            counter++;
        }
    }

    private void checkUserInput(String userInput) {

        if (mapMenuCommand.containsKey(userInput)){
            mapMenuCommand.get(userInput).execute();
        } else {
            printStream.println("Select a valid option!");
        }
    }




}
