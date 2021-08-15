package oleksii.filonov.interview.contests.google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.out;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000019fef2/00000000002d5b62
 */
public class Expogo {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int distance = Math.abs(X) + Math.abs(Y);
            if (distance % 2 == 0) {
                out.println(String.format("Case #%s: IMPOSSIBLE", caseIndex));
                continue;
            }
            bfs(new int[]{X, Y}, caseIndex);
        }
    }

    private static class Pair {
        private final int[] coordinates;
        private final String steps;

        private Pair(int[] coordinates, String steps) {
            this.coordinates = coordinates;
            this.steps = steps;
        }

        private static Pair newPair(int[] coordinates, String steps) {
            return new Pair(coordinates, steps);
        }
    }

    private static void bfs(int[] destination, int caseIndex) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(Pair.newPair(new int[]{0, 0}, ""));
        for (int i = 0; i < 32; i++) {
            int quantityToPull = (int) Math.pow(4, i);
            for (int j = 0; j < quantityToPull; j++) {
                Pair point = queue.poll();
                if (point.coordinates[0] == destination[0] && point.coordinates[1] == destination[1]) {
                    out.println(String.format("Case #%s: %s", caseIndex, point.steps));
                    return;
                }
                int shift = (int) Math.pow(2, i);
                queue.add(Pair.newPair(new int[]{point.coordinates[0] + shift, point.coordinates[1]}, point.steps + 'E'));
                queue.add(Pair.newPair(new int[]{point.coordinates[0] - shift, point.coordinates[1]}, point.steps + 'W'));
                queue.add(Pair.newPair(new int[]{point.coordinates[0], point.coordinates[1] + shift}, point.steps + 'N'));
                queue.add(Pair.newPair(new int[]{point.coordinates[0], point.coordinates[1] - shift}, point.steps + 'S'));
            }
        }
        out.println(String.format("Case #%s: IMPOSSIBLE", caseIndex));
    }
}
