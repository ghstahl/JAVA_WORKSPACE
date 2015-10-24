package chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question5Test {

	@Test
	public void testCompress_YES() {
		String original = "aabcccccaaa";
		String expectedResult = "a2b1c5a3";

		String actualResult = Question5.compress(original);
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testCompress_CompressedBigger() {
		String original = "abcd";
		String expectedResult = "abcd";

		String actualResult = Question5.compress(original);
		assertEquals(expectedResult, actualResult);

	}

}
