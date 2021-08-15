package oleksii.filonov.interview.tasks.screening;

import java.util.Arrays;

public class MinimumAverageValue {
    public static void main(String[] args) {
        // sorted, unique, positive
        // 1,2,3,4,5,6 -> (1,3,5)[3], (2,4,6)[4] -> 1
        //             -> (1,6,3)[3.3], (2,5,4)[3.4] -> .1
        int[] values = new int[]{1, 2, 3, 4, 5, 6};
        int[][] output = parse(values);

        for (int[] set : output) {
            System.out.println(Arrays.toString(set));
        }
    }

    private static int[][] parse(int[] array) {
        //1,2,4,5,6
        //validation
        var result = recursion(new int[]{array[0]}, Arrays.copyOfRange(array, 1, array.length));

        return new int[][]{result.left, result.right};
    }

    private static class Composite {

        private final double diff;
        private final int[] left;
        private final int[] right;

        private Composite(double diff, int[] left, int[] right) {
            this.diff = diff;
            this.left = left;
            this.right = right;
        }
    }

    private static Composite recursion(int[] left, int[] right) {
        if (left.length == 0 || right.length == 0)
            return new Composite(Double.MAX_VALUE, new int[]{}, new int[]{});

        double leftAvg = calculate(left);
        double rightAvg = calculate(right);
        double diff = Math.abs(leftAvg - rightAvg);
        var currentComposite = new Composite(diff, left, right);
        //left - 1, right - 2,3,4,5,6
        //left - 1, 2, right - 3,4,5,6;
        //left - 1, 6, right 2, 3, 4, 5
        for (int i = 0; i < right.length; i++) {
            var leftCopy = Arrays.copyOf(left, left.length + 1);
            leftCopy[left.length] = right[i];
            var rightCopy = new int[right.length - 1];
            System.arraycopy(right, 0, rightCopy, 0, i);
            System.arraycopy(right, i + 1, rightCopy, i, right.length - i - 1);
            var composite = recursion(leftCopy, rightCopy);
            if (diff > composite.diff)
                currentComposite = composite;

        }

        return currentComposite;
    }

    private static double calculate(int[] array) {
        return Arrays.stream(array).average().getAsDouble();
    }
}
