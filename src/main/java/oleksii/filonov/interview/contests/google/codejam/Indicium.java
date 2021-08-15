package oleksii.filonov.interview.contests.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209aa0
 */
public class Indicium {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int sum = N*(N+1)/2;
            if (K % N == 0 || (sum == K && N > 2)) {
                System.out.println(String.format("Case #%s: POSSIBLE", caseIndex));
                int center = (sum == K)? 1: K / N;
                int[] array = new int[N];
                for (int i = 0; i < N; i++) {
                    array[i] = i + 1;
                }
                array[center - 1] = array[0];
                array[0] = center;
                StringBuilder square = new StringBuilder();
                int counter = 0;
                for(int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        square.append(array[counter % N]).append(" ");
                        counter++;
                    }
                    square.deleteCharAt(square.length() -1).append("\n");
                    counter--;
                }
                square.deleteCharAt(square.length() -1);
                System.out.println(square);
            } else {
                System.out.println(String.format("Case #%s: IMPOSSIBLE", caseIndex));
            }
        }
    }
}
