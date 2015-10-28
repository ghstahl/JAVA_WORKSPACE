package chapter2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Question7Test {
	public static LinkedNode buildPalidromeList(Integer count) {
		LinkedNode head = new LinkedNode<Integer>(0);
		LinkedNode current = head;
		for (int i = 1; i < count; ++i) {
			LinkedNode nodeL = new LinkedNode<Integer>(i);
			LinkedNode nodeR = new LinkedNode<Integer>(i);
			head.append(nodeR);
			head.prepend(nodeL);
		}
		return head;
	}

	@Test
	public void testIsPalindrome_Not() {
		LinkedNode notPali = Question6Test.buildList(10);
		Boolean result = Question7.isPalindrome(notPali);
		assertFalse(result);

	}

	@Test
	public void testIsPalindrome_Yes() {
		LinkedNode pali = buildPalidromeList(10);
		Boolean result = Question7.isPalindrome(pali);
		assertTrue(result);

	}
}
