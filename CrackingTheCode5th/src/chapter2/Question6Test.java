package chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question6Test {
	public static LinkedNode buildList(Integer count) {
		LinkedNode head = new LinkedNode<Integer>(0);
		LinkedNode current = head;
		for (int i = 1; i < count; ++i) {
			LinkedNode node = new LinkedNode<Integer>(i);
			current.append(node);
			current = current.Next;
		}
		return head;
	}

	@Test
	public void testFindBeginingOfLoop() {
		LinkedNode head = buildList(10);
		LinkedNode tail = head.tail();
		LinkedNode loopStart = head.advance(2);
		tail.Next = loopStart; // corrupt it

		LinkedNode actual = Question6.FindBeginingOfLoop(head);
		assertEquals(actual, loopStart);
	}

}
