package oleksii.filonov.interview.tasks.datastructures.arrays;


import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.arrays.EfficientHarvest.maxProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EfficientHarvestTest {

    @Test
    public void checkMaxProfit() {
        assertEquals(0, maxProfit(1, new int [] {-3, 6, 3, -6}));
        assertEquals(-2, maxProfit(1, new int [] {3, -5}));
        assertEquals(16, maxProfit(2, new int [] {1, -3, 7, 3, 1, 5}));
    }

}