package oleksii.filonov.interview.tasks.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {

	public static int[] generatePrimeNumbersUpTo(int limit) {
		List<Integer> numbers = new ArrayList<>();
		if (limit >= 2) {
			numbers.add(2);
		}
		for (int i = 3; i <= limit; i++) {
			if (isPrime(i))
				numbers.add(i);
		}
		
		return numbers.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int countPrimesUpTo(int limit) {
		int counter = 0;
		boolean[] primes = new boolean[limit+1];
		for (int i = 2; i <= limit; i++) {
			if (!primes[i]) {
				counter++;
				for (int j = 2; j * i <= limit; j++) {
					primes[i * j] = true;
				}
			}
		}
		return counter;
	}

	public static boolean isPrime(int prime) {
		for (int i = 2; i * i <= prime; i++) {
			if (prime % i == 0)
				return false;
		}
		return true;
	}

}
