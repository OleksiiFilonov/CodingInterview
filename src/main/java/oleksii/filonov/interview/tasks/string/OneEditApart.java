package oleksii.filonov.interview.tasks.string;

/**
 * https://www.facebook.com/careers/life/sample_interview_questions
 * OneEditApart("cat", "dog") = false OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true OneEditApart("cat", "act") = false
 */
public class OneEditApart {

	private static boolean isOneEditApart(String sLong, String sShort) {
		if (Math.abs(sShort.length() - sLong.length()) > 1)
			return false;
		int difference = 0;
		// swap if short is longer then long
		if (sShort.length() > sLong.length()) {
			String temp = sShort;
			sShort = sLong;
			sLong = temp;
		}
		for (int i = 0, j = 0; i < sShort.length() && difference < 2; i++, j++) {
			if (sShort.charAt(i) != sLong.charAt(j)) {
				difference++;
				if (sLong.length() != sShort.length())
					j++; //if there is a different length increment longer index by 1
			}
		}
		return (difference == 1) || (difference == 0 && sLong.length() != sShort.length());
	}

	public static void main(String[] args) {
		System.out.println(isOneEditApart("cat", "dog"));// false
		System.out.println(isOneEditApart("cat", "cats"));// true
		System.out.println(isOneEditApart("cat", "cut"));// true
		System.out.println(isOneEditApart("cat", "cast"));// true
		System.out.println(isOneEditApart("cat", "at"));// true
		System.out.println(isOneEditApart("cat", "act"));// false
	}
}
