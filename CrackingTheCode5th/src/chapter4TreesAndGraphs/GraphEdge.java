package chapter4TreesAndGraphs;

public class GraphEdge {
	private GraphNode fromNode;
	private GraphNode toNode;

	public GraphEdge(GraphNode fromNode, GraphNode toNode) {
		this.setFromNode(fromNode);
		this.setToNode(toNode);
	}

	public GraphNode getToNode() {
		return toNode;
	}

	public void setToNode(GraphNode toNode) {
		this.toNode = toNode;
	}

	public GraphNode getFromNode() {
		return fromNode;
	}

	public void setFromNode(GraphNode fromNode) {
		this.fromNode = fromNode;
	}
}
