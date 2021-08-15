package oleksii.filonov.interview.tasks.math;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.math.BigNumbersAddition.add;
import static org.junit.jupiter.api.Assertions.*;

class BigNumbersAdditionTest {

    @Test
    void testAdd() {
        assertEquals("3", add("1", "2"));
        assertEquals("10", add("5", "5"));
        assertEquals("11", add("5", "6"));
        assertEquals("10", add("9", "1"));
        assertEquals("1181", add("1115", "66"));
        assertEquals("1000", add("999", "1"));
    }
}