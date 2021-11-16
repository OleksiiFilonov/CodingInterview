package oleksii.filonov.interview.tasks.graph;


import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.graph.PermutationMinimizer.minimizeOperations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationMinimizerTest {

    @Test
    public void minimizePermutations() {
        assertEquals(2, minimizeOperations(new int[]{3, 1, 2}));
        assertEquals(3, minimizeOperations(new int[]{5, 4, 3, 6, 2, 1}));
    }
}