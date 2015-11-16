package chapter4TreesAndGraphs;

public class BinaryNodeWrapper<T> {
	public BinaryNode<T> node;
	public int depth;

	public BinaryNodeWrapper() {

	}

	public BinaryNodeWrapper(BinaryNode<T> node) {
		this.node = node;
	}

	public BinaryNodeWrapper(BinaryNode<T> node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}
