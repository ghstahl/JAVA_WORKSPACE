package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static Integer SafeFetch(List<Integer> list, int current) {
		if (current >= list.size())
			return null;
		return list.get(current);
	}

	public static List<Integer> merge(List<Integer> first, List<Integer> second) {
		List<Integer> mergedList = new ArrayList<>();

		mergedList.clear(); // don't need these anymore.
		int fIndex = 0;
		int sIndex = 0;
		Integer firstCurrent = SafeFetch(first, fIndex);
		Integer secondCurrent = SafeFetch(second, sIndex);

		while (firstCurrent != null || secondCurrent != null) {

			if (firstCurrent == null) {
				// secondCurrent therefore is not null
				mergedList.add(secondCurrent);
				++sIndex;
				secondCurrent = SafeFetch(second, sIndex);
			} else if (secondCurrent == null) {
				// firstCurrent therefore is not null
				mergedList.add(firstCurrent);
				++fIndex;
				firstCurrent = SafeFetch(first, fIndex);
			} else {

				if (firstCurrent < secondCurrent) {
					mergedList.add(firstCurrent);
					++fIndex;
					firstCurrent = SafeFetch(first, fIndex);
				} else {
					mergedList.add(secondCurrent);
					++sIndex;
					secondCurrent = SafeFetch(second, sIndex);
				}
			}
		}
		return mergedList;
	}

	public static MergeTuple<List<Integer>, Integer> sort(List<Integer> unsortedList) {
		if (unsortedList.size() < 2) {
			return new MergeTuple<List<Integer>, Integer>(unsortedList, 1);
		}

		int cost = 0;
		int count = unsortedList.size();

		int halved = count / 2;

		List<Integer> inputA = unsortedList.subList(0, halved);
		List<Integer> inputB = unsortedList.subList(halved, count);

		MergeTuple<List<Integer>, Integer> mergeTupleA = null;
		MergeTuple<List<Integer>, Integer> mergeTupleB = null;

		mergeTupleA = sort(inputA);

		mergeTupleB = sort(inputB);

		cost += mergeTupleA.y;
		cost += mergeTupleB.y;

		// now merge them.
		List<Integer> mList = merge(mergeTupleA.x, mergeTupleB.x);
		return new MergeTuple<List<Integer>, Integer>(mList, cost);

	}
}
