package oleksii.filonov.interview.tasks.string;

import java.util.Arrays;

public class NextSmallestPalindrome {

    public static long findNextPalindrome(long initial) {
        char[] digits = String.valueOf(initial).toCharArray();
        if (allNines(digits))
            return initial + 2;
        int median = digits.length / 2;
        int shift = (digits.length % 2 == 0) ? 0 : 1;
        copyLeftToRight(digits);
        long mirrorLeft = Long.parseLong(String.valueOf(digits));
        if (mirrorLeft > initial) {
            return mirrorLeft;
        } else {
            int leftValue = Integer.parseUnsignedInt(
                    String.valueOf(Arrays.copyOfRange(digits, 0, median + shift))) + 1;
            char[] leftValueDigits = String.valueOf(leftValue).toCharArray();
            System.arraycopy(leftValueDigits, 0, digits, 0, leftValueDigits.length);
            copyLeftToRight(digits);
            return Long.parseLong(String.valueOf(digits));
        }

    }

    private static void copyLeftToRight(char[] digits) {
        int length = digits.length;
        int median = length / 2;
        int shift = (length % 2 == 0) ? 0 : 1;
        for (int i = 0; i < median + shift; i++) {
            digits[length - 1 - i] = digits[i];
        }
    }

    private static boolean allNines(char[] digits) {
        for (char digit : digits)
            if (digit != '9') return false;
        return true;
    }
}
