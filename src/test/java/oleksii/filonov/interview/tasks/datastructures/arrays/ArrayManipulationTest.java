package oleksii.filonov.interview.tasks.datastructures.arrays;

import static oleksii.filonov.interview.tasks.datastructures.arrays.ArrayManipulation.max;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayManipulationTest {
	
	@Test
	public void testCase4() {
		assertEquals(7542539201L, max(4000, ArrayScanner.read2DArray(3, "ArrayManipulationTestCase04.txt")));
	}

}
