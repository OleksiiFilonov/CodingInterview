package oleksii.filonov.interview.contests.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 */
public class SubsetOfAnotherSet {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> companiesSet = new ArrayList<>();
        for (List<String> companies : favoriteCompanies) {
            companiesSet.add(new HashSet<>(companies));
        }
        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < companiesSet.size(); i++) {
            if (!removed.contains(i)) {
                for (int j = 0; j < companiesSet.size(); j++) {
                    Set<String> iSet = companiesSet.get(i);
                    Set<String> jSet = companiesSet.get(j);
                    if (i != j && iSet.size() > jSet.size() && iSet.containsAll(jSet)) {
                        removed.add(j);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            if (!removed.contains(i))
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SubsetOfAnotherSet subsetOfAnotherSet = new SubsetOfAnotherSet();
        List<List<String>> input = List.of(
                List.of("leetcode", "google", "facebook"),
                List.of("google", "microsoft"),
                List.of("google", "facebook"),
                List.of("google"), List.of("amazon"));
        System.out.println(subsetOfAnotherSet.peopleIndexes(input));
    }
}
