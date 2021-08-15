package oleksii.filonov.interview.tasks.sorting;

/**
 * Task from https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting 
 */
public class FraudulentActivityNotificator {

	// Complete the activityNotifications function below.
	public static int activityNotifications(int[] expenditure, int d) {
		int notificationCounter = 0;
		if (d > expenditure.length)
			return notificationCounter;
		MeanCalculator meanCalculator = new MeanCalculator(expenditure, d);

		for (int i = d; i < expenditure.length; i++) {
			int max = meanCalculator.calculateMaxExpenditure();
			if (max <= expenditure[i]) {
				notificationCounter++;
			}
			meanCalculator.update(expenditure[i - d], expenditure[i]);
		}
		return notificationCounter;
	}

	public static final class MeanCalculator {
		private static final int MAX_EXP = 201;
		private final int[] frequencies = new int[MAX_EXP];
		private int middle;
		private final boolean isEven;

		public MeanCalculator(final int[] initial, final int d) {
			for (int i = 0; i < d; i++) {
				frequencies[initial[i]]++;
			}
			isEven = (d % 2 == 0);
			middle = d / 2;
		}

		public void update(int toEvict, int toAdd) {
			frequencies[toEvict]--;
			frequencies[toAdd]++;
		}

		public int calculateMaxExpenditure() {
			int freqSum = 0;
			for (int i = 0; i < MAX_EXP; i++) {
				freqSum += frequencies[i];
				if (freqSum > middle) {
					return 2 * i;
				}
				if (isEven) {
					if (freqSum == middle) {
						int first = i;
						for (i++; i < MAX_EXP; i++) {
							if (frequencies[i] > 0) {
								return first + i;
							}
						}
					}
				}
			}
			throw new RuntimeException("This point should not be reached");
		}
	}

}
