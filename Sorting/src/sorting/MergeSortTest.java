package sorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class MergeSortTest {

	@Test
	public void testSort() {
		List<Integer> unsortedList = Utils.generateRandomList(1000);
		List<Integer> sortedList = new ArrayList<Integer>(unsortedList);
		// use already built sorter to test against.
		Collections.sort(sortedList);

		MergeTuple<List<Integer>, Integer> finalList = MergeSort.sort(unsortedList);
		System.out.println("Cost:" + finalList.y);
		assertEquals(sortedList, finalList.x);
	}

}
