package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Application app;

    private String[] args;

    // data: holds the value of command line argument/flag/option "--data"
    private String data;

    private Scanner scn = new Scanner(System.in);
    private List<String> rows;

    private Application(String[] args) {
        this.args = args;
    }

    // Lazy Singleton Initialization
    public static Application getApp(String[] args) {
        if (app == null) {
            app = new Application(args);
        }

        return app;
    }

    private void userInput(String[] args) {
        System.out.println("Enter the number of people:");
        int n = Integer.parseInt(scn.nextLine());

        System.out.println("Enter all people:");
        for (int i = 0; i < n; i++) {
            rows.add(scn.nextLine());
        }

        System.out.println();
    }

    private void processRunArguments() {
        int position = 0;
        while (position < args.length) {
            String option = args[position];

            switch (option) {
                case "--data":
                    data = args[position + 1];
                    position += 2;
                    break;

                default:
                    System.out.println("Error! Invalid command line arguments!");
                    break;
            }
        }
    }

    private void readInputFile(String filePath) {
         rows = new ArrayList<>();

         try (Scanner scn = new Scanner(new File(filePath))) {
             while (scn.hasNextLine()) {
                 rows.add(scn.nextLine());
             }
         } catch (FileNotFoundException e) {
             System.out.println("File not found!");
         }
    }

    public void run() {
        processRunArguments();
        readInputFile(data);

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

    public void menu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }


    private void search() {
        // performing "linear search" on a row of data using "query" (by user)
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scn.nextLine().toLowerCase();

        List<String> result = linearSearch(rows, query);
        display(result);
    }

    private List<String> linearSearch(List<String> rows, String query) {
        List<String> result = new ArrayList<>();

        for (String row : rows) {
            if (row.toLowerCase().contains(query)) {
                result.add(row);
            }
        }

        return result;
    }

    private void display(List<String> rows) {
        for (String row : rows) {
            System.out.println(row);
        }
    }
}
