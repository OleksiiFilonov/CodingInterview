package oleksii.filonov.interview.tasks.graph;

import java.util.*;

/**
 * Similar to https://leetcode.com/problems/shortest-path-to-get-all-keys/
 * but requires as output the minimum path from
 *
 * @ - start
 * + - end
 * # - water
 * . - land
 * small letter - key
 * capital letter - door
 * Constraints:
 * 1 <= width of the maze <= 100
 * 1 <= height of the maze <= 100
 * 'a' <= key <= 'j'
 * 'A' <= door <= 'J
 * Multiple keys and doors of one type are possible.
 */
public class ShortestPathWithKeysAndDoors {
    private static final int MAX_KEYS = 10;
    private static int MAX_KEY_COMBINATIONS = 1 << MAX_KEYS;
    private static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[][] findShortestPath(String[] grid) {
        int[][][][] parent = new int[grid.length][grid[0].length()][MAX_KEY_COMBINATIONS][3];
        int[] start = findStart(grid);
        int[] goal = bfs(start, parent, grid);
        List<int[]> result = buildPath(start, goal, parent);
        return result.toArray(new int[0][0]);
    }

    private List<int[]> buildPath(int[] start, int[] last, int[][][][] parent) {
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{last[0], last[1]});
        while (last != start) {
            last = parent[last[0]][last[1]][last[2]];
            result.add(new int[]{last[0], last[1]});
        }
        Collections.reverse(result);
        return result;
    }

    private int[] bfs(int[] start, int[][][][] parent, String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        boolean[][][] visited = new boolean[rows][cols][MAX_KEY_COMBINATIONS];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]][start[2]] = true;
        while (!q.isEmpty()) {
            int[] prev = q.poll();
            for (int[] direction : directions) {
                int newRow = prev[0] + direction[0];
                int newCol = prev[1] + direction[1];
                int prevKeyring = prev[2];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    char symbol = grid[newRow].charAt(newCol);
                    if (isLand(symbol) || isStart(symbol)) {
                        addNeigborsToQueue(parent, visited, q, prev, newRow, newCol, prevKeyring);
                    } else if (isKey(symbol)) {
                        int key = symbol - 'a';
                        int newKeyring = prevKeyring | 1 << key;
                        if (!visited[newRow][newCol][newKeyring]) {
                            visited[newRow][newCol][newKeyring] = true;
                            parent[newRow][newCol][newKeyring] = prev;
                            q.add(new int[]{newRow, newCol, newKeyring});
                        }
                    } else if (isDoor(symbol) && canOpen(symbol, prevKeyring)) {
                        addNeigborsToQueue(parent, visited, q, prev, newRow, newCol, prevKeyring);
                    } else if (isGoal(symbol)) {
                        if (!visited[newRow][newCol][prevKeyring]) {
                            visited[newRow][newCol][prevKeyring] = true;
                            parent[newRow][newCol][prevKeyring] = prev;
                            return new int[]{newRow, newCol, prevKeyring};
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("The goal hasn't been reached");
    }

    private boolean isStart(char symbol) {
        return symbol == '@';
    }

    private void addNeigborsToQueue(int[][][][] parent, boolean[][][] visited, Queue<int[]> q, int[] prev, int newRow, int newCol, int prevKeyring) {
        if (!visited[newRow][newCol][prevKeyring]) {
            visited[newRow][newCol][prevKeyring] = true;
            parent[newRow][newCol][prevKeyring] = prev;
            q.add(new int[]{newRow, newCol, prevKeyring});
        }
    }

    private boolean isGoal(char symbol) {
        return symbol == '+';
    }

    private boolean canOpen(char symbol, int keyring) {
        return (1 << (symbol - 'A') & keyring) > 0;
    }

    private boolean isDoor(char symbol) {
        return symbol >= 'A' && symbol < 'A' + MAX_KEYS;
    }

    private boolean isKey(char symbol) {
        return symbol >= 'a' && symbol < 'a' + MAX_KEYS;
    }

    private boolean isLand(char symbol) {
        return symbol == '.';
    }

    private int[] findStart(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == '@')
                    return new int[]{i, j, 0};
            }
        }
        throw new IllegalArgumentException("Start symbol hasn't been found");
    }
}
