package chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.Utils;

public class BinaryNode<T> extends EventRegistration<BinaryNode<T>> {
	private BinaryNode<T> parent;
	private BinaryNode<T> right;
	private BinaryNode<T> left;
	public T data;
	private int visited;
	private static int visitedMarker;

	public static void setVisitedMarker(int visitedMarker) {
		BinaryNode.visitedMarker = visitedMarker;
	}

	public void setVisited() {
		this.visited = BinaryNode.visitedMarker;
	}

	public boolean isVisited() {
		return this.visited == BinaryNode.visitedMarker;
	}

	public BinaryNode() {

	}

	public BinaryNode(T data) {
		this.data = data;
	}

	private static boolean isStopTraversal;

	public static void StopTraversal() {
		isStopTraversal = true;
	}

	// 4.7 Design an algorithm and write code to find the first common ancestor
	// of two nodes in a binary tree. Avoid storing additional nodes in a data
	// structure. NOTE: This is not necessarily a binary search tree.
	public BinaryNode<T> FindCommonAncestor(BinaryNode<T> nodeOne, BinaryNode<T> nodeTwo) {
		BinaryNode.setVisitedMarker(Utils.randInt(0, 1000000));
		BinaryNode<T> current = nodeOne;
		while (current != null) {
			current.setVisited();
			current = current.getParent();
		}
		BinaryNode<T> rootNode = null;
		current = nodeTwo;
		while (current != null) {
			current.setVisited();
			rootNode = current;
			current = current.getParent();
		}

		do {
			boolean diverge = rootNode.getLeft().isVisited() && rootNode.getRight().isVisited();
			if (diverge) {
				break;
			}
			if (rootNode.getLeft().isVisited()) {
				rootNode = rootNode.getLeft();
			} else {
				rootNode = rootNode.getRight();
			}
		} while (true);

		return rootNode;

	}

	// 4.6 Write an algorithm to find the'next'node (i.e., in-order successor)
	// of a given node in a binary search tree. You may assume that each node
	// has a link to its parent.

	// Left,Root,Right
	//
	public void DoInOrderRootDownTraversal() {
		BinaryNode.setVisitedMarker(Utils.randInt(0, 1000000));
		isStopTraversal = false;
		RecursiveInOrderRootDownTraversal(this, this);
	}

	// Left,Root,Right
	//
	public void DoInOrderRootUpDownTraversal() {
		BinaryNode.setVisitedMarker(Utils.randInt(0, 1000000));
		isStopTraversal = false;
		RecursiveInOrderUpDownTraversal(this, this);
	}

	public void RecursiveInOrderUpDownTraversal(BinaryNode<T> node,
			IEventRegistration<BinaryNode<T>> eventRegistration) {
		if (node == null || isStopTraversal) {
			return;
		}
		RecursiveInOrderRootDownTraversal(node, eventRegistration);
		RecursiveInOrderUpDownTraversal(node.getParent(), eventRegistration);

	}

	public void RecursiveInOrderRootDownTraversal(BinaryNode<T> node,
			IEventRegistration<BinaryNode<T>> eventRegistration) {
		if (node == null || isStopTraversal) {
			return;
		}
		if (node.isVisited()) {
			return;
		}
		RecursiveInOrderRootDownTraversal(node.getLeft(), eventRegistration);
		if (isStopTraversal) {
			return;
		}
		eventRegistration.FireEvent(node);
		node.setVisited();
		RecursiveInOrderRootDownTraversal(node.getRight(), eventRegistration);
	}

	// 4.5 Implement a function to check if a binary tree is a binary search
	// tree.
	// BFS to see if a binary tree is a BST.
	// using 2 stacks.
	public <T extends Comparable<T>> boolean isBinarySearchTree() {
		Stack bstStackA = new Stack();
		Stack bstStackB = new Stack();
		bstStackA.push(this);
		while (!bstStackA.isEmpty()) {
			BinaryNode<T> node = (BinaryNode<T>) bstStackA.pop();
			if (node.left != null) {
				if (node.left.data.compareTo(node.data) > 0) {
					return false;
				}
				bstStackB.push(node.left);
			}
			if (node.right != null) {
				if (node.right.data.compareTo(node.data) < 0) {
					return false;
				}
				bstStackB.push(node.right);
			}
			if (bstStackA.isEmpty()) {
				bstStackA = bstStackB;
				bstStackB = new Stack();
			}
		}
		return true;
	}

