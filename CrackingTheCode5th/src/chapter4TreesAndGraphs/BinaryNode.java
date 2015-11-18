package chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryNode<T> {
	public BinaryNode<T> right;
	public BinaryNode<T> left;
	public T data;

	public BinaryNode() {

	}

	public BinaryNode(T data) {
		this.data = data;
	}

	// imagine the tree is submerged and we pull it out of the water. We
	// remember the first one out and if any branch remains in the water after 2
	// iterations than it is not balanced.
	public boolean isBalanced_waterLevelMethod() {
		int shortestDepth = -1;
		int currentDepth = 0;

		List<BinaryNode<T>> listNode = new ArrayList<BinaryNode<T>>();
		listNode.add(this); // start out;
		List<BinaryNode<T>> listWorkingNode = new ArrayList<BinaryNode<T>>();

		boolean balanced = true;

		do {
			++currentDepth;
			for (int i = 0; i < listNode.size(); ++i) {
				boolean endOfLine = true;
				if (listNode.get(i).left != null) {
					listWorkingNode.add(listNode.get(i).left);
					endOfLine = false;
				}
				if (listNode.get(i).right != null) {
					listWorkingNode.add(listNode.get(i).right);
					endOfLine = false;
				}
				if (endOfLine && shortestDepth == -1) {
					// we have a shortest branch that dead ended.
					shortestDepth = currentDepth;
				}
			}

			if (shortestDepth != -1 && currentDepth >= shortestDepth + 2) {
				balanced = false;
				break;
			}

			if (listWorkingNode.size() == 0) {
				break;// we have bottomed out.
			}

			listNode = listWorkingNode;
			listWorkingNode = new ArrayList<BinaryNode<T>>();

		} while (true);

		return balanced;
	}

	// divide and conquer recursive sorted array into balanced binary search
	// tree.
	// would look nicer if I had slices in java.
	public static void recursiveInsertIntoBST(BinaryNode<Integer> root, Integer[] sortedArray, int startIndex,
			int endIndex) {
		if (startIndex == endIndex) {
			if (root.data == null) {
				root.data = sortedArray[startIndex];
			} else {
				// we are done;
				if (sortedArray[startIndex] > root.data) {
					root.right = new BinaryNode<Integer>(sortedArray[startIndex]);
				} else {
					root.left = new BinaryNode<Integer>(sortedArray[startIndex]);
				}
			}
		} else {

			int range = endIndex - startIndex + 1;
			int middle = startIndex + range / 2;
			BinaryNode<Integer> node = new BinaryNode<Integer>(sortedArray[middle]);
			if (root.data == null) {
				root.data = node.data;
				node = root;
			} else {
				if (sortedArray[middle] > root.data) {
					root.right = node;
				} else {
					root.left = node;
				}
			}
			int rightStart = middle + 1;
			if (rightStart <= endIndex) {
				recursiveInsertIntoBST(node, sortedArray, rightStart, endIndex);
			}

			int leftEnd = middle - 1;
			recursiveInsertIntoBST(node, sortedArray, startIndex, leftEnd);
		}
	}

	public static BinaryNode<Integer> MakeBalancedTree(Integer[] sortedArray) {

		BinaryNode<Integer> rootNode = new BinaryNode<Integer>();
		recursiveInsertIntoBST(rootNode, sortedArray, 0, sortedArray.length - 1);
		// TODO Auto-generated method stub
		return rootNode;
	}

}
