package oleksii.filonov.interview.tasks;

public class LookAndSay {

	private static void lookAndSay(String input, int limit) {
		if (input == null || input.isBlank())
			throw new IllegalArgumentException("input String can't be empty");
		Long.parseLong(input);
		System.out.println(input);
		while (input.length() < limit) {
			char[] chars = input.toCharArray();
			int index = 0;
			StringBuilder builder = new StringBuilder();
			while (index < chars.length) {
				int iterations = iterations(chars, index);
				builder.append(iterations).append(chars[index]);
				index += iterations;
			}
			input = builder.toString();
			System.out.println(input);
		}
	}

	private static int iterations(char[] chars, int index) {
		int counter = 1;
		while ((counter + index < chars.length) && chars[index] == chars[index + counter]) {
			counter++;
		}
		return counter;
	}
	
	public static void main(String[] args) {
		lookAndSay("sdfdf", 40);
	}
}
