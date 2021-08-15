package oleksii.filonov.interview.tasks.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Return first anagrams in the array in sorter order,
 * e.g. [framer, frame, ecod, code] -> [framer, frame, ecod]
 */
public class FunWithAnagram {

    public static final String [] reduce(String [] input) {
        Map<String, String> unique = new HashMap<>();
        for (String candidate: input) {
            char [] chars = candidate.toCharArray();
            Arrays.sort(chars);
            String sortedCandidate = String.valueOf(chars);
            unique.putIfAbsent(sortedCandidate, candidate);
        }
        return unique.values().stream().sorted().toArray(String[]::new);
    }
}
