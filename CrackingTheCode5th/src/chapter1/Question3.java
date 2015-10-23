package chapter1;

public class Question3 {
	/**
	 * 1.2 Implement a function void reverse(char* str) in C or C++ which
	 * reverses a null terminated string
	 */

	// run time N, no sorting, assume 256 ASCII char set
	public static boolean isPermutation(String v1, String v2) {

		int length1 = v1.length();
		int length2 = v2.length();
		if (length1 != length2)
			return false;

		int s1[] = new int[256];
		int s2[] = new int[256];

		for (int i = 0; i < length1; ++i) {
			int charValue1 = v1.charAt(i);
			int charValue2 = v2.charAt(i);
			++s1[charValue1];
			++s2[charValue2];
		}

		for (int i = 0; i < s1.length; ++i) {

			if (s1[i] != s2[i])
				return false;
		}
		return true;
	}

}
