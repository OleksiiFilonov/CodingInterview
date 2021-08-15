package oleksii.filonov.interview.tasks.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 */
public class PathWithMinEffort {

    public int minimumEffortPath(int[][] heights) {
        return search(heights, 0, 0, 0);
    }

    private static int [][] adjustments = new int [][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private int search(int[][] heights, int i, int j, int effort) {
        //System.out.println(String.format("current position [%s][%s] with array: %s", i, j, printArray(heights)));
        if(i == heights.length -1 && j == heights[0].length - 1)
            return effort;
        int curHeights = heights[i][j];
        heights[i][j] = -1;
        int bestEffort = Integer.MAX_VALUE;
        for(int [] adjust: adjustments) {
            int newRow = i + adjust[0];
            int newCol = j + adjust[1];
            if(newRow >=0 && newRow < heights.length
                    && newCol >= 0 && newCol < heights[0].length
                    && heights[newRow][newCol] > 0) {
                int diff = Math.abs(heights[newRow][newCol] - curHeights);
                int newEffort = search(heights, newRow, newCol, Math.max(diff, effort));
                bestEffort = Math.min(newEffort, bestEffort);
                //System.out.println(String.format("current[%s, %s] : new [%s, %s], effort: %s, diff: %s, maxEffort: %s, newEffort: %s", i, j, newRow, newCol, effort, diff, Math.max(diff, effort), newEffort));
                //System.out.println(Arrays.deepToString(heights));
            }
        }
        heights[i][j] = curHeights;
        return bestEffort;
    }

    private int[][] copy(int[][] heights) {
        int [][] copy = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                copy[i][j] = heights[i][j];
            }
        }
        return copy;
    }

    private String printArray(int[][] heights) {
        StringBuilder sb = new StringBuilder("\n");
        for (int [] row: heights) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }
}
