package chapter2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import utils.Utils;

public class Question4Test {

	@Test
	public void testPartitionAround() {

		LinkedNode node0 = new LinkedNode<Integer>(0);

		for (int i = 0; i < 100; ++i) {
			int value = Utils.randInt(0, 100);
			node0.append(new LinkedNode<Integer>(value));
		}

		LinkedNode nodeH = node0.advance(50); // partition point.

		Question4.partitionAround(nodeH);

		LinkedNode nodeL = nodeH.Prev;
		while (nodeL != null) {
			assertTrue((Integer) nodeL.get() < (Integer) nodeH.get());
			nodeL = nodeL.Prev;
		}
		LinkedNode nodeG = nodeH.Next;
		while (nodeG != null) {
			assertTrue((Integer) nodeG.get() >= (Integer) nodeG.get());
			nodeG = nodeG.Next;
		}
		fail("Not yet implemented");
	}

}
