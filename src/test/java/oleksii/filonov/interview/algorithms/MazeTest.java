package oleksii.filonov.interview.algorithms;

import static oleksii.filonov.interview.algorithms.Maze.hasPathBFS;
import static oleksii.filonov.interview.algorithms.Maze.hasPathDFS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MazeTest {

    @Test
    public void testBFS() {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        assertTrue(hasPathBFS(maze, new int[]{4, 4}, new int[]{4, 4}));
        assertTrue(hasPathBFS(maze, new int[]{0, 4}, new int[]{4, 4}));
        assertTrue(hasPathBFS(maze, new int[]{0, 4}, new int[]{4, 0}));
        assertTrue(hasPathBFS(maze, new int[]{0, 4}, new int[]{4, 0}));
        assertTrue(hasPathBFS(maze, new int[]{0, 4}, new int[]{2, 1}));
        assertFalse(hasPathBFS(maze, new int[]{0, 4}, new int[]{3, 2}));
        assertFalse(hasPathBFS(maze, new int[]{0, 4}, new int[]{4, 1}));
        maze = new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}, {1, 1, 0, 1},
                {0, 0, 0, 0}};
        assertTrue(hasPathBFS(maze, new int[]{0, 0}, new int[]{4, 3}));
        assertFalse(hasPathBFS(maze, new int[]{1, 1}, new int[]{4, 1}));
    }

    @Test
    public void testDFS() {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{0, 4}));
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{4, 4}));
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{4, 0}));
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{4, 0}));
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{2, 1}));
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{2, 2}));
        assertTrue(hasPathDFS(maze, new int[]{0, 4}, new int[]{2, 0}));
        assertFalse(hasPathDFS(maze, new int[]{0, 4}, new int[]{3, 2}));
        assertFalse(hasPathDFS(maze, new int[]{0, 4}, new int[]{4, 1}));
        maze = new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}, {1, 1, 0, 1},
                {0, 0, 0, 0}};
        assertTrue(hasPathDFS(maze, new int[]{0, 0}, new int[]{4, 3}));
        assertFalse(hasPathDFS(maze, new int[]{1, 1}, new int[]{4, 1}));
    }

}
