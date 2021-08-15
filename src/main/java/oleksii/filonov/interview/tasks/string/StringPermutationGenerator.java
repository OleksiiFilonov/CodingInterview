package oleksii.filonov.interview.tasks.string;

import java.io.IOException;

/**
 * Print all permutations
 */
public class StringPermutationGenerator {

    public static void printAllPermutationsWithoutRepetitions(String initial) {
        generatePermutationsWithoutRepetitions(new StringBuilder(), new StringBuilder(initial));
    }

    private static void generatePermutationsWithoutRepetitions(StringBuilder slate, StringBuilder remaining) {
        if (remaining.length() == 0) {
            System.out.println(slate);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                slate.append(remaining.charAt(i));
                remaining.deleteCharAt(i);
                generatePermutationsWithoutRepetitions(slate, remaining);
                int lastCharIndex = slate.length() - 1;
                remaining.insert(i, slate.charAt(lastCharIndex));
                slate.deleteCharAt(lastCharIndex);
            }
        }
    }

    public static void printAllPermutationsWithRepetitions(String source) {
        generatePermutationsWithRepetitions(new StringBuilder(), source);
    }

    private static void generatePermutationsWithRepetitions(StringBuilder slate, String selection) {
        if (slate.length() >= selection.length())
            System.out.println(slate);
        else
            for (char c : selection.toCharArray()) {
                slate.append(c);
                generatePermutationsWithRepetitions(slate, selection);
                slate.deleteCharAt(slate.length() - 1);
            }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Permutations without repetitions:");
        printAllPermutationsWithoutRepetitions("abc");
        System.out.println("Permutations with repetitions:");
        printAllPermutationsWithRepetitions("abc");
    }
}
