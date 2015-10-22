package sorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class HeapNodeTest {

	@Test
	public void testHeap() {

		List<Integer> sourceList = Utils.makeList(10, 5, 12, 3, 7, 45, 33, 11, 2);
		HeapNode minHeapNode = new HeapNode(false);
		HeapNode maxHeapNode = new HeapNode(true);
		for (Integer n : sourceList) {
			minHeapNode.Insert(n);
			maxHeapNode.Insert(n);
		}

		List<Integer> testMinList = Utils.makeList(-1, 2, 3, 12, 5, 7, 45, 33, 11, 10);
		assertEquals(minHeapNode.HeapArray, testMinList);

		List<Integer> testMaxList = Utils.makeList(-1, 45, 11, 33, 7, 5, 10, 12, 3, 2);
		assertEquals(maxHeapNode.HeapArray, testMaxList);
	}

	@Test
	public void testMinSort() {

		List<Integer> unsortedList = Utils.generateRandomList(1000);
		List<Integer> sortedList = new ArrayList<Integer>(unsortedList);
		// use already built sorter to test against.
		Collections.sort(sortedList);

		HeapNode minHeapNode = new HeapNode(false);
		for (Integer n : unsortedList) {
			minHeapNode.Insert(n);
		}

		List<Integer> finalList = minHeapNode.Sort();
		assertEquals(sortedList, finalList);
	}

}
