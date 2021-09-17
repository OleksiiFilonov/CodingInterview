package oleksii.filonov.interview.algorithms.dynamicprogramming;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellBuyStocksMaxProfitTest {

    private SellBuyStocksMaxProfit profitFinder = new SellBuyStocksMaxProfit();

    @Test
    public void maxProfit() {
        int[] prices = {4, 3, 1, 7, 5};
        assertEquals(6, profitFinder.maxProfitDP(prices));
        assertEquals(6, profitFinder.maxProfitRecursive(prices));
    }
}