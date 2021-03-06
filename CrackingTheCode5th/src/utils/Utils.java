package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
	/**
	 * Returns a pseudo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

		// NOTE: This will (intentionally) not run as written so that folks
		// copy-pasting have to think about how to initialize their
		// Random instance. Initialization of the Random instance is outside
		// the main scope of the question, but some decent options are to have
		// a field that is initialized once and then re-used as needed or to
		// use ThreadLocalRandom (if using at least Java 1.7).
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static List<Integer> makeList(Integer... arguments) {
		List<Integer> theList = new ArrayList<Integer>();
		for (Integer n : arguments) {
			theList.add(n);
		}
		return theList;
	}

	public static List<Integer> generateRandomList(int length) {
		List<Integer> unsortedList = new ArrayList<Integer>();
		for (int i = 0; i < length; ++i) {
			int val = randInt(0, length);
			unsortedList.add(val);
		}
		return unsortedList;
	}

}
