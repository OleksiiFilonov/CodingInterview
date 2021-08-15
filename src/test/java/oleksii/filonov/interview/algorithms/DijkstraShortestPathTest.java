package oleksii.filonov.interview.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DijkstraShortestPathTest {

    private DijkstraShortestPath testInstance = new DijkstraShortestPath();

    @Test
    public void shortestPath() {
        final int[][] source = {
                {0, 1, 1, -1},
                {1, 0, 2, 2},
                {1, 2, 0, 3},
                {-1, 2, 3, 0}
        };
        final int[][] expectedResult = {
                {0, 1, 1, 3},
                {0, 0, 0, 1}
        };
        assertArrayEquals(expectedResult, testInstance.findWithMinHeap(source, 0));
        assertArrayEquals(expectedResult, testInstance.findWithAdjacencyMatrix(source, 0));
    }
}