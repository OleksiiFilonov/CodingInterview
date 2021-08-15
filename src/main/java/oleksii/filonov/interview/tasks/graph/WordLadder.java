package oleksii.filonov.interview.tasks.graph;

import java.util.*;

import static java.util.Collections.emptyList;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    private static class Pair {
        private final int level;
        private final String word;

        private Pair(int level, String word) {
            this.level = level;
            this.word = word;
        }

        private static Pair create(int level, String word) {
            return new Pair(level, word);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return ladders(beginWord, endWord, wordList);
    }

    private int ladders(String beginWord, String endWord, List<String> wordList) {
        Set<String> used = new HashSet<>();
        Map<String, List<String>> starCombinations = new HashMap<>();
        Map<String, List<String>> toStarCombinations = new HashMap<>();
        for (String word : wordList) {
            addWordToCombinations(starCombinations, toStarCombinations, word);
        }
        addWordToCombinations(starCombinations, toStarCombinations, beginWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(Pair.create(1, beginWord));
        used.add(beginWord);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (endWord.equals(pair.word))
                return pair.level;
            List<String> starList = toStarCombinations.getOrDefault(pair.word, emptyList());
            for (String star : starList) {
                List<String> words = starCombinations.getOrDefault(star, emptyList());
                for (String word : words) {
                    if (!used.contains(word)) {
                        queue.add(Pair.create(pair.level + 1, word));
                        used.add(word);
                    }
                }
            }
        }
        return 0;
    }

    private void addWordToCombinations(Map<String, List<String>> starCombinations, Map<String, List<String>> toStarCombinations, String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            String starKey = word.substring(0, i) + "*" + word.substring(i + 1, length);
            addToMap(starCombinations, starKey, word);
            addToMap(toStarCombinations, word, starKey);
        }
    }

    private void addToMap(Map<String, List<String>> map, String key, String value) {
        List<String> words = map.getOrDefault(key, new ArrayList<>());
        words.add(value);
        map.put(key, words);
    }

}
