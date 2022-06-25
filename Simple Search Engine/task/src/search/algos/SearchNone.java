package search.algos;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchNone implements SearchStrategy {
    @Override
    public Set<Integer> getResult(List<String> rows, Map<String, Set<Integer>> invertedIndex, String complexQuery) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < rows.size(); i++) {
            result.add(i);
        }

        // This is equivalent to "difference" (or "minus") set operation
        // The lines in which the given words are NOT present are included in the result
        for (String query : complexQuery.split("\\s+")) {
            if (invertedIndex.containsKey(query)) {
                result.removeAll(invertedIndex.get(query));
            }
        }

        return result;
    }
}
