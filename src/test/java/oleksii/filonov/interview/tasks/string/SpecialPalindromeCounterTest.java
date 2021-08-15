package oleksii.filonov.interview.tasks.string;

import static oleksii.filonov.interview.tasks.string.SpecialPalindromeCounter.substrCount;
import static oleksii.filonov.interview.tasks.string.StringUtils.readLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class SpecialPalindromeCounterTest {

	@Test
	public void simpleTestCases() {
		assertEquals(7L, substrCount(5, "asasd"));
		assertEquals(10L, substrCount(7, "abcbaba"));
		assertEquals(10L, substrCount(4, "aaaa"));
		assertEquals(21L, substrCount(11, "aabaaacdccc"));
	}
	
	@Test
	public void testCase07() throws IOException {
		assertEquals(1730216, substrCount(740908, readLine("SpecialPalindromeCounterTestCase07.txt")));
	}

}
