package chapter3;

import java.util.Stack;

/*
 * 

In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (i.e., each disk sits on top of an
even larger one). You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next tower.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using stacks.


This is ultimately a very simply problem of just 2 disks.

If you have a stack of N disks, say 5, then lets simply glue the top four together.
so now its back to 2 disks.
1 large round and thin at the bottom, and 2 very thick and less round at the top.

we more the top one to the center, move the bottom one to the end, and then finally more the thick one to the end.



 */
public class Question3_TowerOfHanoi {
	private StackContainer _container;
	private int _count;

	public Question3_TowerOfHanoi(int count, StackContainer container) {
		_container = container;
		_count = count;
	}

	private void move(int disks, Stack A, Stack B, Stack C) {
		if (disks > 1) {
			// this is our thick one we move to B
			move(disks - 1, A, C, B);

			// this is our 1 thin one we move to C, and is in the final position
			int disk = (int) A.pop();
			C.push(disk);

			// this again is our thick one we finally move over to C
			move(disks - 1, B, A, C);
		}
	}

	private void solve() {
		// TODO Auto-generated method stub
		Stack stackA = (Stack) _container.stackList.get(0);
		Stack stackB = (Stack) _container.stackList.get(1);
		Stack stackC = (Stack) _container.stackList.get(2);

		move(_count, stackA, stackB, stackC);
	}

	public static void solve(int count, StackContainer container) {
		Question3_TowerOfHanoi toh = new Question3_TowerOfHanoi(count, container);
		toh.solve();
	}
}
