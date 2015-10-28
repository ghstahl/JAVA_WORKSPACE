package chapter2;

/**
 * 
 * @author Dev
 * 
 *         Given a circular linked list, implement an algorithm which returns
 *         the node at the beginning of the loop. DEFINITION Circular linked
 *         list: A (corrupt) linked list in which a node's next pointer points
 *         to an earlier node, so as to make a loop in the linked list. EXAMPLE
 *         Input: A - > B - > C - > D - > E - > C [the same C as earlier]
 *         Output: C
 * 
 */
public class Question6 {

	// this is a 0(N) where we at worst cased have 2N movement throw the list.
	public static LinkedNode FindBeginingOfLoop(LinkedNode head) {

		LinkedNode slowCurrent = head;
		LinkedNode fastCurrent = head;
		// we will do a fast 2x runner which will go until it matches where the
		// slow runner is.
		do {
			slowCurrent = slowCurrent.Next;
			fastCurrent = fastCurrent.Next.Next;
		} while (slowCurrent != fastCurrent);

		// collision point.

		slowCurrent = head;

		do {
			slowCurrent = slowCurrent.Next;
			fastCurrent = fastCurrent.Next;
		} while (slowCurrent != fastCurrent);
		return slowCurrent;
	}

}
