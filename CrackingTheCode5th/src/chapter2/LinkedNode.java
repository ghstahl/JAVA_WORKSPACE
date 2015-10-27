package chapter2;

public class LinkedNode<T> {
	// T stands for "Type"
	private T t;

	public LinkedNode(T t) {
		set(t);
	}

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public void append(LinkedNode<T> node) {

		node.Prev = this;
		if (Next != null) {
			node.Next = Next;
			// might be at the end.
			node.Next.Prev = node;
		}
		this.Next = node;
	}

	public void prepend(LinkedNode<T> node) {

		node.Next = this;
		if (Prev != null) {
			// might be the very front
			node.Prev = this.Prev;
			node.Prev.Next = node;
		}
		this.Prev = node;
	}

	public void delete() {

		if (Next != null) {
			this.Next.Prev = this.Prev;
		}
		if (Prev != null) {
			this.Prev.Next = this.Next;
		}
	}

	public LinkedNode<T> Next;
	public LinkedNode<T> Prev;

}
