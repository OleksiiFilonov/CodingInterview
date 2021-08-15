package oleksii.filonov.interview.algorithms;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciNumberCalculatorTest {

    private FibonacciNumberCalculator testInstance = new FibonacciNumberCalculator();

    @Test
    public void shouldThrowExceptionOnNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> assertEquals(Integer.MIN_VALUE, testInstance.calculateFibonacciDP(-1)));
    }

    @Test
    public void calculateFibonacciDP() {
        assertEquals(0, testInstance.calculateFibonacciDP(0));
        assertEquals(1, testInstance.calculateFibonacciDP(1));
        assertEquals(1, testInstance.calculateFibonacciDP(2));
        assertEquals(2, testInstance.calculateFibonacciDP(3));
        assertEquals(3, testInstance.calculateFibonacciDP(4));
        assertEquals(5, testInstance.calculateFibonacciDP(5));
        assertEquals(8, testInstance.calculateFibonacciDP(6));
        assertEquals(55, testInstance.calculateFibonacciDP(10));
        assertEquals(317811, testInstance.calculateFibonacciDP(28));
        assertEquals(267914296, testInstance.calculateFibonacciDP(42));
    }

    @Test
    public void calculateFibonacciRecursiveExp() {
        assertEquals(0, testInstance.calculateFibonacciNumberRecursiveExp(0));
        assertEquals(1, testInstance.calculateFibonacciNumberRecursiveExp(1));
        assertEquals(1, testInstance.calculateFibonacciNumberRecursiveExp(2));
        assertEquals(2, testInstance.calculateFibonacciNumberRecursiveExp(3));
        assertEquals(3, testInstance.calculateFibonacciNumberRecursiveExp(4));
        assertEquals(5, testInstance.calculateFibonacciNumberRecursiveExp(5));
        assertEquals(8, testInstance.calculateFibonacciNumberRecursiveExp(6));
        assertEquals(55, testInstance.calculateFibonacciNumberRecursiveExp(10));
        assertEquals(317811, testInstance.calculateFibonacciNumberRecursiveExp(28));
        assertEquals(267914296, testInstance.calculateFibonacciNumberRecursiveExp(42));
    }

    @Test
    public void calculateFibonacciRecursiveLinear() {
        assertEquals(0, testInstance.calculateFibonacciNumberRecursiveLinear(0));
        assertEquals(1, testInstance.calculateFibonacciNumberRecursiveLinear(1));
        assertEquals(1, testInstance.calculateFibonacciNumberRecursiveLinear(2));
        assertEquals(2, testInstance.calculateFibonacciNumberRecursiveLinear(3));
        assertEquals(3, testInstance.calculateFibonacciNumberRecursiveLinear(4));
        assertEquals(5, testInstance.calculateFibonacciNumberRecursiveLinear(5));
        assertEquals(8, testInstance.calculateFibonacciNumberRecursiveLinear(6));
        assertEquals(55, testInstance.calculateFibonacciNumberRecursiveLinear(10));
        assertEquals(317811, testInstance.calculateFibonacciNumberRecursiveLinear(28));
        assertEquals(267914296, testInstance.calculateFibonacciNumberRecursiveLinear(42));
    }

}
