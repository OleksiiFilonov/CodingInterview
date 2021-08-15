package oleksii.filonov.interview.contests.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://www.codechef.com/MAY20B/problems/COVID19
 */
public class CoronavirusSpread {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            int[] people = new int[N];
            for (int i = 0; i < N; i++) {
                people[i] = in.nextInt();
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int counter = 1;
            for (int i = 1; i < N; i++) {
                if(people[i] - people[i-1] > 2) {
                   min = Math.min(min, counter);
                   max = Math.max(max, counter);
                   counter = 1;
                } else {
                    counter++;
                }
            }
            min = Math.min(min, counter);
            max = Math.max(max, counter);
            System.out.println(min + " " + max);
        }
    }
}
