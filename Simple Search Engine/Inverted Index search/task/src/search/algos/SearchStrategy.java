package search.algos;

import java.util.Map;
import java.util.Set;

public interface SearchStrategy {
    Set<Integer> getResult(Map<String, Set<Integer>> invertedIndex, String query);
}
