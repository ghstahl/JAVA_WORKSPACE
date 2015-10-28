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

	public LinkedNode<T> clone() {
		LinkedNode aClone = new LinkedNode<T>(get());// not really a clone if
														// get
														// is an object
		aClone.Next = Next;
		aClone.Prev = Prev;
		return aClone;
	}

	public static void swap(LinkedNode a, LinkedNode b) {
		LinkedNode bTemp = b.clone();

		b.Next = a.Next;
		b.Prev = a.Prev;

		if (b.Prev != null) {
			b.Prev.Next = b;
		}
		if (b.Next != null) {
			b.Next.Prev = b;
		}

		a.Next = bTemp.Next;
		a.Prev = bTemp.Prev;

		if (a.Prev != null) {
			a.Prev.Next = a;
		}
		if (a.Next != null) {
			a.Next.Prev = a;
		}

	}

	public LinkedNode<T> extract() {
		LinkedNode<T> prev = Prev;
		LinkedNode<T> next = Next;

		if (prev != null) {
			prev.Next = next;
		}

		if (next != null) {
			next.Prev = prev;
		}

		Next = null;
		Prev = null;
		return this;
	}

	public LinkedNode<T> head() {
		LinkedNode<T> current = this;
		while (true) {
			if (current.Prev == null)
				return current;
			current = current.Prev;
		}
	}

	public LinkedNode<T> tail() {
		LinkedNode<T> current = this;
		while (true) {
			if (current.Next == null)
				return current;
			current = current.Next;
		}
	}

	public int count() {
		int nCount = 0;
		LinkedNode<T> current = this;
		while (current != null) {
			++nCount;
			current = current.Next;
		}
		return nCount;
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

	public void phanthomDelete() {
		// a back pointer is not allowed.
		// so if I have to delete me, then in reality I have to become the node
		// next to me and delete that node.

		this.set(Next.get());
		this.Next = this.Next.Next;
		this.Next.Prev = this;// not allowed for this, but I can't not fix this
								// back pointer

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
	public LinkedNode<T> delete() {

		if (Next != null) {
			this.Next.Prev = this.Prev;
		}
		if (Prev != null) {
			this.Prev.Next = this.Next;
		}
		this.Next = null;
		this.Prev = null;
		return this;
	}

	public LinkedNode<T> Next;
	public LinkedNode<T> Prev;

}
