package oleksii.filonov.interview.tasks.math;

/**
 * https://leetcode.com/problems/sqrtx
 */
public class SquareRoot {

    public static int squareBruteForce(int x) {
        long index = 0;
        while (index * index <= x)
            //index < x/index
            index++;
        return (int) index - 1;
    }

    public static int squareBinarySearch(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int left = 1;
        int right = x;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (middle <= x / middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left - 1;
    }

}
