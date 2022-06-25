package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Own {
    // private static Scanner scn = new Scanner(System.in);
    //
    // public static void main(String[] args) {
    //
    //     System.out.println("Enter the number of rows of data: ");
    //     int n = Integer.parseInt(scn.nextLine());
    //
    //     System.out.println("Enter all the rows of data: ");
    //     String[] rows = new String[n];
    //     for (int i = 0; i < rows.length; i++) {
    //         rows[i] = scn.nextLine();
    //     }
    //
    //     // a separator line
    //     System.out.println();
    //
    //     System.out.println("Enter the number of search queries: ");
    //     int m = Integer.parseInt(scn.nextLine());
    //
    //     // a separator line
    //     System.out.println();
    //
    //     for (int i = 0; i < m; i++) {
    //         // performing "linear search" on a row of data using "query" (by user)
    //         System.out.println("Enter data to search people: ");
    //         String query = scn.nextLine().toLowerCase();
    //
    //         List<String> result = linearSearch(rows, query);
    //
    //         if (result.isEmpty()) {
    //             System.out.println("No matching row(s) found.");
    //         } else {
    //             System.out.println("Found row(s): ");
    //             for (String line : result) {
    //                 System.out.println(line);
    //             }
    //         }
    //
    //         System.out.println();
    //     }
    // }
    //
    // private static List<String> linearSearch(String[] rows, String query) {
    //     List<String> result = new ArrayList<>();
    //
    //     for (String row : rows) {
    //         // cols: columns of data
    //         String[] cols = row.split("\\|");
    //
    //         for (String col : cols) {
    //             if (col.toLowerCase().equals(query)) {
    //                 result.add(row);
    //             }
    //         }
    //     }
    //
    //     return result;
    // }
}
