package oleksii.filonov.interview.tasks.math;

/**
 * Given two non-negative integers, num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string
 * You must solve the problem without using any build-in library for handling
 * large integers (such as BigInteger). You must also not convert the inputs
 * to integers directly.
 *
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * output: "134"
 *
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * Constraints:
 * 1 <= num1.length, num2.length <= 1000
 * num1 and num2 consist of only digits
 * num1 and num2 don't have any leading zeros except for the number zero
 *
 *
 * test = "123"
 * int(test)  # not okay
 */
public class Add2StringNumbersWithoutCasting {

    public String add(String num1, String num2) {
        int [] arr1 = toIntArray(num1);
        int [] arr2 = toIntArray(num2);
        int last1 = arr1.length - 1;
        int last2 = arr2.length - 1;
        int lastRes = Math.max(last1, last2);
        int [] res = new int[Math.max(last1, last2) + 1];
        int caryOver = 0;
        while(last1 >= 0 && last2 >= 0) {
            int sum = arr1[last1] + arr2[last2] + caryOver;
            res[lastRes] = sum % 10;
            caryOver = sum / 10;
            last1--;last2--;lastRes--;
        }
        while(last1 >= 0) {
            int sum = arr1[last1] + caryOver;
            res[lastRes] = sum % 10;
            caryOver = sum / 10;
            last1--;lastRes--;
        }
        while(last2 >= 0) {
            int sum = arr2[last2] + caryOver;
            res[lastRes] = sum % 10;
            caryOver = sum / 10;
            last2--;lastRes--;
        }

        StringBuilder sb = new StringBuilder();
        if(caryOver > 0)
            sb.append('1');
        for(int num: res) {
            sb.append(num);
        }
        return sb.toString();
    }

    private int [] toIntArray(String num) {
        int [] res = new int[num.length()];
        for(int i = 0; i < res.length; i++) {
            res[i] = num.charAt(i) - '0';
        }
        return res;
    }
}
