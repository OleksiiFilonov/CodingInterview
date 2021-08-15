package oleksii.filonov.interview.tasks.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShortestPathWithKeysAndDoorsTest {

    private ShortestPathWithKeysAndDoors shortestPathWithKeysAndDoors = new ShortestPathWithKeysAndDoors();

    @Test
    public void findShortestPath() {
        assertArrayEquals(new int[][]{{0, 1}, {0, 0}, {0, 1}, {0, 2}, {0, 3}},
                shortestPathWithKeysAndDoors.findShortestPath(new String[]{"a@A+"}));
    }
}