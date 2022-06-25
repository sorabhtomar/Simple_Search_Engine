package search.algos;

import java.util.Map;
import java.util.Set;

public class DefaultSearch implements SearchStrategy {
    @Override
    public Set<Integer> getResult(Map<String, Set<Integer>> invertedIndex, String query) {
        return invertedIndex.get(query);
    }
}
