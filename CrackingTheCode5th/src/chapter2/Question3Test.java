package chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question3Test {

	@Test
	public void testPhanthomDelete() {
		LinkedNode node0 = new LinkedNode<Integer>(0);
		LinkedNode node1 = new LinkedNode<Integer>(1);
		LinkedNode node2 = new LinkedNode<Integer>(2);
		LinkedNode node3 = new LinkedNode<Integer>(3);
		LinkedNode node4 = new LinkedNode<Integer>(4);

		node1.prepend(node0);
		node1.append(node2);
		node2.append(node4);
		node4.prepend(node3);

		assertEquals(null, node0.Prev);
		assertEquals(null, node4.Next);

		assertEquals(node0, node1.Prev);
		assertEquals(node1, node2.Prev);
		assertEquals(node2, node3.Prev);
		assertEquals(node3, node4.Prev);

		assertEquals(node1, node0.Next);
		assertEquals(node2, node1.Next);
		assertEquals(node3, node2.Next);
		assertEquals(node4, node3.Next);

		Question3.phanthomDelete(node2);

		assertEquals(node1, node0.Next);
		assertEquals(node3.get(), node1.Next.get());
		assertEquals(node4, node3.Next);

	}

}
