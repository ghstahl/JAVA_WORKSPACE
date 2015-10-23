package chapter1;

public class Question2 {
	/**
	 * 1.2 Implement a function void reverse(char* str) in C or C++ which
	 * reverses a null terminated string
	 */

	// run time N/2 or just O(N)
	public static String Reverse(String value) {
		if (value == null)
			return null;

		char[] myChars = value.toCharArray();

		int length = value.length();
		for (int i = 0, r = length - 1; i < length; ++i, --r) {
			if (i < r) {
				char left = value.charAt(i);
				char right = value.charAt(r);
				myChars[i] = right;
				myChars[r] = left;
			} else {
				break;
			}

		}
		return String.valueOf(myChars);
	}

}
