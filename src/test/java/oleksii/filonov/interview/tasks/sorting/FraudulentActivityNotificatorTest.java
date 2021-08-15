package oleksii.filonov.interview.tasks.sorting;

import static oleksii.filonov.interview.tasks.datastructures.arrays.ArrayScanner.readArray;
import static oleksii.filonov.interview.tasks.sorting.FraudulentActivityNotificator.activityNotifications;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import oleksii.filonov.interview.tasks.sorting.FraudulentActivityNotificator.MeanCalculator;

public class FraudulentActivityNotificatorTest {

	@Test
	public void testCase0_01_02() {
		assertEquals(2, activityNotifications(new int[] { 1, 1, 2, 2, 1, 1, 2, 1 }, 3));
		assertEquals(7, activityNotifications(new int[] { 1, 1, 2, 2, 1, 1, 5, 3, 4, 7, 9, 3, 4, 1, 2, 5, 1, 2, 4}, 4));
		assertEquals(2, activityNotifications(new int[] { 2, 3, 4, 2, 3, 6, 8, 4, 5 }, 5));
		assertEquals(0, activityNotifications(new int[] { 1, 2, 3, 4, 4 }, 5));
		assertEquals(1, activityNotifications(new int[] { 10, 20, 30, 40, 50 }, 3));
		assertEquals(1, activityNotifications(new int[] { 10, 20, 30, 40, 50 }, 2));
		assertEquals(5, activityNotifications(new int[] { 1, 2, 3, 4, 10, 30, 60, 80, 140, 2, 140 }, 5));
	}

	//This is very long test
	public void meanComparison() {
		int d = 40001;
		int [] expenditure = readArray("FraudulentActivityNotificatorTestCase05.txt");
		MeanCalculator meanCalculator = new MeanCalculator(expenditure, d);
		for (int i = d; i < expenditure.length; i++) {
			int max = meanCalculator.calculateMaxExpenditure();
			int [] forsorting = Arrays.copyOfRange(expenditure, i-d, i);
			Arrays.sort(forsorting);
			int expected = findMaxExpenditure(forsorting);
			assertEquals(expected, max, "Failed on iteration " + i);
			meanCalculator.update(expenditure[i - d], expenditure[i]);
		}
	}

	private int findMaxExpenditure(int[] forsorting) {
		int middle = forsorting.length/2;
		boolean isEven = forsorting.length/2 == 0;
		return isEven ? (forsorting[middle-1] + forsorting[middle]) : 2*forsorting[middle];
	}

	@Test
	public void testCase05() {
		assertEquals(926, activityNotifications(readArray("FraudulentActivityNotificatorTestCase05.txt"), 40001));
	}

	@Test
	public void testCase01() {
		assertEquals(633, activityNotifications(readArray("FraudulentActivityNotificatorTestCase01.txt"), 10000));
	}

}
