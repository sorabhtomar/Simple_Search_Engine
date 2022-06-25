package search.algos;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchAll implements SearchStrategy {
    @Override
    public Set<Integer> getResult(List<String> rows, Map<String, Set<Integer>> invertedIndex, String complexQuery) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < rows.size(); i++) {
            result.add(i);
        }

        // This is equivalent to "intersection" set operation
        // The line which is common for all the words (i.e. that line includes all the words) in included in the result
        for (String query : complexQuery.split("\\s+")) {
            // If we find any "query" which is not found in "invertedIndex", we simply return an empty set
            // because there will be no line which will contain all the words of the "complexQuery"
            if (!invertedIndex.containsKey(query)) {
                return Set.of();
            }

            // Only for those "query" which are found in "invertedIndex"
            result.retainAll(invertedIndex.get(query));
        }

        return result;
    }
}
