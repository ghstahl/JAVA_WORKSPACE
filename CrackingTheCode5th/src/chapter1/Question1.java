package chapter1;

public class Question1 {
	/**
	 * 1.1 Implement an algorithm to determine if a string has all unique
	 * characters. What if you cannot use additional data structures?
	 */

	public static boolean ContainsDuplicatesQuadratic(String value) {

		// I think this is N * (N/2) or (N^2)/2 and finally just N^2
		int length = value.length();
		for (int i = 0; i < length - 1; ++i) { // don't need to check the end
												// one
			for (int k = i + 1; k < length; ++k) {
				if (value.charAt(i) == value.charAt(k)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean ContainsDuplicatesN(String value) {
		int length = value.length();
		boolean dups[] = new boolean[128]; // all chars should map in here.
		for (int i = 0; i < length; ++i) { // don't need to check the end
			int charValue = value.charAt(i);

			if (dups[charValue])
				return true;
			dups[charValue] = true;

		}
		// TODO Auto-generated method stub
		return false;
	}

}
