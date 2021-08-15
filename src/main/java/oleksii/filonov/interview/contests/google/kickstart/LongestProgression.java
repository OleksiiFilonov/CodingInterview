package oleksii.filonov.interview.contests.google.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a882
 */
public class LongestProgression {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
            int length = in.nextInt();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = in.nextInt();
            }
            long longest = 0;
            Map<Integer, List<int[]>> difference = new HashMap<>();
            for (int i = 1; i < length; i++) {
                int diff = array[i] - array[i - 1];
                if (difference.containsKey(diff)) {
                    List<int[]> list = difference.get(diff);
                    int[] latest = list.get(list.size() - 1);
                    if (latest[1] + 1 == i) {
                        latest[1]++;
                    } else {
                        list.add(new int[]{i - 1, i});
                    }
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i - 1, i});
                    difference.put(diff, list);
                }
            }

            for (Map.Entry<Integer, List<int[]>> entry : difference.entrySet()) {
                if (longest == length)
                    break;
                List<int[]> list = entry.getValue();
                for (int i = 0; i < list.size(); i++) {
                    int[] current = list.get(i);
                    if (current[0] > 0 || current[1] < length - 1) {
                        // extend_from_left or right
                        longest = Math.max(longest, len(current) + 1);
                    } else {
                        longest = length;
                        break;
                    }
                    if (i != list.size() - 1) {
                        // try merge right
                        int[] next = list.get(i + 1);
                        //1. difference between last current and first next should be 1
                        if (next[0] - current[1] == 2) {
                            //merge possible if the input element will be in decreasing or increasing order
                            int imaginaryNumber = array[current[1]] + entry.getKey();
                            if (array[next[0]] - imaginaryNumber == entry.getKey()) {
                                longest = Math.max(longest, next[1] - current[0] + 1);
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + caseIndex + ": " + longest);
        }
    }

    private static int len(int[] current) {
        return current[1] - current[0] + 1;
    }
}
