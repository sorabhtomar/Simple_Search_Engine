package search.algos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class SearchAny implements SearchStrategy {
    @Override
    public Set<Integer> getResult(List<String> rows, Map<String, Set<Integer>> invertedIndex, String complexQuery) {
        Set<Integer> result = new HashSet<>();

        // This is equivalent to "union" set operation.
        // If any of the word of a line is matched, that line is included in the result
        for (String query : complexQuery.split("\\s+")) {
            if (invertedIndex.containsKey(query)) {
                result.addAll(invertedIndex.get(query));
            }
        }

        return result;
    }
}
