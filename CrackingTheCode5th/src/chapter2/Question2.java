package chapter2;

/**
 * 
 * @author Dev
 * 
 *         Implement an algorithm to find the kth to last element of a singly
 *         linked list.
 */
public class Question2 {

	public static LinkedNode FetchNthFromEndNode(LinkedNode head, int nth) {
		LinkedNode nLast = head.last();
		LinkedNode ntheNode = nLast.retreat(nth - 1);
		return ntheNode;
	}

}
