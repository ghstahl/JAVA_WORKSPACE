package recursion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindAllPathsThroughGridTest {

	@Test
	public void test() {

		int board[][] = new int[8][8];

		List<List<Cordinates>> expected = new ArrayList<List<Cordinates>>();
		List<Cordinates> path1 = new ArrayList<Cordinates>();
		path1.add(new Cordinates(0, 0));
		path1.add(new Cordinates(1, 0));

		path1.add(new Cordinates(1, 1));
		path1.add(new Cordinates(2, 1));

		path1.add(new Cordinates(2, 2));
		path1.add(new Cordinates(3, 2));

		path1.add(new Cordinates(3, 3));
		path1.add(new Cordinates(4, 3));

		path1.add(new Cordinates(4, 4));
		path1.add(new Cordinates(5, 4));

		path1.add(new Cordinates(5, 5));
		path1.add(new Cordinates(6, 5));

		path1.add(new Cordinates(6, 6));
		path1.add(new Cordinates(7, 6));

		path1.add(new Cordinates(7, 7));
		path1.add(new Cordinates(7, 7));
		expected.add(path1);

		List<Cordinates> path2 = new ArrayList<Cordinates>();
		path2.add(new Cordinates(0, 0));
		path2.add(new Cordinates(1, 0));

		path2.add(new Cordinates(1, 1));
		path2.add(new Cordinates(2, 1));

		path2.add(new Cordinates(2, 2));
		path2.add(new Cordinates(3, 2));

		path2.add(new Cordinates(3, 3));
		path2.add(new Cordinates(4, 3));

		path2.add(new Cordinates(4, 4));
		path2.add(new Cordinates(3, 4));

		path2.add(new Cordinates(3, 5));
		path2.add(new Cordinates(2, 5));

		path2.add(new Cordinates(2, 6));
		path2.add(new Cordinates(1, 6));

		path2.add(new Cordinates(1, 7));
		path2.add(new Cordinates(0, 7));
		expected.add(path2);

		for (int i = 0; i < expected.size(); ++i) {
			for (Cordinates cord : expected.get(i)) {
				board[cord.x][cord.y] = 1;
			}
		}

		List<List<Cordinates>> actual = FindAllPathsThroughGrid.findPathsFromTopToBottom(board);
		assertEquals(actual.size(), expected.size());
		for (int i = 0; i < expected.size(); ++i) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}

}
