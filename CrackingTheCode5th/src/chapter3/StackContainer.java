package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackContainer<T> {
	public List<Stack<T>> stackList;

	public StackContainer(int count) {
		stackList = new ArrayList<Stack<T>>(count);
		for (int i = 0; i < count; ++i) {
			stackList.add(new Stack<T>());
		}
	}
}
