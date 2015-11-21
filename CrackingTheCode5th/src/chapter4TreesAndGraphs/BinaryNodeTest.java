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

	// 4.1 Implement a function to check if a binary tree is balanced. For the
	// purposes of this question, a balanced tree is defined to be a tree such
	// that the heights of the two subtrees of any node never differ by more
	// than one.
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
		balanced = rootNode.isBalanced_Recursive1();
		assertFalse(balanced);
		balanced = rootNode.isBalanced_Recursive2();
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
		balanced = rootNode.isBalanced_Recursive1();
		assertFalse(balanced);
		balanced = rootNode.isBalanced_Recursive2();
		assertFalse(balanced);
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

	// 4.6 Write an algorithm to find the'next'node (i.e., in-order successor)
	// of a given node in a binary search tree. You may assume that each node
	// has a link to its parent.
	@Test
	public void test_Make_Balanced_Tree_and_Find_Next_In_Order_Successor_1() {

		class EventSubscriber implements ISubscriber<BinaryNode<Integer>> {
			public BinaryNode<Integer> node;

			@Override
			public void onEvent(BinaryNode<Integer> object) {
				// TODO Auto-generated method stub
				node = object;
				node.StopTraversal();
			}
		}

		int depth = 5;
		EventSubscriber es = new EventSubscriber();
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(depth, false);
		rootNode.RegisterSubscriber(es);
		rootNode.DoInOrderRootUpDownTraversal();
		assertTrue(es.node.data == 15);
	}

	// 4.6 Write an algorithm to find the'next'node (i.e., in-order successor)
	// of a given node in a binary search tree. You may assume that each node
	// has a link to its parent.
	@Test
	public void test_Make_Balanced_Tree_and_Find_Next_In_Order_Successor_2() {

		class EventSubscriber implements ISubscriber<BinaryNode<Integer>> {
			public BinaryNode<Integer> node;

			@Override
			public void onEvent(BinaryNode<Integer> object) {
				// TODO Auto-generated method stub
				node = object;
				node.StopTraversal();
			}
		}

		class EventSubscriber2 implements ISubscriber<BinaryNode<Integer>> {
			int nCount;
			public BinaryNode<Integer> node;

			@Override
			public void onEvent(BinaryNode<Integer> object) {
				// TODO Auto-generated method stub
				node = object;
				++nCount;
				if (nCount == 2) {
					node.StopTraversal();
				}
			}
		}

		int depth = 5;
		EventSubscriber es = new EventSubscriber();
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(depth, false);
		rootNode.RegisterSubscriber(es);
		rootNode.DoInOrderRootUpDownTraversal();
		assertTrue(es.node.data == 15);

		EventSubscriber2 es2 = new EventSubscriber2();
		es.node.RegisterSubscriber(es2);
		es.node.DoInOrderRootUpDownTraversal();
		assertTrue(es2.node.data == 7);
	}

	// 4.7 Design an algorithm and write code to find the first common ancestor
	// of two nodes in a binary tree. Avoid storing additional nodes in a data
	// structure. NOTE: This is not necessarily a binary search tree.
	@Test
	public void test_Make_Balanced_Tree_and_Find_Next_First_Common_Ancestor_RootNode() {
		int depth = 5;
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(depth, false);
		BinaryNode<Integer> nodeOne, nodeTwo, commonNode;
		nodeOne = rootNode;
		nodeTwo = rootNode;
		while (nodeOne.getLeft() != null) {
			nodeOne = nodeOne.getLeft();
		}
		while (nodeTwo.getRight() != null) {
			nodeTwo = nodeTwo.getRight();
		}
		commonNode = rootNode.FindCommonAncestor(nodeOne, nodeTwo);

		assertEquals(rootNode.data, commonNode.data);
	}

	// 4.7 Design an algorithm and write code to find the first common ancestor
	// of two nodes in a binary tree. Avoid storing additional nodes in a data
	// structure. NOTE: This is not necessarily a binary search tree.
	@Test
	public void test_Make_Balanced_Tree_and_Find_Next_First_Common_Ancestor_DeepNode() {
		int depth = 5;
		BinaryNode<Integer> rootNode = makeLargeBalancedTree(depth, false);
		BinaryNode<Integer> nodeOne, nodeTwo, commonNode, actualNode;
		nodeOne = rootNode;
		nodeTwo = rootNode;
		while (nodeOne.getLeft() != null) {
			nodeOne = nodeOne.getLeft();
		}
		nodeTwo = nodeOne.getParent().getRight();
		actualNode = nodeOne.getParent();

		commonNode = rootNode.FindCommonAncestor(nodeOne, nodeTwo);

		assertEquals(actualNode.data, commonNode.data);
	}
}
