package chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question4Test {

	@Test
	public void testReplace() {
		String original = "Mr John Smith    ";
		String outputExpected = "Mr%20John%20Smith";
		String actualOutput = Question4.replace(original, "%20");
		assertEquals(outputExpected, actualOutput);
	}

}
