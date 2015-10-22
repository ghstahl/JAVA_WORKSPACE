package sorting;

import java.util.ArrayList;
import java.util.List;

import utils.WrapInt;

public class HeapNode {
	public HeapNode(boolean maxMode) {
		mode = maxMode;
		HeapArray.add(-1); // zeroth index never used. Makes calculations easier
							// to read later.
	}

	public List<Integer> HeapArray = new ArrayList<Integer>();
	private boolean mode = false;

	public void Insert(Integer n) {
		HeapArray.add(n);
		Integer index = HeapArray.size() - 1;
		WrapInt wrapIndex = new WrapInt();
		wrapIndex.value = index;
		BubbleUp(wrapIndex);
	}

	private boolean Compare(int a, int b) {
		if (mode) {
			return a > b;
		}
		return a < b;
	}

	public List<Integer> Sort() {
		List<Integer> sortedList = new ArrayList<Integer>();

		int lastIndex = HeapArray.size() - 1;
		while (lastIndex > 0) {
			Integer last = HeapArray.get(lastIndex);
			Integer top = HeapArray.get(1);
			sortedList.add(top);
			HeapArray.set(1, last);
			HeapArray.remove(lastIndex);
			WrapInt wrapIndex = new WrapInt();
			wrapIndex.value = 1;
			BubbleDown(wrapIndex);
			--lastIndex;
		}
		return sortedList;
	}

	private void BubbleDown(WrapInt wrapIndex) {
		int index = wrapIndex.value;
		Integer leftIndex = index * 2;
		Integer rightIndex = leftIndex + 1;

		if (leftIndex >= HeapArray.size()) {
			// out of bounds
			return;
		}

		Integer current = HeapArray.get(index);
		Integer left = HeapArray.get(leftIndex);
		if (rightIndex >= HeapArray.size()) {
			// out of bounds for right.
			if (Compare(left, current)) {
				// swapit.
				HeapArray.set(index, left);
				HeapArray.set(leftIndex, current);
				index = leftIndex;
				wrapIndex.value = index;
			}
			// done, if here we are at the last entry in the array

		} else {

			// we have a right and left leaf
			Integer right = HeapArray.get(rightIndex);

			if (Compare(left, right)) {
				if (Compare(left, current)) {
					// swapit.
					HeapArray.set(index, left);
					HeapArray.set(leftIndex, current);
					index = leftIndex;
					wrapIndex.value = index;
					BubbleDown(wrapIndex);
				}
			} else {
				if (Compare(right, current)) {
					// swapit.
					HeapArray.set(index, right);
					HeapArray.set(rightIndex, current);
					index = rightIndex;
					wrapIndex.value = index;
					BubbleDown(wrapIndex);
				}
			}
		}
		wrapIndex.value = index;
	}

	private void BubbleUp(WrapInt wrapIndex) {
		int index = wrapIndex.value;
		if (index < 2)
			return;

		Integer parentIndex = index / 2;

		Integer current = HeapArray.get(index);
		Integer parent = HeapArray.get(parentIndex);
		if (Compare(current, parent)) {
			// swap it.
			HeapArray.set(index, parent);
			HeapArray.set(parentIndex, current);
			index = parentIndex;
			wrapIndex.value = index;
			BubbleUp(wrapIndex);
		}
	}
}
