package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<String> makePermutations(String original) {
		List<String> container = new ArrayList<String>();
		makePermutations(container, "", original);
		// TODO Auto-generated method stub
		return container;
	}

	/*
	 * BASE CASE: The front part of the string is passed in. If there is only
	 * one char in the end then we combine the 2 and add the final string to the
	 * list.
	 * 
	 * Iteration. 1. Front part is passed in, don't touch that. 2. Iterate
	 * through each character in the back and append that to the front, making a
	 * new front. 3. Combine the remaining chars in the back and this becomes
	 * the new back. 4. Pass this new stuff into the recursive method.
	 * 
	 */
	public static void makePermutations(List<String> container, String front, String back) {
		if (back.length() == 0)
			return;
		if (back.length() == 1) {
			// final string.
			String perm = front + back;
			container.add(perm);
		} else {
			int length = back.length();
			for (int i = 0; i < back.length(); ++i) {
				String newFront = front + back.charAt(i);
				String newBack = "" + back.substring(0, i);
				if (i + 1 < length) {
					newBack += back.substring(i + 1, length);
				}
				makePermutations(container, newFront, newBack);
			}
		}
	}

}
