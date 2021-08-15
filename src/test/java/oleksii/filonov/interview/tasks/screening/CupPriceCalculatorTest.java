package oleksii.filonov.interview.tasks.screening;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.screening.CupPriceCalculator.Size.*;
import static org.junit.jupiter.api.Assertions.*;

class CupPriceCalculatorTest {

    public static final double[] PRICE_SCHEMA = {0.1, 0.15, 0.2};

    @Test
    void testSmallCup() {
        CupPriceCalculator smallCup = new CupPriceCalculator(SMALL, 5, PRICE_SCHEMA);
        smallCup.addCondiment("Milk").addCondiment("Caramel");
        assertEquals(5.20, smallCup.getTotal());
    }

    @Test
    void testMediumCup() {
        CupPriceCalculator mediumCup = new CupPriceCalculator(MEDIUM, 10, PRICE_SCHEMA);
        mediumCup.addCondiment("Milk").addCondiment("Caramel").addCondiment("Something");
        assertEquals(10.45, mediumCup.getTotal());
    }

    @Test
    void testLargeCup() {
        CupPriceCalculator largeCup = new CupPriceCalculator(LARGE, 100, PRICE_SCHEMA);
        assertEquals(100, largeCup.getTotal());
    }
}