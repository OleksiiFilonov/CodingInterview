package oleksii.filonov.interview.tasks.datastructures.hashtables;

import java.util.*;

/**
 * product A has recommendations A -> B, C
 * B -> A, D
 * fetch all the transitive recommendations for A up to certain max, so the result would be [B, C, D]
 */
public class FetchAll {

    public Set<String> fetch(Map<String, Set<String>> recommendations, String id, int cap) {
        Set<String> result = new HashSet<>();
        find(recommendations, result, id, cap + 1);
        result.remove(id);
        return result;
    }

    private void find(Map<String, Set<String>> recommendations, Set<String> result, String id, int cap) {
        if (result.add(id) && result.size() == cap) return;
        Iterator<String> related = recommendations.get(id).iterator();
        while (result.size() < cap && related.hasNext()) {
            String nextId = related.next();
            if (!result.contains(nextId))
                find(recommendations, result, nextId, cap);
        }
    }

    public Set<String> fetchWithPriority(final Map<String, Set<String>> recommendations, final String id, final int cap) {
        Set<String> result = new HashSet<>();
        findWithPriority(recommendations, result, Set.of(id), cap + 1);
        result.remove(id);
        return result;
    }

    private void findWithPriority(final Map<String, Set<String>> recommendations, final Set<String> result, final Set<String> keys, final int cap) {
        Iterator<String> keyIterator = keys.iterator();
        boolean isAdded = false;
        while (keyIterator.hasNext() && result.size() < cap) {
            String next = keyIterator.next();
            System.out.println("Should add :" + next);
            isAdded = isAdded || result.add(next);
            System.out.println(String.format("After adding \"%s\" result look like: %s",
                    next, Arrays.toString(result.toArray())));
        }
        keyIterator = keys.iterator();
        while (isAdded && keyIterator.hasNext() && result.size() < cap) {
            findWithPriority(recommendations, result, recommendations.get(keyIterator.next()), cap);
        }
    }

}
