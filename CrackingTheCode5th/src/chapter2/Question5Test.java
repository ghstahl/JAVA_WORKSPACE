package chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question5Test {

	@Test
	public void testSum_Simple() {
		LinkedNode node0a = new LinkedNode<Integer>(7);
		LinkedNode node0b = new LinkedNode<Integer>(1);
		LinkedNode node0c = new LinkedNode<Integer>(6);
		node0a.append(node0b);
		node0b.append(node0c);

		LinkedNode node1a = new LinkedNode<Integer>(5);
		LinkedNode node1b = new LinkedNode<Integer>(9);
		LinkedNode node1c = new LinkedNode<Integer>(2);

		node1a.append(node1b);
		node1b.append(node1c);

		LinkedNode expected = new LinkedNode<Integer>(2);
		LinkedNode expectedb = new LinkedNode<Integer>(1);
		LinkedNode expectedc = new LinkedNode<Integer>(9);

		expected.append(expectedb);
		expectedb.append(expectedc);

		LinkedNode actual = Question5.sum(node0a, node1a);

		LinkedNode current = expected;
		LinkedNode oriCurrent = actual;
		while (current != null) {

			assertEquals(current.get(), oriCurrent.get());
			current = current.Next;
			oriCurrent = oriCurrent.Next;
		}

		assertEquals(expected.count(), actual.count());
	}

	@Test
	public void testSum_Complex() {
		LinkedNode node0a = new LinkedNode<Integer>(9);
		LinkedNode node0b = new LinkedNode<Integer>(9);
		LinkedNode node0c = new LinkedNode<Integer>(9);
		LinkedNode node0d = new LinkedNode<Integer>(9);
		node0a.append(node0b);
		node0b.append(node0c);
		node0c.append(node0d);

		LinkedNode node1a = new LinkedNode<Integer>(9);
		LinkedNode node1b = new LinkedNode<Integer>(9);
		LinkedNode node1c = new LinkedNode<Integer>(9);

		node1a.append(node1b);
		node1b.append(node1c);

		LinkedNode expected = new LinkedNode<Integer>(8);
		LinkedNode expectedb = new LinkedNode<Integer>(9);
		LinkedNode expectedc = new LinkedNode<Integer>(9);
		LinkedNode expectedd = new LinkedNode<Integer>(0);
		LinkedNode expectede = new LinkedNode<Integer>(1);

		expected.append(expectedb);
		expectedb.append(expectedc);
		expectedc.append(expectedd);
		expectedd.append(expectede);

		LinkedNode actual = Question5.sum(node0a, node1a);

		LinkedNode current = expected;
		LinkedNode oriCurrent = actual;
		while (current != null) {

			assertEquals(current.get(), oriCurrent.get());
			current = current.Next;
			oriCurrent = oriCurrent.Next;
		}

		assertEquals(expected.count(), actual.count());
	}

}
