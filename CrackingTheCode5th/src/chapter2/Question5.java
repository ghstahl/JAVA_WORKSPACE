package chapter2;

/**
 * 
 * @author Dev
 * 
 *         You have two numbers represented by a linked list, where each node
 *         contains a single digit. The digits are stored in reverse order, such
 *         that the Ts digit is at the head of the list. Write a function that
 *         adds the two numbers and returns the sum as a linked list. EXAMPLE
 *         Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295. Output: 2 ->
 *         1 -> 9.That is, 912. FOLLOW UP Suppose the digits are stored in
 *         forward order. Repeat the above problem. EXAMPLE Input: (6 -> 1 -> 7)
 *         + (2 -> 9 -> 5).That is, 617 + 295. Output: 9 -> 1 -> 2.That is, 912.
 * 
 */
public class Question5 {

	public static LinkedNode sum(LinkedNode node1, LinkedNode node2) {

		LinkedNode<Integer> actualCurrent = null;
		LinkedNode<Integer> head = null;
		LinkedNode n1Current = node1;
		LinkedNode n2Current = node2;

		int carryOver = 0;
		while (n1Current != null || n2Current != null || carryOver > 0) {

			int n1 = n1Current == null ? 0 : (int) n1Current.get();
			int n2 = n2Current == null ? 0 : (int) n2Current.get();

			int nR = n1 + n2 + carryOver;
			int digit = 0;
			if (nR / 10 == 1) {
				carryOver = 1;
				digit = nR - 10;
			} else {
				carryOver = 0;
				digit = nR;
			}
			LinkedNode currentDigit = new LinkedNode<Integer>(digit);
			if (actualCurrent != null) {
				actualCurrent.append(currentDigit);
			} else {
				head = currentDigit;
			}
			actualCurrent = currentDigit;

			n1Current = n1Current == null ? null : n1Current.Next;
			n2Current = n2Current == null ? null : n2Current.Next;

		}
		return head;

	}

}
