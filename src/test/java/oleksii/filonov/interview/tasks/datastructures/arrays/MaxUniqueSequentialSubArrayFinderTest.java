package oleksii.filonov.interview.tasks.datastructures.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import oleksii.filonov.interview.tasks.datastructures.arrays.MaxUniqueSequentialSubArrayFinder;

public class MaxUniqueSequentialSubArrayFinderTest {
	
	private class Input {
		private final int maxSubarray;
		private final int [] elements;
		
		public Input(int maxSubarray, int [] elements) {
			this.maxSubarray = maxSubarray;
			this.elements = elements;
		}
	}
	
	private Input scanInput(String inputFile) throws FileNotFoundException {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan = new Scanner(Paths.get(resourceDir.getPath(), inputFile).toFile());
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] elements = new int[n];
		for (int i = 0; i < n; i++) {
			elements[i] = scan.nextInt();
		}
		scan.close();
		return new Input(m, elements);
	}

	private int findMaximum(String inputFile) throws FileNotFoundException {
		Input input = scanInput(inputFile);
		int maximum = MaxUniqueSequentialSubArrayFinder.findMaximumUniqueSubArray(input.maxSubarray, input.elements);
		return maximum;
	}
	
/*	@Test
	public void findTheLongestUniqueSubArrayInput08() throws FileNotFoundException {
		assertEquals(94983, findMaximum("MaxUniqueSubArrayFinderInput08.txt"));
	}*/

	
	@Test
	public void findTheLongestUniqueSubArrayInput00() throws FileNotFoundException {
		assertEquals(3, findMaximum("MaxUniqueSubArrayFinderInput00.txt"));
	}
	
	@Test
	public void findTheLongestUniqueSubArrayInput07() throws FileNotFoundException {
		assertEquals(1, findMaximum("MaxUniqueSubArrayFinderInput07.txt"));
	}
	
	@Test
	public void testInput05() throws FileNotFoundException {
		assertEquals(0, findMaximum("MaxUniqueSubArrayFinderInput05.txt"));
	}

	@Test
	public void testInput06() throws FileNotFoundException {
		assertEquals(1, findMaximum("MaxUniqueSubArrayFinderInput06.txt"));
	}

	@Test
	public void testInput04() throws FileNotFoundException {
		assertEquals(6, findMaximum("MaxUniqueSubArrayFinderInput04.txt"));
	}
}
