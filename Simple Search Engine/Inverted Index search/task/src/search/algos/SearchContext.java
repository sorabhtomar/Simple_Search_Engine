package search.algos;

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

    public Set<Integer> getResult(Map<String, Set<Integer>> invertedIndex, String query) {
        return strategy.getResult(invertedIndex, query);
    }
}
