package oleksii.filonov.interview.tasks.math;

import static oleksii.filonov.interview.tasks.math.PrimeNumberGenerator.countPrimesUpTo;
import static oleksii.filonov.interview.tasks.math.PrimeNumberGenerator.generatePrimeNumbersUpTo;
import static oleksii.filonov.interview.tasks.math.PrimeNumberGenerator.isPrime;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrimeNumberGeneratorTest {

	@Test
	public void testPrimeNumbers() {
		assertArrayEquals(new int[] { 2 }, generatePrimeNumbersUpTo(2));
		assertEquals(1, countPrimesUpTo(2));
		assertArrayEquals(new int[] { 2, 3 }, generatePrimeNumbersUpTo(3));
		assertEquals(2, countPrimesUpTo(3));
		assertArrayEquals(new int[] { 2, 3 }, generatePrimeNumbersUpTo(4));
		assertEquals(2, countPrimesUpTo(4));
		assertArrayEquals(new int[] { 2, 3, 5 }, generatePrimeNumbersUpTo(5));
		assertEquals(3, countPrimesUpTo(5));
	}
	
	@Test
	public void testIsPrime() {
		assertTrue(isPrime(2));
		assertTrue(isPrime(3));
		assertTrue(isPrime(11));
		assertTrue(isPrime(23));
		assertTrue(isPrime(31));
		assertFalse(isPrime(33));
		assertFalse(isPrime(4));
		assertFalse(isPrime(12));
	}

}
