package chapter3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayBackedStackTest {

	@Test
	public void testConstructor() {
		Integer[] backingArray = new Integer[10];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		assertTrue(abs.empty());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testConstructor_OutOfBounds() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testConstructor_OutOfBounds2() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 29);
	}

	@Test
	public void testPush() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		assertTrue(abs.empty());
		abs.push(1);
		assertFalse(abs.empty());
	}

	@Test
	public void testPop() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		assertTrue(abs.empty());
		abs.push(1);
		assertFalse(abs.empty());
		Integer actual = abs.pop();
		assertEquals((Integer) 1, actual);
		assertTrue(abs.empty());
	}

	@Test
	public void testPeek() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		assertTrue(abs.empty());
		abs.push(1);
		assertFalse(abs.empty());
		Integer actual = abs.peek();
		assertEquals((Integer) 1, actual);
		assertFalse(abs.empty());
	}

	@Test
	public void testEmpty() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		assertTrue(abs.empty());
	}

	@Test
	public void testNotEmpty() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		abs.push(1);
		assertFalse(abs.empty());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testUpperBound() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		for (Integer i = 0; i < 10; ++i) {
			abs.push(i);
		}
		assertFalse(abs.empty());
		abs.push(1);// this should throw

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testLowerBound() {
		Integer[] backingArray = new Integer[100];
		ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, 0, 9);
		for (Integer i = 0; i < 10; ++i) {
			abs.push(i);
		}
		assertFalse(abs.empty());
		for (Integer i = 0; i < 10; ++i) {
			abs.pop();
		}
		assertTrue(abs.empty());

		abs.pop();// this should throw

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3Stacks_BoundaryUpper1() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs1 = new ArrayBackedStack<>(backingArray, 0, 2);
		ArrayBackedStack<Integer> abs2 = new ArrayBackedStack<>(backingArray, 3, 5);
		ArrayBackedStack<Integer> abs3 = new ArrayBackedStack<>(backingArray, 6, 8);

		for (Integer i = 0; i < 3; ++i) {
			abs1.push(i);
		}
		assertFalse(abs1.empty());

		for (Integer i = 3; i < 6; ++i) {
			abs2.push(i);
		}
		assertFalse(abs2.empty());

		for (Integer i = 6; i < 9; ++i) {
			abs3.push(i);
		}
		assertFalse(abs3.empty());

		abs1.push(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3Stacks_BoundaryLower1() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs1 = new ArrayBackedStack<>(backingArray, 0, 2);
		ArrayBackedStack<Integer> abs2 = new ArrayBackedStack<>(backingArray, 3, 5);
		ArrayBackedStack<Integer> abs3 = new ArrayBackedStack<>(backingArray, 6, 8);

		for (Integer i = 0; i < 3; ++i) {
			abs1.push(i);
		}
		assertFalse(abs1.empty());

		for (Integer i = 3; i < 6; ++i) {
			abs2.push(i);
		}
		assertFalse(abs2.empty());

		for (Integer i = 6; i < 9; ++i) {
			abs3.push(i);
		}
		assertFalse(abs3.empty());

		for (Integer i = 0; i < 3; ++i) {
			abs1.pop();
		}
		assertTrue(abs1.empty());
		abs1.pop();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3Stacks_BoundaryUpper2() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs1 = new ArrayBackedStack<>(backingArray, 0, 2);
		ArrayBackedStack<Integer> abs2 = new ArrayBackedStack<>(backingArray, 3, 5);
		ArrayBackedStack<Integer> abs3 = new ArrayBackedStack<>(backingArray, 6, 8);

		for (Integer i = 0; i < 3; ++i) {
			abs1.push(i);
		}
		assertFalse(abs1.empty());

		for (Integer i = 3; i < 6; ++i) {
			abs2.push(i);
		}
		assertFalse(abs2.empty());

		for (Integer i = 6; i < 9; ++i) {
			abs3.push(i);
		}
		assertFalse(abs3.empty());

		abs2.push(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3Stacks_BoundaryLower2() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs1 = new ArrayBackedStack<>(backingArray, 0, 2);
		ArrayBackedStack<Integer> abs2 = new ArrayBackedStack<>(backingArray, 3, 5);
		ArrayBackedStack<Integer> abs3 = new ArrayBackedStack<>(backingArray, 6, 8);

		for (Integer i = 0; i < 3; ++i) {
			abs1.push(i);
		}
		assertFalse(abs1.empty());

		for (Integer i = 3; i < 6; ++i) {
			abs2.push(i);
		}
		assertFalse(abs2.empty());

		for (Integer i = 6; i < 9; ++i) {
			abs3.push(i);
		}
		assertFalse(abs3.empty());

		for (Integer i = 0; i < 3; ++i) {
			abs2.pop();
		}
		assertTrue(abs2.empty());
		abs2.pop();
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3Stacks_BoundaryUpper3() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs1 = new ArrayBackedStack<>(backingArray, 0, 2);
		ArrayBackedStack<Integer> abs2 = new ArrayBackedStack<>(backingArray, 3, 5);
		ArrayBackedStack<Integer> abs3 = new ArrayBackedStack<>(backingArray, 6, 8);

		for (Integer i = 0; i < 3; ++i) {
			abs1.push(i);
		}
		assertFalse(abs1.empty());

		for (Integer i = 3; i < 6; ++i) {
			abs2.push(i);
		}
		assertFalse(abs2.empty());

		for (Integer i = 6; i < 9; ++i) {
			abs3.push(i);
		}
		assertFalse(abs3.empty());

		abs3.push(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3Stacks_BoundaryLower3() {
		Integer[] backingArray = new Integer[9];
		ArrayBackedStack<Integer> abs1 = new ArrayBackedStack<>(backingArray, 0, 2);
		ArrayBackedStack<Integer> abs2 = new ArrayBackedStack<>(backingArray, 3, 5);
		ArrayBackedStack<Integer> abs3 = new ArrayBackedStack<>(backingArray, 6, 8);

		for (Integer i = 0; i < 3; ++i) {
			abs1.push(i);
		}
		assertFalse(abs1.empty());

		for (Integer i = 3; i < 6; ++i) {
			abs2.push(i);
		}
		assertFalse(abs2.empty());

		for (Integer i = 6; i < 9; ++i) {
			abs3.push(i);
		}
		assertFalse(abs3.empty());

		for (Integer i = 0; i < 3; ++i) {
			abs3.pop();
		}
		assertTrue(abs3.empty());
		abs3.pop();
	}
}
