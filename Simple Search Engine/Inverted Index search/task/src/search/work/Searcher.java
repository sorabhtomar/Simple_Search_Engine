package search.work;

import search.ui.UIManager;
import search.utils.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Will apply "Template method" design pattern in this.
public abstract class Searcher {
    private UIManager ui;
    private Map<String, Set<Integer>> invertedIndex;

    private List<String> rows;

    public Searcher() {
        this.ui = UIManager.getUIManager();

        rows = new ArrayList<>();
        invertedIndex = new HashMap<>();
    }

    // Template method: It describes the common algorithm, while the subclasses implement steps of the algorithm.
    // This pattern lets the subclasses implement the steps of the algorithm without changing that algorithm's skeleton.
    public void work(Arguments args) {
        readInputFile(args.getData());
        processRows();

        boolean exit = false;
        do {
            ui.menu();
            int option = Integer.parseInt(ui.getInputLine());
            ui.printOutput("");

            switch (option) {
                case 1:
                    // performing "search" on a row of data using "query" (by user)
                    ui.printOutput("Enter a name or email to search all suitable people.");
                    String query = ui.getInputLine().trim().toLowerCase();

                    Set<Integer> indices = search(args.getData(), invertedIndex, query);

                    if (indices == null) {
                        ui.printOutput("No matching people found.");
                    } else {
                        int count = indices.size();
                        ui.printOutput(String.format("%d persons found:", count));

                        ui.display(rows, indices);
                    }
                    break;

                case 2:
                    ui.printOutput("=== List of people ===");
                    ui.display(rows);
                    break;

                case 0:
                    ui.printOutput("Bye!");
                    exit = true;
                    break;

                default:
                    ui.printOutput("Incorrect option! Try again.");
                    break;
            }

            ui.printOutput("");

        } while (!exit);
    }

    // Primitive methods (with default implementation provided, for some steps).
    // This default implementation can be changed by the subclass if needed.
    private void readInputFile(String filePath) {
        try (Scanner scn = new Scanner(new File(filePath))) {
            while (scn.hasNextLine()) {
                rows.add(scn.nextLine());
            }
        } catch (FileNotFoundException e) {
            ui.printOutput("File not found!");
        }
    }

    private void processRows() {
        for (int i = 0; i < rows.size(); i++) {
            String[] words = rows.get(i).split("\\s+");

            for (int j = 0; j < words.length; j++) {
                String word = words[j].toLowerCase();

                if (invertedIndex.containsKey(word)) {
                    Set<Integer> indices = invertedIndex.get(word);
                    indices.add(i);

                } else {
                    Set<Integer> indices = new HashSet<>();
                    indices.add(i);

                    invertedIndex.put(word, indices);
                }
            }
        }
    }

    // Primitive methods (abstract i.e. which need to be implemented by the concrete class)
    public abstract Set<Integer> search(String algorithm, Map<String, Set<Integer>> invertedIndex, String query);
}
