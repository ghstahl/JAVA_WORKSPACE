package primeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeSieve {

	private static List<Integer> _primes;

	public static List<Integer> makePrimes(int nLimit) {

		List<Integer> primes = new ArrayList<Integer>();
		int N = nLimit; // from 1 to 10000, find the primes

		// initially assume all integers are prime
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}
		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= N; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static List<Integer> Primes() {
		if (_primes == null) {
			_primes = makePrimes(120);
		}
		return _primes;
	}
}