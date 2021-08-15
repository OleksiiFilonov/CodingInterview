package oleksii.filonov.interview.tasks.string;

/**
 * Print all combinations of a given String
 */
public class StringCombinationGenerator {

    public static void printCombinations(String initial) {
        generateCombinations(new StringBuilder(), new StringBuilder(initial));
    }

    private static void generateCombinations(StringBuilder slate, StringBuilder subproblem) {
        if(subproblem.length() == 0) {
            System.out.println("\"" + slate + "\"");
        } else {
            int lastIndex = subproblem.length() - 1;
            char included = subproblem.charAt(lastIndex);
            subproblem.deleteCharAt(lastIndex);
            //excluded case
            generateCombinations(slate, subproblem);
            //included case
            generateCombinations(slate.append(included), subproblem);
            subproblem.append(included);
            slate.deleteCharAt(slate.length()-1);
        }
    }

    public static void main(String[] args) {
        printCombinations("abc");
    }
}
