package oleksii.filonov.interview.algorithms;

/**
 * Compute Fibonacci Numbers with and without memorization 0, 1=1, 2, 1+2= 3,
 * 3+2=5, 5+3=8, 8+5=13, 13+8=21, 21+13=34, 34+21=55
 * [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55], so for input 0 -> 0, 1 -> 1, 2 -> 2, 3 ->3, 4 -> 5 and so on
 * input corresponds to the index
 */
public class FibonacciNumberCalculator {

    /**
     * Calculates Fibonacci number using Dynamic Programming O(n)
     *
     * @param number - index to calculate number or
     * @return Fibonacci number for a given number.
     */
    public int calculateFibonacciDP(int number) {
        if (number == 0)
            return 0;
        validateFibonacciSize(number);
        int[] fibNumbers = new int[number + 1];
        fibNumbers[1] = 1;
        for (int i = 2; i < number + 1; i++) {
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        }
        return fibNumbers[number];
    }

    /**
     * Calculates Fibonacci number exponentially O(n^2)
     * Applies divide and conquer strategy
     *
     * @param number - index to calculate number or
     * @return Fibonacci number for a given number.
     */
    public int calculateFibonacciNumberRecursiveExp(int number) {
        validateFibonacciSize(number);
        return calculateFibRecursiveExp(number);
    }

    private int calculateFibRecursiveExp(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return calculateFibRecursiveExp(number - 1) + calculateFibRecursiveExp(number - 2);
        }
    }

    private void validateFibonacciSize(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Index of Fibonacci numbers should be greater than zero");
        }
    }

    /**
     * Calculates Fibonacci number using Linear Recursion O(n).
     * Applies decrease anc conquer strategy
     *
     * @param number - index to calculate number or
     * @return Fibonacci number for a given number.
     */
    public int calculateFibonacciNumberRecursiveLinear(int number) {
        //validateFibonacciSize();
        return calculateFibRecursiveLinear(number, 0, 1);
    }

    private int calculateFibRecursiveLinear(int number, int base1, int base2) {
        if (number == 0)
            return base1;
        return calculateFibRecursiveLinear(number - 1, base2, base1 + base2);
    }

}
