package oleksii.filonov.interview.tasks.screening;

import java.util.LinkedList;

/**
 * Split set in two non-empty subsets so the difference between their average is minimum
 * Combinatorial enumeration task (enumerate all the possible combinations) should be solved with recursion
 * Time complexity 2^n something.
 * Return 2 of those subsets in any order
 * sorted, unique, positive
 * 1,2,3,4,5,6 -> (1,3,5)[3], (2,4,6)[4] -> 1
 * -> (1,6,3)[3.3], (2,5,4)[3.4] -> .1
 */
public class MinimumAverageValueSplitter {

    private int[] left;
    private int[] right;
    private double bestAvg = Double.MAX_VALUE;
    private int[] source;

    public int[][] split(int[] source) {
        this.source = source;
        split(0, new LinkedList<>(), 0, 0, new LinkedList<>(), 0, 0);
        return new int[][]{left, right};
    }

    private void split(int start, LinkedList<Integer> slate, int slateCount, int slateSum, LinkedList<Integer> remainder, int remainderCount, int remainderSum) {
        if (start == source.length) {
            if (!slate.isEmpty() && !remainder.isEmpty()) {
                double d1 = avg(slateSum, slateCount);
                double d2 = avg(remainderSum, remainderCount);
                double diff = Math.abs(d1 - d2);
                if (diff < bestAvg) {
                    bestAvg = diff;
                    left = convertToArray(slate);
                    right = convertToArray(remainder);
                }
            }
        }
        for (int curIndex = start; curIndex < source.length; curIndex++) {
            slate.add(source[curIndex]);
            split(curIndex + 1, slate, slateCount + 1, slateSum + source[curIndex], remainder, remainderCount, remainderSum);
            slate.removeLast();
            remainder.add(source[curIndex]);
            split(curIndex + 1, slate, slateCount, slateSum, remainder, remainderCount + 1, remainderSum + source[curIndex]);
            remainder.removeLast();
        }
    }

    private double avg(double slateSum, int slateCount) {
        return slateSum / slateCount;
    }

    private int[] convertToArray(LinkedList<Integer> slate) {
        return slate.stream().mapToInt(i -> i).toArray();
    }
}
