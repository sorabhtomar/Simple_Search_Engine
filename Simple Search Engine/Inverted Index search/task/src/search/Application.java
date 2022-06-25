package search;

import search.algos.SearchContext;
import search.ui.UIManager;
import search.utils.Arguments;
import search.work.ConcreteSearcher;
import search.work.Searcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Application app;

    private String[] args;
    private Arguments arguments;
    private UIManager ui;

    private Application(String[] args) {
        this.args = args;
        this.arguments = Arguments.getArguments();
        this.ui = UIManager.getUIManager();
    }

    // Lazy Singleton Initialization
    public static Application getApp(String[] args) {
        if (app == null) {
            app = new Application(args);
        }

        return app;
    }

    private void processRunArguments() {
        int position = 0;
        while (position < args.length) {
            String option = args[position];

            switch (option) {
                case "--data":
                    arguments.setData(args[position + 1]);
                    position += 2;
                    break;

                default:
                    position += 1;
                    ui.printOutput("Invalid command line argument!");
                    break;
            }
        }
    }

    public void run() {
        processRunArguments();

        Searcher searcher = new ConcreteSearcher(new SearchContext());
        searcher.work(arguments);
    }
}
