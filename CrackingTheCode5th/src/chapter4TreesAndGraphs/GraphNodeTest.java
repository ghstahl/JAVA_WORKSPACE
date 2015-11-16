package chapter4TreesAndGraphs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphNodeTest {

	@Test
	public void test() {

		GraphNode<Integer> rootNode0 = new GraphNode<>(0);
		GraphNode<Integer> rootNode1 = new GraphNode<>(1);
		GraphNode<Integer> rootNode2 = new GraphNode<>(2);
		GraphNode<Integer> rootNode3 = new GraphNode<>(3);
		GraphNode<Integer> rootNode4 = new GraphNode<>(4);
		GraphNode<Integer> rootNode5 = new GraphNode<>(5);
		GraphNode<Integer> rootNode6 = new GraphNode<>(6);
		GraphNode<Integer> rootNode7 = new GraphNode<>(7);
		GraphNode<Integer> rootNode8 = new GraphNode<>(8);
		GraphNode<Integer> rootNode9 = new GraphNode<>(9);

		rootNode0.addEdge(rootNode1);
		rootNode0.addEdge(rootNode2);

		rootNode1.addEdge(rootNode2);
		rootNode1.addEdge(rootNode3);

		rootNode2.addEdge(rootNode3);
		rootNode2.addEdge(rootNode4);

		rootNode3.addEdge(rootNode4);
		rootNode3.addEdge(rootNode5);

		rootNode4.addEdge(rootNode5);
		rootNode4.addEdge(rootNode6);

		rootNode5.addEdge(rootNode6);
		rootNode5.addEdge(rootNode7);

		rootNode6.addEdge(rootNode7);
		rootNode6.addEdge(rootNode8);

		rootNode7.addEdge(rootNode8);
		rootNode7.addEdge(rootNode9);

		rootNode8.addEdge(rootNode9);

		assertTrue(GraphNode.isPath(rootNode0, rootNode9));
		assertTrue(GraphNode.isPathIterative(rootNode0, rootNode9));
	}

}
