package oleksii.filonov.interview.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/articles/the-maze/
 */
public class Maze {


    /**
     * @param maze        - two dimension array of
     * @param start       - starting point one dimension array as coordinate [x, y]
     * @param destination - desired destination to reach one dimension array as coordinates
     * @return <code>true</code> is destination can be reached from the starting point, <code>false</code> otherwise
     */
    public static boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point[0] == destination[0] && point[1] == destination[1])
                return true;
            for (int[] direction : directions) {
                int x = point[0] + direction[0];
                int y = point[1] + direction[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += direction[0];
                    y += direction[1];
                }
                x -= direction[0];
                y -= direction[1];
                if (!visited[x][y]) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    /**
     * @param maze        - two dimension array of
     * @param start       - starting point one dimension array as coordinate [x, y]
     * @param destination - desired destination to reach one dimension array as coordinates
     * @return <code>true</code> is destination can be reached from the starting point, <code>false</code> otherwise
     */
    public static boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    private static boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (start[0] == destination[0] && start[1] == destination[1])
            //reached destination
            return true;
        if (visited[start[0]][start[1]])
            return false;
        visited[start[0]][start[1]] = true;

        int left = start[1];
        while (left != 0 && maze[start[0]][left - 1] != 1)
            left--;
        if (dfs(maze, new int[]{start[0], left}, destination, visited))
            return true;

        int down = start[0];
        while (down < maze.length - 1 && maze[down + 1][start[1]] != 1)
            down++;
        if (dfs(maze, new int[]{down, start[1]}, destination, visited))
            return true;

        int right = start[1];
        while (right < maze[0].length - 1 && maze[start[0]][right + 1] != 1)
            right++;
        if (dfs(maze, new int[]{start[0], right}, destination, visited))
            return true;

        int up = start[0];
        while (up != 0 && maze[up - 1][start[1]] != 1)
            up--;

        if (dfs(maze, new int[]{up, start[1]}, destination, visited))
            return true;

        return false;
    }

}
