package sorting;

import java.util.List;

public class ShellSort {
	public static int sort(List<Integer> unsortedList, int gap) {
		int count = unsortedList.size();
		int cost = 0;
		for (int i = gap; i < count; ++i) {
			for (int k = i; k - gap >= 0; k -= gap) {
				++cost;
				int current = unsortedList.get(k);
				int prev = unsortedList.get(k - gap);
				if (current < prev) {
					unsortedList.set(k, prev);
					unsortedList.set(k - gap, current);
				}
			}
		}
		return cost;
	}

	public static int sort(List<Integer> unsortedList) {
		if (unsortedList.size() < 2)
			return 1;
		int cost = 0;

		int count = unsortedList.size();
		int gap = count;
		do {
			gap = gap / 2;
			cost += sort(unsortedList, gap);
		} while (gap != 1);

		return cost;
	}
}
