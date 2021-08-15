package oleksii.filonov.interview.tasks.screening;

/**
 * Given a set of integers and a target value k, find a non-empty subset that sums up to target.
 * Constraints:
 * 1 <= size of the input array <= 18
 * -10^12 <= elements of the array, k <= 10^12
 */
public class TargetSum {

    public boolean ifSumPossible(int[] arr, int target) {

        return check(0, 0, true, arr, target);
    }

    private boolean check(int sum, int index, boolean isEmpty, int[] arr, int target) {
        if (sum == target && !isEmpty)
            return true;
        if (index == arr.length)
            return false;
        if (check(sum + arr[index], index + 1, false, arr, target))
            return true;
        if (check(sum, index + 1, isEmpty, arr, target))
            return true;
        return false;
    }
}
