package chapter4TreesAndGraphs;

import java.util.Stack;
import java.util.Vector;

public class GraphNode<T> {
	private T data;

	public GraphNode(T data) {
		setData(data);
	}

	public GraphNode() {

	}

	private static int marker;

	public static void setVisitedMarker(int marker) {
		GraphNode.marker = marker;
	}

	private int visitedMarker;

	public void setVisited() {
		visitedMarker = marker;
	}

	public boolean isVisited() {
		return visitedMarker == marker;
	}

	Vector<GraphEdge> toEdges = new Vector<GraphEdge>();

	Vector<GraphEdge> fromEdges = new Vector<GraphEdge>();

	public Vector<GraphEdge> getFromEdges() {
		return fromEdges;
	}

	public Vector<GraphEdge> getToEdges() {
		return toEdges;
	}

	public void addEdge(GraphNode toNode) {

		GraphEdge toEdge = new GraphEdge(this, toNode);
		GraphEdge fromEdge = new GraphEdge(toNode, this);

		toEdges.add(toEdge);
		fromEdges.add(fromEdge);

		toNode.getFromEdges().add(toEdge);
		toNode.getToEdges().add(fromEdge);

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static boolean isPath(GraphNode start, GraphNode destination) {
		GraphNode.setVisitedMarker(1234);
		boolean result = DFS_recursiveFind(start, destination);
		return result;
	}

	public static boolean isPathIterative(GraphNode start, GraphNode destination) {

		boolean result = DFS_iterativeFind(start, destination);
		return result;
	}

	private static boolean DFS_recursiveFind(GraphNode current, GraphNode destination) {
		if (!current.isVisited()) {
			current.setVisited();

			if (current == destination) {
				return true;
			}
			for (int i = 0; i < current.getToEdges().size(); ++i) {
				GraphEdge edge = (GraphEdge) current.getToEdges().get(i);
				boolean result = DFS_recursiveFind(edge.getToNode(), destination);
				if (result) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean DFS_iterativeFind(GraphNode start, GraphNode destination) {
		GraphNode.setVisitedMarker(2345);
		Stack st = new Stack();

		st.push(start);
		boolean found = false;
		while (!st.isEmpty()) {
			GraphNode current = (GraphNode) st.pop();
			if (!current.isVisited()) {
				current.setVisited();
				if (current == destination) {
					found = true;
					break;
				}
				for (int i = 0; i < current.getToEdges().size(); ++i) {
					GraphEdge ge = (GraphEdge) current.getToEdges().get(i);
					st.push(ge.getToNode());
				}
			}
		}
		return found;
	}
}
