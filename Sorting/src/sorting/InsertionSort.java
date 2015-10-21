package sorting;

import java.util.List;

public class InsertionSort {
	public static int sort(List<Integer> unsortedList) {

		// 1 item... done.
		if (unsortedList.size() < 2)
			return 1;

		int cost = 0;
		int count = unsortedList.size();
		for (int i = 1; i < count; ++i) {
			for (int k = i; k > 0; --k) {
				++cost;
				int current = unsortedList.get(k);
				int prev = unsortedList.get(k - 1);

				if (current > prev) {
					break;
				}

				// swap it
				unsortedList.set(k, prev);
				unsortedList.set(k - 1, current);
			}
		}

		return cost;
	}
}
