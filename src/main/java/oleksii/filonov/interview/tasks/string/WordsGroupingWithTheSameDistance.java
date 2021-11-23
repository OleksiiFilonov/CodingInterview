package oleksii.filonov.interview.tasks.string;

/*
    https://leetcode.com/problems/group-shifted-strings/
    Input: ['abc', 'dog', 'grj', 'bcd', 'def', 'apple']
    Output: [['abc', 'bcd', 'def'], ['dog', 'grj'], ['apple']]
    "abc" -> "bcd" -> ... -> "def" -> ... -> "xyz"
    cnf - dog shifted -1
    dog
    eph - dog shifted +1
    fqi - dog shifted +2
    grj - dog shifted +3
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsGroupingWithTheSameDistance {

    public static Collection<List<String>> grouped(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            List<Integer> distance = new ArrayList<>();
            for (int i = 1; i < word.length(); i++) {
                distance.add(word.charAt(i) - word.charAt(i - 1));
            }
            String key = distance.stream().map(String::valueOf).collect(Collectors.joining(","));
            List<String> group = groups.getOrDefault(key, new ArrayList<>());
            group.add(word);
            groups.put(key, group);
        }
        return groups.values();
    }
}
