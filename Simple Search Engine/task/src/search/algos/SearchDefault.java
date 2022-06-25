package search.algos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class SearchDefault implements SearchStrategy {
    @Override
    public Set<Integer> getResult(List<String> rows, Map<String, Set<Integer>> invertedIndex, String query) {
        // This is the default strategy, which gives the "exact match" (i.e. the lines in which that "query" is present exactly).
        return invertedIndex.getOrDefault(query, new HashSet<>());
    }
}
