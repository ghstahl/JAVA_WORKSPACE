package chapter3;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class Question3_TowerOfHanoiTest {

	@Test
	public void testSolve() {
		StackContainer container = new StackContainer<>(3);
		StackContainer containerExpected = new StackContainer<>(3);
		Stack one = (Stack) container.stackList.get(0);
		Stack three = (Stack) containerExpected.stackList.get(2);
		for (int i = 5; i > 0; --i) {
			one.push(i);
			three.push(i);
		}
		Question3_TowerOfHanoi.solve(5, container);
		for (int i = 0; i < 3; ++i) {
			assertEquals(container.stackList.get(i), containerExpected.stackList.get(i));
		}
	}

}
