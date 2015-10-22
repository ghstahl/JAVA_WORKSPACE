package sorting;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import utils.Utils;

public class HeapNodeTest {

	@Test
	public void test() {

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

}
