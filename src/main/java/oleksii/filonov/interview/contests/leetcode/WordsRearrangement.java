package oleksii.filonov.interview.contests.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 */
public class WordsRearrangement {

    public String arrangeWords(String text) {
        if (text == null || text.isEmpty()) return "";
        String [] words = text.split(" ");
        words[0] = words[0].toLowerCase();
        Arrays.sort(words, Comparator.comparing(String::length));
        words[0] = words[0].substring(0,1).toUpperCase() + words[0].substring(1);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        WordsRearrangement wordsRearrangement = new WordsRearrangement();
        System.out.println(wordsRearrangement.arrangeWords("Leetcode is cool"));
        System.out.println(wordsRearrangement.arrangeWords("Keep calm and code on"));
        System.out.println(wordsRearrangement.arrangeWords("To be or not to be"));
    }
}
