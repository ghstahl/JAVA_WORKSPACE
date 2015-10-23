package chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Question1Test {

	@Test
	public void testContainsNoDuplicates_Quadratic() {
		String test1 = "abcd";
		boolean b = Question1.ContainsDuplicatesQuadratic(test1);
		assertFalse(b);
	}

	@Test
	public void testContainsDuplicates_Quadratic() {
		String test1 = "abcda";
		boolean b = Question1.ContainsDuplicatesQuadratic(test1);
		assertTrue(b);
	}

	@Test
	public void testContainsNoDuplicates_N() {
		String test1 = "abcd";
		boolean b = Question1.ContainsDuplicatesN(test1);
		assertFalse(b);
	}

	@Test
	public void testContainsDuplicates_N() {
		String test1 = "abcda";
		boolean b = Question1.ContainsDuplicatesN(test1);
		assertTrue(b);
	}
}
