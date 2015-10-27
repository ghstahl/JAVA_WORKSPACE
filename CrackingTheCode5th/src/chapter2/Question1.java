package chapter2;

import java.util.HashMap;

/**
 * 
 * @author Dev
 * 
 *         Write code to remove duplicates from an unsorted linked list. FOLLOW
 *         UP How would you solve this problem if a temporary buffer is not
 *         allowed?
 */
public class Question1 {

	// Quadratic removal O(N^2)
	public static <T> void RemoveDuplicatesQuadratic(LinkedNode<T> head) {

		LinkedNode current = head;
		while (current != null) {
			LinkedNode compCurrent = current.Next;
			while (compCurrent != null) {
				if (compCurrent.get() == current.get()) {
					LinkedNode prev = compCurrent.Prev;
					compCurrent.delete();
					compCurrent = prev.Next;
				} else {
					compCurrent = compCurrent.Next;
				}
			}
			current = current.Next;
		}
	}

	public static <T> void RemoveDuplicatesN(LinkedNode<T> head) {

		HashMap<T, Boolean> hmap = new HashMap<T, Boolean>();
		hmap.put((T) head.get(), true);

		LinkedNode current = head.Next;
		while (current != null) {
			if (hmap.containsKey(current.get())) {
				LinkedNode prev = current.Prev;
				current.delete();
				current = prev.Next;
			} else {
				hmap.put((T) current.get(), true);
				current = current.Next;
			}
		}
	}
}
