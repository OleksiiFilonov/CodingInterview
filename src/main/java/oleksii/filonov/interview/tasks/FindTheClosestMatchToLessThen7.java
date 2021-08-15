package oleksii.filonov.interview.tasks;

public class FindTheClosestMatchToLessThen7 {

	public static void main(String[] args) {
		int result = 0;
		for (int i = 2; !(isReminder1(result, 6) && isReminder1(result, 5) && isReminder1(result, 4)
				&& isReminder1(result, 3) && isReminder1(result, 2)); i++) {
			result = i * 7;
		}
		System.out.println("Result: " + result);
	}

	private static boolean isReminder1(int numerator, int denominator) {
		return numerator % denominator == 1;
	}
}
