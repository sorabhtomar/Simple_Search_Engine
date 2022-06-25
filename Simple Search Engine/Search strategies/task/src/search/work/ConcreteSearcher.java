package search.work;

import search.algos.SearchAll;
import search.algos.SearchAny;
import search.algos.SearchNone;
import search.algos.SearchDefault;
import search.algos.SearchContext;
import search.ui.UIManager;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcreteSearcher extends Searcher {
    private UIManager ui;
    private SearchContext context;

    public ConcreteSearcher(SearchContext context) {
        this.context = context;
        ui = UIManager.getUIManager();
    }

    @Override
    public Set<Integer> search(String strategy, List<String> rows, Map<String, Set<Integer>> invertedIndex, String query) {
        switch (strategy) {
            case "ALL":
                context.setStrategy(new SearchAll());
                break;

            case "ANY":
                context.setStrategy(new SearchAny());
                break;

            case "NONE":
                context.setStrategy(new SearchNone());
                break;

            default:
                ui.printOutput("\nInvalid option. Switching to the default \"exact match\" strategy.");
                context.setStrategy(new SearchDefault());
                break;
        }

        return context.getResult(rows, invertedIndex, query);
    }
}
