package primeFactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static List<Integer> generate(int n) {
		List<Integer> primeList = new ArrayList<Integer>();

		Integer nCurrent = n;
		for (Integer prime : PrimeSieve.Primes()) {
			if (prime > nCurrent)
				break;
			while (nCurrent % prime == 0) {
				nCurrent = nCurrent / prime; // nfactor = 50, then 25
				primeList.add(prime);
			}
		}

		return primeList;
	}
}
