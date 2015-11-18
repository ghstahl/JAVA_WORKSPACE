package chapter4TreesAndGraphs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class BinaryNodeTest {
	BinaryNode<Integer> makeLargeBalancedTree(int depth) {
		BinaryNode<Integer> rootNode = new BinaryNode<>(Utils.randInt(0, 1000));
		List<BinaryNode<Integer>> listNode = new ArrayList<BinaryNode<Integer>>();
		listNode.add(rootNode); // start out;
		List<BinaryNode<Integer>> listWorkingNode = new ArrayList<BinaryNode<Integer>>();
		for (int i = 1; i < depth; ++i) {
			for (int j = 0; j < listNode.size(); ++j) {
				listNode.get(j).left = new BinaryNode<Integer>(Utils.randInt(0, 1000));
				listNode.get(j).right = new BinaryNode<Integer>(Utils.randInt(0, 1000));
				listWorkingNode.add(listNode.get(j).left);
				listWorkingNode.add(listNode.get(j).right);
			}
			listNode = listWorkingNode;
			listWorkingNode = new ArrayList<BinaryNode<Integer>>();
		}
		return rootNode;
	}

	@Test
	public void testIsBalanced_Not() {
		BinaryNode<Integer> rootNode = new BinaryNode<>();
		BinaryNode<Integer> currentNode = rootNode;
		// go down left
		for (Integer i = 0; i < 5; ++i) {
			currentNode.left = new BinaryNode<>(i);
			currentNode = currentNode.left;
		}
		// go down right
		currentNode = rootNode;
		for (Integer i = 0; i < 7; ++i) {
			currentNode.right = new BinaryNode<>(i);
			currentNode = currentNode.right;
		}

		// not balanced
		boolean balanced = rootNode.isBalanced_waterLevelMethod();
		assertFalse(balanced);
	}

	@Test
	public void testIsBalanced_Yes() {
		BinaryNode<Integer> rootNode = new BinaryNode<>();
		BinaryNode<Integer> currentNode = rootNode;
		// go down left
		for (Integer i = 0; i < 6; ++i) {
			currentNode.left = new BinaryNode<>(i);
			currentNode = currentNode.left;
		}
		// go down right
		currentNode = rootNode;
		for (Integer i = 0; i < 7; ++i) {
			currentNode.right = new BinaryNode<>(i);
			currentNode = currentNode.right;
		}

		// not balanced
		boolean balanced = rootNode.isBalanced_waterLevelMethod();
		assertTrue(balanced);
	}

	@Test
	public void testIsBalanced_YesLarge() {
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(20);
		// not balanced
		boolean balanced = rootNode.isBalanced_waterLevelMethod();
		assertTrue(balanced);
	}

	@Test
	public void test_Make_Balanced_BST_from_Sorted_Integer_Array() {
		Integer[] sortedArray = new Integer[100];
		for (int i = 0; i < sortedArray.length; ++i) {
			sortedArray[i] = i;
		}

		BinaryNode<Integer> rootNode = BinaryNode.MakeBalancedBST(sortedArray);
		// not balanced
		boolean balanced = rootNode.isBalanced_waterLevelMethod();
		assertTrue(balanced);
	}

	// 4.5 Implement a function to check if a binary tree is a binary search
	// tree.
	@Test
	public void test_Make_Balanced_BST_from_Sorted_Integer_Array_And_verify_that_it_is_a_BST() {
		Integer[] sortedArray = new Integer[100];
		for (int i = 0; i < sortedArray.length; ++i) {
			sortedArray[i] = i;
		}

		BinaryNode<Integer> rootNode = BinaryNode.MakeBalancedBST(sortedArray);
		// not balanced
		boolean balanced = rootNode.isBalanced_waterLevelMethod();
		assertTrue(balanced);

		boolean isBST = rootNode.isBinarySearchTree();
		assertTrue(isBST);
	}

	// 4.5 Implement a function to check if a binary tree is a binary search
	// tree.
	@Test
	public void test_Make_Large_Balanced_Tree_and_verify_that_it_is_NOT_a_BST() {
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(20);
		boolean isBST = rootNode.isBinarySearchTree();
		assertFalse(isBST);
	}
}
