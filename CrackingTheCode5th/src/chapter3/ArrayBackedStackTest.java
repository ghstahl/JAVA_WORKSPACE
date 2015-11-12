package chapter3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayBackedStackTest {

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
}
