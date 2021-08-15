package oleksii.filonov.interview.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    public void shouldReturnMinCoinsCycleRecursion() {
        assertEquals(2, CoinChange.coinChangeCycleRecursion(new int[]{10, 6, 1}, 12));
        assertEquals(1, CoinChange.coinChangeCycleRecursion(new int[]{10, 6, 1}, 6));
    }

    @Test
    public void shouldReturnMinCoinsTake1Recursion() {
        assertEquals(2, CoinChange.coinChangeRecursion1(new int[]{10, 6, 1}, 12));
        assertEquals(1, CoinChange.coinChangeRecursion1(new int[]{10, 6, 1}, 6));
    }

    @Test
    public void shouldReturnNotPossibleCycleRecursion() {
        assertEquals(-1, CoinChange.coinChangeCycleRecursion(new int[]{5, 2}, 3));
    }

    @Test
    public void shouldReturnNotPossibleTake1Recursion() {
        assertEquals(-1, CoinChange.coinChangeRecursion1(new int[]{5, 2}, 3));
    }
}