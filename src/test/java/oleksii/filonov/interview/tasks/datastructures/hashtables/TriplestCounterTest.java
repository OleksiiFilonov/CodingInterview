package oleksii.filonov.interview.tasks.datastructures.hashtables;

import static java.util.Arrays.asList;
import static oleksii.filonov.interview.tasks.datastructures.arrays.ArrayScanner.readLongArray;
import static oleksii.filonov.interview.tasks.datastructures.hashtables.TriplestCounter.countTriplets;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TriplestCounterTest {

	@Test
	public void testRepeatableWithOneRation() {
		assertEquals(1L, countTriplets(List.of(1L, 1L, 1L), 1));
		assertEquals(4L, countTriplets(List.of(1L, 1L, 1L, 1L), 1));
		assertEquals(10L, countTriplets(List.of(1L, 1L, 1L, 1L, 1L), 1));
	}
	
	
	@Test
	public void testProgressionThree() {
		//assertEquals(6L, countTriplets1(List.of(1L, 3L, 9L, 9L, 27L, 81L), 3));
		assertEquals(6L, countTriplets(List.of(1L, 3L, 9L, 9L, 27L, 81L), 3));
	}

	@Test
	public void testLargeInputOnOne() { 
		
		assertEquals(1667018988625L, countTriplets(asList(readLongArray("TriplestCounterTestCase11.txt")), 1L));
	}

	@Test
	public void testTestCase02InputOnOne() {
		assertEquals(161700L, countTriplets(asList(readLongArray("TriplestCounterTestCase02.txt")), 1L));
	}

}
