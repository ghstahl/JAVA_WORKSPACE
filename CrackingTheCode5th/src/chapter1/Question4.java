package chapter1;

public class Question4 {
	/**
	 * Write a method to replace all spaces in a string with'%20'. You may
	 * assume that the string has sufficient space at the end of the string to
	 * hold the additional characters, and that you are given the "true" length
	 * of the string. (Note: if implementing in Java, please use a character
	 * array so that you can perform this operation in place.) EXAMPLE Input:
	 * "Mr John Smith Output: "Mr%20John%20Smith"
	 */

	// O(N) runtime, memory constant, and for the most part move in place. if
	// you ignort the toCharArray.
	public static String replace(String original, String what) {

		int openSpaceIndex = original.length() - 1;
		boolean wordDetected = false;
		char[] myChars = original.toCharArray();
		char[] myWhat = what.toCharArray();
		for (int i = myChars.length - 1; i >= 0; --i) {
			int current = original.charAt(i);
			if (original.charAt(i) != 32) {
				wordDetected = true;
				myChars[openSpaceIndex] = original.charAt(i);
				--openSpaceIndex;
			} else {
				if (wordDetected) {
					// we have shifted a word all the way to the right, so time
					// to write the replace string.
					for (int j = myWhat.length - 1; j >= 0; --j, --openSpaceIndex) {
						myChars[openSpaceIndex] = myWhat[j];
					}
					wordDetected = false;
				}
			}
		}
		String finalOutput = String.valueOf(myChars);
		return finalOutput;

	}

}
