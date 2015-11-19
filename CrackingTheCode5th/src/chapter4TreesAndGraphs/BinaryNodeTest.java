package chapter4TreesAndGraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class BinaryNodeTest {
	Integer nextValue(Integer data, boolean doRandomData) {
		data = (doRandomData ? Utils.randInt(0, 1000) : ++data);
		return data;
	}

	BinaryNode<Integer> makeLargeBalancedTree(int depth, boolean doRandomData) {
		Integer data = -1;

		BinaryNode<Integer> rootNode = new BinaryNode<>(data = nextValue(data, doRandomData));
		List<BinaryNode<Integer>> listNode = new ArrayList<BinaryNode<Integer>>();
		listNode.add(rootNode); // start out;
		List<BinaryNode<Integer>> listWorkingNode = new ArrayList<BinaryNode<Integer>>();
		for (int i = 1; i < depth; ++i) {
			for (int j = 0; j < listNode.size(); ++j) {
				listNode.get(j).setLeft(new BinaryNode<Integer>(data = nextValue(data, doRandomData)));
				listNode.get(j).setRight(new BinaryNode<Integer>(data = nextValue(data, doRandomData)));
				listWorkingNode.add(listNode.get(j).getLeft());
				listWorkingNode.add(listNode.get(j).getRight());
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
			currentNode.setLeft(new BinaryNode<>(i));
			currentNode = currentNode.getLeft();
		}
		// go down right
		currentNode = rootNode;
		for (Integer i = 0; i < 7; ++i) {
			currentNode.setRight(new BinaryNode<>(i));
			currentNode = currentNode.getRight();
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
			currentNode.setLeft(new BinaryNode<>(i));
			currentNode = currentNode.getLeft();
		}
		// go down right
		currentNode = rootNode;
		for (Integer i = 0; i < 7; ++i) {
			currentNode.setRight(new BinaryNode<>(i));
			currentNode = currentNode.getRight();
		}

		// not balanced
		boolean balanced = rootNode.isBalanced_waterLevelMethod();
		assertTrue(balanced);
	}

	@Test
	public void testIsBalanced_YesLarge() {
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(20, true);
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
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(20, false);
		boolean isBST = rootNode.isBinarySearchTree();
		assertFalse(isBST);
	}

	// 4.4 Given a binary tree, design an algorithm which creates a linked list
	// of all the nodes at each depth (e.g., if you have a tree with depth D,
	// you'll have D linked lists).
	@Test
	public void test_Make_Balanced_Tree_and_Turn_It_into_depth_list() {
		int depth = 5;
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(depth, false);
		List<List<BinaryNode<Integer>>> depthList = rootNode.MakeDepthList();

		assertEquals(depthList.size(), depth);
		int runningCount = 1;
		for (int i = 0; i < depthList.size(); ++i, runningCount *= 2) {
			assertEquals(depthList.get(i).size(), runningCount);
		}
	}
}
