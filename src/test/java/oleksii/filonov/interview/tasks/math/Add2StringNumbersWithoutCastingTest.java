package oleksii.filonov.interview.tasks.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Add2StringNumbersWithoutCastingTest {

    private Add2StringNumbersWithoutCasting underTest = new Add2StringNumbersWithoutCasting();

    @Test
    public void addFirstBigger() {
        assertEquals("134", underTest.add("11", "123"));
    }

    @Test
    public void addSecondBiggerWithCaryOver() {
        assertEquals("533", underTest.add("456", "77"));
    }

    @Test
    public void sumUpZeros() {
        assertEquals("0", underTest.add("0", "0"));
    }

    @Test
    public void sumUpZeroAndSomething() {
        assertEquals("12", underTest.add("12", "0"));
    }
}