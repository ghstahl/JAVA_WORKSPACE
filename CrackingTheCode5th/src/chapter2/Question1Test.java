package chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question1Test {

	@Test
	public void testRemoveDuplicates() {
		LinkedNode node0 = new LinkedNode<Integer>(0);
		LinkedNode node1 = new LinkedNode<Integer>(1);
		LinkedNode node2 = new LinkedNode<Integer>(2);
		LinkedNode node3 = new LinkedNode<Integer>(3);
		LinkedNode node4 = new LinkedNode<Integer>(4);

		node1.prepend(node0);
		node1.append(node2);
		node2.append(node4);
		node4.prepend(node3);

		node1.prepend(new LinkedNode<Integer>((Integer) node0.get()));
		node1.append(new LinkedNode<Integer>((Integer) node2.get()));
		node2.append(new LinkedNode<Integer>((Integer) node4.get()));
		node4.prepend(new LinkedNode<Integer>((Integer) node3.get()));

		Question1.RemoveDuplicates(node0);

		LinkedNode nodeExpected = new LinkedNode<Integer>(0);
		node1 = new LinkedNode<Integer>(1);
		node2 = new LinkedNode<Integer>(2);
		node3 = new LinkedNode<Integer>(3);
		node4 = new LinkedNode<Integer>(4);

		nodeExpected.append(node1);
		node1.append(node2);
		node2.append(node4);
		node4.append(node3);

		LinkedNode current = nodeExpected;
		LinkedNode oriCurrent = node0;
		while (current != null) {

			assertEquals(current.get(), oriCurrent.get());
			current = current.Next;
			oriCurrent = oriCurrent.Next;
		}

	}

}