	// 4.1 Implement a function to check if a binary tree is balanced. For the
	// purposes of this question, a balanced tree is defined to be a tree such
	// that the heights of the two subtrees of any node never differ by more
	// than one.

	// O(N^2), for every node we do a get height recursive down.
	public boolean isBalanced_Recursive2() {
		int lHeight = getHeight2(this.getLeft());
		if (lHeight == -1)
			return false;
		int rHeight = getHeight2(this.getLeft());
		if (rHeight == -1)
			return false;
		int diff = Math.abs(lHeight - rHeight);
		if (diff > 1)
			return false;
		return true;
	}

	private int getHeight2(BinaryNode<T> node) {
		if (node == null)
			return 0;
		int lHeight = getHeight(node.getLeft());
		if (lHeight == -1)
			return -1;
		int rHeight = getHeight(node.getRight());
		if (rHeight == -1)
			return -1;
		int diff = Math.abs(lHeight - rHeight);
		if (diff > 1)
			return -1;

		int height = 1 + lHeight + rHeight;
		return height;
	}

	// 4.1 Implement a function to check if a binary tree is balanced. For the
	// purposes of this question, a balanced tree is defined to be a tree such
	// that the heights of the two subtrees of any node never differ by more
	// than one.

	// O(N^2), for every node we do a get height recursive down.
	public boolean isBalanced_Recursive1() {
		int lHeight = getHeight(this.getLeft());
		int rHeight = getHeight(this.getLeft());
		int diff = Math.abs(lHeight - rHeight);
		if (diff > 1)
			return false;

		boolean balanced = false;
		if (this.getLeft() != null)
			balanced = this.getLeft().isBalanced_Recursive1();
		if (!balanced)
			return balanced;
		if (this.getRight() != null)
			balanced = this.getRight().isBalanced_Recursive1();
		return balanced;
	}

	private int getHeight(BinaryNode<T> node) {
		if (node == null)
			return 0;
		int height = 1 + getHeight(node.getLeft()) + getHeight(node.getRight());
		return height;
	}

	// 4.1 Implement a function to check if a binary tree is balanced. For the
	// purposes of this question, a balanced tree is defined to be a tree such
	// that the heights of the two subtrees of any node never differ by more
	// than one.
	// imagine the tree is submerged and we pull it out of the water. We
	// remember the first one out and if any branch remains in the water after 2
	// iterations than it is not balanced.
	// Breadth Traversal where the breadth grows and if it shrinks we go one
	// more level down to see if it dead ends.
	// O(N)every node gets visited just once.
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

	// 4.3 Given a sorted (increasing order) array with unique integer elements,
	// write an algorithm to create a binary search tree with minimal height.
	public static BinaryNode<Integer> MakeBalancedBST(Integer[] sortedArray) {

		BinaryNode<Integer> rootNode = new BinaryNode<Integer>();
		recursiveInsertIntoBST(rootNode, sortedArray, 0, sortedArray.length - 1);
		// TODO Auto-generated method stub
		return rootNode;
	}

	// 4.4 Given a binary tree, design an algorithm which creates a linked list
	// of all the nodes at each depth (e.g., if you have a tree with depth D,
	// you'll have D linked lists).
	public List<List<BinaryNode<T>>> MakeDepthList() {

		List<List<BinaryNode<T>>> llBN = new ArrayList<List<BinaryNode<T>>>();

		List<BinaryNode<T>> lA = new ArrayList<BinaryNode<T>>();
		Queue stA = new LinkedList<BinaryNode<T>>();
		Queue stB = new LinkedList<BinaryNode<T>>();

		stA.add(this);
		while (!stA.isEmpty()) {

			BinaryNode<T> node = (BinaryNode<T>) stA.remove();
			lA.add(node);
			if (node.left != null) {
				stB.add(node.left);
			}
			if (node.right != null) {
				stB.add(node.right);
			}
			if (stA.isEmpty()) {
				stA = stB;
				stB = new LinkedList<BinaryNode<T>>();
				llBN.add(lA);
				lA = new ArrayList<BinaryNode<T>>();
			}
		}
		return llBN;
	}

	public BinaryNode<T> getParent() {
		return parent;
	}

	public void setParent(BinaryNode<T> node) {
		this.parent = node;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> node) {
		node.parent = this;
		this.left = node;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> node) {
		node.parent = this;
		this.right = node;
	}
}
