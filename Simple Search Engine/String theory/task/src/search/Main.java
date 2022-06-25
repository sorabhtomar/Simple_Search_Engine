package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] words = scn.nextLine().split("\\s+");
        String searchWord = scn.next();

        // idx: index of the "search word"
        // Initialized with an invalid index. In this case, 0 is also an invalid index
        int idx = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(searchWord)) {
                idx = i + 1;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("Not found");
            return;
        }

        System.out.println(idx);
    }
}
