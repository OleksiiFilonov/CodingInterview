package oleksii.filonov.interview.contests.google.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class DrPatelPlates {

    public static void main(String[] args) {
        //solveToCheck();
        solve01Knapsack();
    }

    private static void solve01Knapsack() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
            int n = in.nextInt(); //number of stacks
            int k = in.nextInt(); //plates in a stack
            int p = in.nextInt(); //maximum number of plates to pick
            int[][] maximumSum = new int[n][p + 1];
            //first stack
            for (int i = 1; i <= p; i++) {
                if (i > k)
                    maximumSum[0][i] = maximumSum[0][k];
                else
                    maximumSum[0][i] = in.nextInt() + maximumSum[0][i - 1];
            }
            //read value of the next stack
            for (int stackIndex = 1; stackIndex < n; stackIndex++) {
                int[] currentStackSum = new int[k];
                currentStackSum[0] = in.nextInt();
                for (int j = 1; j < k; j++)
                    currentStackSum[j] = currentStackSum[j - 1] + in.nextInt();
                for (int j = 1; j <= p; j++) {
                    for (int l = 0; l <= j; l++)
                        maximumSum[stackIndex][j] = Math.max(maximumSum[stackIndex][j], currentSumValue(currentStackSum, l) + maximumSum[stackIndex - 1][j - l]);
                }

            }
            System.out.println(Arrays.deepToString(maximumSum));
            System.out.println("Case #" + caseIndex + ": " + maximumSum[n - 1][p]);
        }
    }

    private static int currentSumValue(int[] currentStackSum, int l) {
        if (l == 0)
            return 0;
        else if (l >= currentStackSum.length)
            return currentStackSum[currentStackSum.length - 1];
        else
            return currentStackSum[l - 1];
    }


    private static void solveToCheck() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int caseIndex = 1; caseIndex <= t; ++caseIndex) {
            int N = in.nextInt(); //N
            int K = in.nextInt();  //K
            int P = in.nextInt(); //P
            int[][] dp = new int[N + 1][P + 1];
            for (int stackIndex = 0; stackIndex < N; stackIndex++) {
                int[] a = new int[K];
                a[0] = in.nextInt();
                for (int j = 1; j < K; j++) {
                    a[j] += in.nextInt() + a[j - 1];
                }
                for (int j = 0; j <= K; j++) {
                    for (int k = 0; k + j <= P; k++) {
                        dp[stackIndex + 1][k + j] = Math.max(dp[stackIndex + 1][k + j], dp[stackIndex][k] + (j == 0 ? 0 : a[j - 1]));
                    }
                }
            }
            System.out.println("Case #" + caseIndex + ": " + dp[N][P]);
        }
    }
}
