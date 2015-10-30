package recursion;

public class ReverseString {
	public static String reverse(String original) {

		return RecursiveReverse(original, 0, original.length());
	}

	/*
	 * End state is returning the last character in the original as a string. as
	 * it unwinds, we get the char of where we are located and append it to the
	 * end of what we got from the recursive call.
	 * 
	 * Recursion depth is O(N) Time is O(N)
	 */
	public static String RecursiveReverse(String original, int currentIndex, int count) {
		if (currentIndex == count - 1) {
			return "" + original.charAt(currentIndex);
		} else {
			char currentChar = original.charAt(currentIndex);
			String recRes = RecursiveReverse(original, currentIndex + 1, count) + currentChar;
			return recRes;
		}
	}
}
