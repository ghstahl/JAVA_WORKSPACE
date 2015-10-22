package sorting;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import utils.Utils;

public class HeapNodeTest {

	@Test
	public void test() {

		List<Integer> sourceList = Utils.makeList(10, 5, 12, 3, 7, 45, 33, 11, 2);
		HeapNode heapNode = new HeapNode(false);
		for (Integer n : sourceList) {
			heapNode.Insert(n);
		}

		List<Integer> testList = Utils.makeList(-1, 2, 3, 12, 5, 7, 45, 33, 11, 10);
		assertEquals(heapNode.HeapArray, testList);

	}

}
