package chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question2Test {

	@Test
	public void testReverseEven() {
		String test = "1234";
		String reversed = Question2.Reverse("4321");
		assertEquals(test, reversed);
	}

	@Test
	public void testReverseOdd() {

		String test = "12345";
		String reversed = Question2.Reverse("54321");
		assertEquals(test, reversed);
	}

	@Test
	public void testReverseSingle() {

		String test = "1";
		String reversed = Question2.Reverse("1");
		assertEquals(test, reversed);
	}

	@Test
	public void testReverseNull() {

		String test = null;
		String reversed = Question2.Reverse(null);
		assertEquals(test, reversed);
	}

}
