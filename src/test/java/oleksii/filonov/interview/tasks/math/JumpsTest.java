package oleksii.filonov.interview.tasks.math;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.math.Jumps.dynamicProgramming;
import static oleksii.filonov.interview.tasks.math.Jumps.recursion;
import static org.junit.jupiter.api.Assertions.*;

class JumpsTest {

    @Test
    void testRecursion() {
        assertEquals(4, recursion(3, new int[]{1, 2, 3}));
        assertEquals(7, recursion(4, new int[]{1, 2, 3}));
        assertEquals(1, recursion(1, new int[]{1, 2, 3}));
        assertEquals(2, recursion(2, new int[]{1, 2, 3}));
        assertEquals(2, recursion(110, new int[]{10, 11}));
        assertEquals(0, recursion(12, new int[]{10, 11}));
    }

    @Test
    void testDynamicProgramming() {
        assertEquals(4, dynamicProgramming(3, new int[]{1, 2, 3}));
        assertEquals(7, dynamicProgramming(4, new int[]{1, 2, 3}));
        assertEquals(1, dynamicProgramming(1, new int[]{1, 2, 3}));
        assertEquals(2, dynamicProgramming(2, new int[]{1, 2, 3}));
        assertEquals(2, dynamicProgramming(110, new int[]{10, 11}));
        assertEquals(0, dynamicProgramming(12, new int[]{10, 11}));
    }
}