package chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Question3Test {

	@Test
	public void testIsPermutation_Not() {
		assertFalse(Question3.isPermutation("abc", "bbb"));
	}

	@Test
	public void testIsPermutation_Yes() {
		assertTrue(Question3.isPermutation("abc", "cba"));
	}
}
