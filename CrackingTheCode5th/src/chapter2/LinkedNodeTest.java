package chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedNodeTest {

	@Test
	public void testLinkedNode() {
		LinkedNode node = new LinkedNode<Integer>(1);
		assertEquals(1, node.get());
		assertEquals(null, node.Next);
		assertEquals(null, node.Prev);

	}

	@Test
	public void testBasicAppendPrepend() {
		LinkedNode node0 = new LinkedNode<Integer>(0);
		LinkedNode node1 = new LinkedNode<Integer>(1);
		LinkedNode node2 = new LinkedNode<Integer>(2);

		node1.prepend(node0);
		node1.append(node2);

		assertEquals(null, node0.Prev);
		assertEquals(null, node2.Next);

		assertEquals(node0, node1.Prev);
		assertEquals(node2, node1.Next);

		assertEquals(node1, node2.Prev);
		assertEquals(node1, node0.Next);

	}

	@Test
	public void testComplexAppendPrepend() {
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

	}

	@Test
	public void testSetGet() {
		LinkedNode node = new LinkedNode<Integer>(1);
		assertEquals(1, node.get());
		node.set(2);
		assertEquals(2, node.get());
		node.set(3);
		assertEquals(3, node.get());

	}

	@Test
	public void testDelete() {
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

		node2.delete();

		assertEquals(null, node0.Prev);
		assertEquals(null, node4.Next);

		assertEquals(node0, node1.Prev);
		assertEquals(node1, node3.Prev);
		assertEquals(node3, node4.Prev);

		assertEquals(node1, node0.Next);
		assertEquals(node3, node1.Next);
		assertEquals(node4, node3.Next);

	}

}
