package chapter3;

/*
 * Describe how you could use a single array to implement three stacks
 */
// only wrapped objects.
public class ArrayBackedStack<T> {
	private T[] backingArray;
	private int baseIndex;
	private int upperIndex;
	private int currentIndex;

	public ArrayBackedStack(T[] backingArray, int baseIndex, int upperIndex) {
		this.backingArray = backingArray;
		this.baseIndex = baseIndex;
		this.upperIndex = upperIndex;
		this.currentIndex = baseIndex - 1;
	}

	public void push(T item) {
		if (currentIndex >= upperIndex) {
			throw new ArrayIndexOutOfBoundsException("upper bound exception");
		}
		++currentIndex;
		backingArray[currentIndex] = item;
	}

	public T pop() {
		if (currentIndex < baseIndex) {
			throw new ArrayIndexOutOfBoundsException("lower bound exception");
		}
		T current = backingArray[currentIndex];// store temp
		backingArray[currentIndex] = null;// set to null in array to handle
											// reference counts correctly.
		--currentIndex;
		return current;
	}

	public T peek() {
		if (currentIndex < baseIndex) {
			throw new ArrayIndexOutOfBoundsException("lower bound exception");
		}
		T current = backingArray[currentIndex];
		return current;
	}

	public boolean empty() {
		return currentIndex < baseIndex;
	}
}
