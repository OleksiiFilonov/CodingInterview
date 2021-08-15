package oleksii.filonov.interview.tasks.datastructures.arrays;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinValueInRotatedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        return findNewMin(nums);
    }

    private static int findNewMin(int [] nums) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            mid = left + (right - left)/2;
            if(mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if(nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return nums[left];
    }
}
