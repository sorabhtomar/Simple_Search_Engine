package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] words = scn.nextLine().split("\\s+");
        String searchWord = scn.next();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(searchWord)) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println("Not found");
    }
}
