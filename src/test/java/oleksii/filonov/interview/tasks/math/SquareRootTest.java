package oleksii.filonov.interview.tasks.math;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.math.SquareRoot.squareBinarySearch;
import static oleksii.filonov.interview.tasks.math.SquareRoot.squareBruteForce;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SquareRootTest {

    @Test
    void testSquareBruteForce() {
        assertEquals(0, squareBruteForce(0));
        assertEquals(1, squareBruteForce(1));
        assertEquals(1, squareBruteForce(2));
        assertEquals(2, squareBruteForce(4));
        assertEquals(2, squareBruteForce(8));
        assertEquals(3, squareBruteForce(9));
        assertEquals(46340, squareBruteForce(2147395600));
    }

    @Test
    void testSquareBinarySearch() {
        assertEquals(0, squareBinarySearch(0));
        assertEquals(1, squareBinarySearch(1));
        assertEquals(1, squareBinarySearch(2));
        assertEquals(2, squareBinarySearch(4));
        assertEquals(2, squareBinarySearch(8));
        assertEquals(3, squareBinarySearch(9));
        assertEquals(46340, squareBinarySearch(2147395600));
    }
}