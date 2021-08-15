package oleksii.filonov.interview.tasks;

import static oleksii.filonov.interview.tasks.VowelsReversal.reverseVowels;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VowelsReversalTest {
	
	@Test
	public void test() {
		assertEquals("apple is transferred to eppla", "eppla", reverseVowels("apple"));
		assertEquals("simethong", reverseVowels("something"));
		assertEquals("censequenco", reverseVowels("consequence"));
		assertEquals("desaesi", reverseVowels("disease"));
	}

}
