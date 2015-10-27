package chapter2;

/**
 * 
 * @author Dev
 * 
 *         Write code to partition a linked list around a value x, such that all
 *         nodes less than x come before all nodes greater than or equal to x.
 */
public class Question4 {

	public static void partitionAround(LinkedNode node) {
		LinkedNode clone = new LinkedNode<Integer>(0);// this is just a temp.
		LinkedNode lastOnTheLeft = node.Prev;
		LinkedNode current = node.Prev;
		while (current != null) {
			lastOnTheLeft = current;
			if ((Integer) current.get() < (Integer) node.get()) {
				// current is getting culled.
				lastOnTheLeft = current.Next; // current is not our last, the
												// one up is.
				LinkedNode nextCurrent = current.Prev; // thinking ahead
				LinkedNode deletedNode = current.delete();
				clone.prepend(deletedNode);
				current = nextCurrent;
			} else {
				current = current.Prev;
			}
		}

		LinkedNode lastOnRight = node.Next;
		current = node.Next;
		while (current != null) {
			lastOnRight = current;
			if ((Integer) current.get() < (Integer) node.get()) {
				// current is getting culled.
				lastOnRight = current.Prev;
				LinkedNode nextCurrent = current.Next; // thinking ahead
				LinkedNode deletedNode = current.delete();
				clone.prepend(deletedNode);
				current = nextCurrent;
			} else {
				current = current.Next;
			}
		}

		// there is node.
		// everything to the right and to the left of node is greater than or
		// equal to node.
		// The following is to make node the most left node.
		LinkedNode prev = node.Prev;
		if (prev != null) {
			// all prevs are bigger and have to be moved in
			node.Prev = null; // cut off of node.
			prev.Next = null;
			// node at this time is at the very left and yes, the smallest.

			// take what we cut and put it to the right of node.
			LinkedNode next = node.Next;
			node.Next = lastOnTheLeft;
			lastOnTheLeft.Prev = node;
			prev.Next = next; // this is the last of the left.
			next.Prev = prev;

		}

		// ok now we need to get our less than list and put it to the left of
		// node.

		node.Prev = clone.Prev;
		node.Prev.Next = node;

	}

}
