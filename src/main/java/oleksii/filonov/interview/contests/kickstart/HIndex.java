package oleksii.filonov.interview.contests.kickstart;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000008f4332/0000000000941e56
 */
public class HIndex {

    public static int[] getHIndexScore(int[] citationsPerPaper) {
        int papers = citationsPerPaper.length;
        if (papers == 0)
            return new int[0];
        int[] hIndex = new int[papers];

        Queue<Integer> heap = new PriorityQueue<>();
        heap.add(citationsPerPaper[0]);
        hIndex[0] = 1;
        for (int i = 1; i < papers; i++) {
            heap.add(citationsPerPaper[i]);
            if (heap.peek() >= heap.size()) {
                hIndex[i] = heap.size();
            } else {
              heap.poll();
              hIndex[i] = hIndex[i-1];
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get number of test cases in input
        int testCaseCount = scanner.nextInt();
        // Iterate through test cases
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            // Get number of papers for this test case
            int paperCount = scanner.nextInt();
            // Get number of citations for each paper
            int[] citations = new int[paperCount];
            for (int p = 0; p < paperCount; ++p) {
                citations[p] = scanner.nextInt();
            }
            // Print h-index score after each paper in this test case
            System.out.print("Case #" + tc + ":");
            for (int score : getHIndexScore(citations)) {
                System.out.append(" ").print(score);
            }
            System.out.println();
        }
    }
}
