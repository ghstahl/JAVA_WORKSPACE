package sorting;

import java.util.List;

public class SelectionSort {
	public static int sort(List<Integer> unsortedList) {
		if (unsortedList.size() < 2)
			return 1;

		int cost = 0;
		int count = unsortedList.size();
		for (int i = 0; i < count; ++i) {

			int minumumItem = unsortedList.get(i);
			int currentItem = minumumItem;

			int minIndex = i;
			for (int k = i + 1; k < count; ++k) {
				++cost;
				int current = unsortedList.get(k);
				if (current < minumumItem) {
					minumumItem = current;
					minIndex = k;
				}
			}
			if (minIndex > i) {

				unsortedList.set(i, minumumItem);
				unsortedList.set(minIndex, currentItem);
			}
		}

		return cost;
	}
}
