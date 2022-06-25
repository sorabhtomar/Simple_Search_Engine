package search.work;

import search.algos.DefaultSearch;
import search.algos.SearchContext;
import search.utils.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcreteSearcher extends Searcher {
    private SearchContext context;

    public ConcreteSearcher(SearchContext context) {
        this.context = context;
    }

    @Override
    public Set<Integer> search(String algorithm, Map<String, Set<Integer>> invertedIndex, String query) {
        switch (algorithm) {
            default:
                context.setStrategy(new DefaultSearch());
                break;
        }

        return context.getResult(invertedIndex, query);
    }
}
