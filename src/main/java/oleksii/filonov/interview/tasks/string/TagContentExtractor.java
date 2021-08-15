package oleksii.filonov.interview.tasks.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();

			System.out.println(extractTag(line));

			testCases--;
		}
	}

	public static String extractTag(String line) {
		String tagContent = "content";
		String result = "None";
		Pattern pattern = Pattern.compile("<(.+)>(?<" + tagContent + ">[^<]+)</\\1>");
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			result = matcher.group(tagContent);
			line = cutLine(line, matcher);
			while (!line.isEmpty()) {
				matcher = pattern.matcher(line);
				if (matcher.find()) {
					result += "\n" + matcher.group(tagContent);
					line = cutLine(line, matcher);
				} else {
					break;
				}
			}
		}
		return result;
	}

	private static String cutLine(String line, Matcher matcher) {
		line = line.substring(matcher.end());
		return line;
	}

}
