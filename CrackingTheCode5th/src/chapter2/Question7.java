package chapter2;

/**
 * 
 * @author Dev
 * 
 *         Implement a function to check if a linked list is a palindrome
 */
public class Question7 {

	// this is a 0(N) or technically N/2 max.
	public static Boolean isPalindrome(LinkedNode node) {

		LinkedNode head = node.head();
		LinkedNode tail = node.tail();

		while (head != tail) {
			if ((Integer) head.get() != (Integer) tail.get())
				return false;
			head = head.Next;
			tail = tail.Prev;
		}

		return true;
	}

}
