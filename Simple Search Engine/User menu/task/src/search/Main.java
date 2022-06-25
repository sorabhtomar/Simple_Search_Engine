package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scn = new Scanner(System.in);
    private static List<String> rows = new ArrayList<>();

    private static void userInput() {
        System.out.println("Enter the number of people:");
        int n = Integer.parseInt(scn.nextLine());

        System.out.println("Enter all people:");
        for (int i = 0; i < n; i++) {
            rows.add(scn.nextLine());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        userInput();

        boolean exit = false;
        do {
            menu();
            int option = Integer.parseInt(scn.nextLine());
            System.out.println();

            switch (option) {
                case 1:
                    search();
                    break;

                case 2:
                    System.out.println("=== List of people ===");
                    display(rows);
                    break;

                case 0:
                    exit = true;
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }

            System.out.println();

        } while (!exit);
    }

    public static void menu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }


    private static void search() {
        // performing "linear search" on a row of data using "query" (by user)
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scn.nextLine().toLowerCase();

        List<String> result = linearSearch(rows, query);

        // if (result.isEmpty()) {
        //     System.out.println("No matching people found.");
        // } else {
        //     System.out.println("Found people:");
        //     display(result);
        // }
        display(result);
    }

    private static List<String> linearSearch(List<String> rows, String query) {
        List<String> result = new ArrayList<>();

        for (String row : rows) {
            if (row.toLowerCase().contains(query)) {
                result.add(row);
            }
        }

        return result;
    }

    private static void display(List<String> rows) {
        for (String row : rows) {
            System.out.println(row);
        }
    }
}