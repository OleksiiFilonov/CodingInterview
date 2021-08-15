package oleksii.filonov.interview.tasks.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PathWithMinEffortTest {

    @Test
    public void shouldFindMinPath() {
        PathWithMinEffort testInstance = new PathWithMinEffort();
        Assertions.assertEquals(1, testInstance.minimumEffortPath(
                new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
    }
}