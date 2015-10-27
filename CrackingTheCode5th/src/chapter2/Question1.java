package chapter2;

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
	public static <T> void RemoveDuplicates(LinkedNode<T> head) {

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
}
