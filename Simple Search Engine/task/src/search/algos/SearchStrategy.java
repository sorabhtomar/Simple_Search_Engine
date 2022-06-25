package search.algos;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SearchStrategy {
    Set<Integer> getResult(List<String> rows, Map<String, Set<Integer>> invertedIndex, String query);
}
