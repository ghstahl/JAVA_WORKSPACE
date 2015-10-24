package chapter1;

public class Question5 {
	/**
	 * Implement a method to perform basic string compression using the counts
	 * of repeated characters. For example, the string aabcccccaaa would become
	 * a2blc5a3. If the "compressed" string would not become smaller than the
	 * original string, your method should return the original string.
	 */

	// Running time O(N), everything else (Memory, etc) is constant.
	public static String compress(String original) {

		int length = original.length();
		char compressed[] = new char[length];

		int count = 0;
		int currentIndex = 0;
		int lastChar = -1;
		for (int i = 0; i < length; ++i) {

			int currentChar = original.charAt(i);
			if (lastChar != currentChar) {
				if (count > 0) {
					// commit it
					compressed[currentIndex] = (char) lastChar;
					++currentIndex;
					if (currentIndex >= length) {
						return original;
					}
					char[] chars = ("" + count).toCharArray();
					for (int j = 0; j < chars.length; ++j, ++currentIndex) {
						if (currentIndex >= length) {
							return original;
						}
						compressed[currentIndex] = chars[j];
					}
					if (currentIndex >= length) {
						return original;
					}
				}
				lastChar = currentChar;
				count = 1;

			} else {
				++count;
			}

		}
		// commit the last char.
		// commit it
		compressed[currentIndex] = (char) lastChar;
		++currentIndex;
		if (currentIndex >= length) {
			return original;
		}
		char[] chars = ("" + count).toCharArray();
		for (int j = 0; j < chars.length; ++j, ++currentIndex) {
			if (currentIndex >= length) {
				return original;
			}
			compressed[currentIndex] = chars[j];
		}
		if (currentIndex >= length) {
			return original;
		}
		String actualResult = String.valueOf(compressed, 0, currentIndex);

		return actualResult;

	}

}
