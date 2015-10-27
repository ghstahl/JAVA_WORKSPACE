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

	// 1 time run
	public T get() {
		return t;
	}

	// O(N) time run
	public LinkedNode<T> last() {
		LinkedNode<T> current = this;
		while (current.Next != null) {
			current = current.Next;
		}
		return current;
	}

	// O(N) time run
	public LinkedNode<T> advance(int count) {
		LinkedNode<T> current = this;
		while (current.Next != null && count > 0) {
			current = current.Next;
			--count;
		}
		if (count > 0)
			return null;// out of bounds

		return current;
	}

	// O(N) time run
	public LinkedNode<T> retreat(int count) {
		LinkedNode<T> current = this;
		while (current.Prev != null && count > 0) {
			current = current.Prev;
			--count;
		}
		if (count > 0)
			return null;// out of bounds
		return current;
	}

	// 1 time run
	public void append(LinkedNode<T> node) {

		node.Prev = this;
		if (Next != null) {
			node.Next = Next;
			// might be at the end.
			node.Next.Prev = node;
		}
		this.Next = node;
	}

	// 1 time run
	public void prepend(LinkedNode<T> node) {

		node.Next = this;
		if (Prev != null) {
			// might be the very front
			node.Prev = this.Prev;
			node.Prev.Next = node;
		}
		this.Prev = node;
	}

	// 1 time run
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
