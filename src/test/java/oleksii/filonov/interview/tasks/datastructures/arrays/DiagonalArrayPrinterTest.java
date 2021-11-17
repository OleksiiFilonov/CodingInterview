package oleksii.filonov.interview.tasks.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.datastructures.arrays.DiagonalArrayPrinter.printBFS;
import static oleksii.filonov.interview.tasks.datastructures.arrays.DiagonalArrayPrinter.printHashMap;
import static oleksii.filonov.interview.tasks.datastructures.arrays.DiagonalArrayPrinter.printIteratively;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DiagonalArrayPrinterTest {

    private static final int[][] testInput1 = new int[][]{
            {12, 7, 21, 31, 11},
            {45, -2, 14, 27, 19},
            {-3, 15, 36, 71, 26},
            {4, -13, 55, 34, 15}
    };
    private static final int[][] testOutput1 = new int[][]{
            {12},
            {7, 45},
            {21, -2, -3},
            {31, 14, 15, 4},
            {11, 27, 36, -13},
            {19, 71, 55},
            {26, 34},
            {15}
    };

    @Test
    void printIterativelyTest() {
        assertArrayEquals(testOutput1, printIteratively(testInput1));
    }

    @Test
    void printBFSTest() {
        assertArrayEquals(testOutput1, printBFS(testInput1));
    }

    @Test
    void printHashMapTest() {
        assertArrayEquals(testOutput1, printHashMap(testInput1));
    }
}