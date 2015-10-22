package sorting;

import java.util.List;

public class QuickSort {
	public static int sort(List<Integer> unsortedList) {

		// 1 item... done.
		if (unsortedList.size() < 2)
			return 1;
		int cost = 0;
		Integer pivot = unsortedList.get(0);
		int flipIndex = 1;
		for (int i = flipIndex; i < unsortedList.size(); ++i) {
			++cost;
			Integer flip = unsortedList.get(i);
			if (flip < pivot) {
				// swap this with the flip;
				Integer firstFlip = unsortedList.get(flipIndex);
				unsortedList.set(flipIndex, flip);
				unsortedList.set(i, firstFlip);
				++flipIndex;
			}
		}

		Integer lastSmallestItem = unsortedList.get(flipIndex - 1);
		unsortedList.set(flipIndex - 1, pivot);
		unsortedList.set(0, lastSmallestItem);

		if (flipIndex > 1) {
			List<Integer> leftPartion = unsortedList.subList(0, flipIndex - 1);
			cost += sort(leftPartion);
		}

		if (flipIndex < (unsortedList.size() - 1)) {
			List<Integer> rightPartion = unsortedList.subList(flipIndex, unsortedList.size());
			cost += sort(rightPartion);
		}

		return cost;
	}
}
