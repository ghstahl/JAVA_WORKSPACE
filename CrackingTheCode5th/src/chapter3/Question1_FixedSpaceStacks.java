package chapter3;

import java.util.ArrayList;
import java.util.List;

/*
 * Describe how you could use a single array to implement three stacks
 * 
 * Solution: Make a stack that can work on a shared array.  
 * So n number of stacks all would be configured using the same array and simply needs to do some index management.
 */
public class Question1_FixedSpaceStacks<T> {

	public Question1_FixedSpaceStacks(int numberOfStacks, int sizePerStack) {

		Integer[] backingArray = new Integer[numberOfStacks * sizePerStack];
		int baseIndex = 0;
		int upperBoundaryIndex = sizePerStack - 1;
		List<ArrayBackedStack<Integer>> stacks = new ArrayList<ArrayBackedStack<Integer>>();
		for (int i = 0; i < numberOfStacks; ++i) {
			ArrayBackedStack<Integer> abs = new ArrayBackedStack<>(backingArray, baseIndex, upperBoundaryIndex);
			stacks.add(abs);
			baseIndex = upperBoundaryIndex + 1;
			upperBoundaryIndex = baseIndex + sizePerStack - 1;
		}

	}

}
