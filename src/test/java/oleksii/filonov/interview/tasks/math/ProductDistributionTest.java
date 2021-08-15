package oleksii.filonov.interview.tasks.math;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static oleksii.filonov.interview.tasks.datastructures.arrays.ListScanner.read;
import static org.junit.jupiter.api.Assertions.*;

class ProductDistributionTest {

    @Test
    void testMaxScore() {
        ProductDistribution productDistribution = new ProductDistribution();
        assertEquals(27, productDistribution.maxScore(new ArrayList<>(List.of(1, 5, 4, 2, 3)), 2));
        assertEquals(21, productDistribution.maxScore(new ArrayList<>(List.of(4, 1, 9, 7)), 4));
        assertEquals(136368772, productDistribution.maxScore(read("ProductDistributionInput02.txt"), 36));
        assertEquals(439157018, productDistribution.maxScore(read("ProductDistributionInput06.txt"), 174203));
    }
}