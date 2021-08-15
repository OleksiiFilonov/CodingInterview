package oleksii.filonov.interview.tasks.math;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.math.Combinations.calculate;
import static org.junit.jupiter.api.Assertions.*;

public class CombinationsTest {

    @Test
    public void calculationtest() {
        assertEquals(1, calculate(99, 0));
        assertEquals(1, calculate(100500, 100500));
        assertEquals(17, calculate(17, 1));
        assertEquals(10, calculate(5, 2));
        assertEquals(101, calculate(101, 100));
        assertEquals(120, calculate(10, 3));
    }
}