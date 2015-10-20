package bubbleSort;

import java.util.List;

public class BubbleSort {

	public static int sort(List<Integer> unsortedList) {
		// TODO Auto-generated method stub

		int cost = 0;
		int count = unsortedList.size();
		Boolean dirtyList = true;
		while (dirtyList) {
			dirtyList = false;
			for (int i = 0; i < count - 1; ++i) {
				++cost;
				int current = unsortedList.get(i);
				int next = unsortedList.get(i + 1);
				if (current > next) {
					dirtyList = true;
					// swap it.
					unsortedList.set(i, next);
					unsortedList.set(i + 1, current);
				}
			}
		}
		return cost;
	}

}
