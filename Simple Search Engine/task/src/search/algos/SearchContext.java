package search.algos;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchContext {
    private SearchStrategy strategy;

    // public SearchContext(SearchStrategy strategy) {
    //     this.strategy = strategy;
    // }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public Set<Integer> getResult(List<String> rows, Map<String, Set<Integer>> invertedIndex, String query) {
        return strategy.getResult(rows, invertedIndex, query);
    }
}
