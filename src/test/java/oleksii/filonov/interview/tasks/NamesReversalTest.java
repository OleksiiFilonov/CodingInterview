package oleksii.filonov.interview.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NamesReversalTest {
	
	private NamesReversal testInstance = new NamesReversal();
	
	@Test
	public void reverseManyNames() {
		assertEquals("Craig Albert Dilan Bob", testInstance.reverse("Bob Dilan Albert Craig", " "));
	}

	@Test
	public void reverseOneName() {
		assertEquals("Bob", testInstance.reverse("Bob", " "));
	}

	@Test
	public void reverseEmptyString() {
		assertTrue(testInstance.reverse("", " ").isEmpty());
	}

}
