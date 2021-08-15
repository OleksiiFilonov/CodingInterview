package oleksii.filonov.interview.tasks.datastructures.arrays;

import static oleksii.filonov.interview.tasks.datastructures.arrays.ArrayScanner.readArray;
import static oleksii.filonov.interview.tasks.datastructures.arrays.MinimumSwaps.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinimumSwapsTest {
	
	@Test
	public void testCase14() {
		assertEquals(50000, calculate(readArray("MinimumSwapsTestCase14.txt")));
	}

	@Test
	public void testCase0() {
		assertEquals(3, calculate(new int [] {4, 3, 1, 2}));
	}
	
	@Test
	public void testCase1() {
		assertEquals(3, calculate(new int [] {2, 3, 4, 1, 5}));
	}

	@Test
	public void testCase2() {
		assertEquals(3, calculate(new int [] {1, 3, 5, 2, 4, 6, 7}));
	}

}
