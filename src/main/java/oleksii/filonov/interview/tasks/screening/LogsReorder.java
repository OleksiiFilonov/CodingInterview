package oleksii.filonov.interview.tasks.screening;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class LogsReorder {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, LogsComparator.INSTANCE);
        return logs;
    };

    private static final class LogsComparator implements Comparator<String> {

        private static LogsComparator INSTANCE = new LogsComparator();

        @Override
        public int compare(String first, String second) {
            String [] firstArray = split(first);
            String [] secondArray = split(second);
            boolean isFirstString = isAlphabetic(firstArray);
            boolean isSecondString = isAlphabetic(secondArray);
            if (isFirstString && isSecondString) {
                //both string keep comparing
                int comparison = firstArray[1].compareTo(secondArray[1]);
                if (comparison == 0) {
                    return firstArray[0].compareTo(secondArray[0]);
                } else {
                    return comparison;
                }
            } else if (isFirstString) {
                //first - string, second - digit
                return -1;
            } else if (isSecondString) {
                //second - string, first - digit
                return 1;
            } else {
                return 0;
            }
        }

        private boolean isAlphabetic(String[] array) {
            return Character.isAlphabetic(array[1].charAt(0));
        }

        private String[] split(String first) {
            return first.split(" ", 2);
        }
    }
}
