package search.ui;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UIManager {
    private static UIManager manager;
    private Scanner scn;
    private UIManager() {
        scn = new Scanner(System.in);
    }

    public static UIManager getUIManager() {
        if (manager == null) {
            manager = new UIManager();
        }

        return manager;
    }

    public void menu() {
        printOutput("=== Menu ===");
        printOutput("1. Find a person");
        printOutput("2. Print all people");
        printOutput("0. Exit");
    }

    public void display(List<String> rows) {
        for (String row : rows) {
            printOutput(row);
        }
    }

    public void display(List<String> rows, Set<Integer> indices) {
        for (int index : indices) {
            printOutput(rows.get(index));
        }
    }

    public String getInputLine() {
        String input = scn.nextLine();
        return input;
    }

    public void printOutput(String message) {
        System.out.println(message);
    }
}
