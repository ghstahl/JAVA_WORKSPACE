package primeFactors;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PrimeFactorsTest {

	@Test
	public void test() {

		for (int i = 0; i < PrimeSieve.Primes().size(); ++i) {

			List<Integer> primes = PrimeSieve.Primes();

			for (Integer prime : primes) {

				List<Integer> listUnderTest = new ArrayList<Integer>();

				listUnderTest.add(2);
				listUnderTest.add(2);
				listUnderTest.add(3);
				listUnderTest.add(3);
				listUnderTest.add(prime);

				Collections.sort(listUnderTest);

				Integer nValue = 1;
				for (Integer nn : listUnderTest) {
					nValue = nValue * nn;
				}

				List<Integer> genList = PrimeFactors.generate(nValue);
				assertEquals(genList, listUnderTest);
			}
		}
	}
}
