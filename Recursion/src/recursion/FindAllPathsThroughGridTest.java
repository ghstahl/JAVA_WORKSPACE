package recursion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindAllPathsThroughGridTest {

	@Test
	public void testDownAndRight() {

		int board[][] = new int[8][8];

		List<List<Cordinates>> expected = new ArrayList<List<Cordinates>>();
		List<Cordinates> path = new ArrayList<Cordinates>();
		path.add(new Cordinates(1, 0));
		path.add(new Cordinates(1, 1));
		path.add(new Cordinates(2, 1));
		path.add(new Cordinates(2, 2));
		path.add(new Cordinates(3, 2));
		path.add(new Cordinates(3, 3));
		path.add(new Cordinates(4, 3));
		path.add(new Cordinates(5, 3));
		path.add(new Cordinates(6, 3));
		path.add(new Cordinates(7, 3));
		path.add(new Cordinates(7, 4));
		path.add(new Cordinates(7, 5));
		path.add(new Cordinates(7, 6));
		path.add(new Cordinates(7, 7));
		expected.add(path);

		path = new ArrayList<Cordinates>();
		path.add(new Cordinates(1, 0));
		path.add(new Cordinates(1, 1));
		path.add(new Cordinates(2, 1));
		path.add(new Cordinates(2, 2));
		path.add(new Cordinates(3, 2));
		path.add(new Cordinates(3, 3));
		path.add(new Cordinates(3, 4));
		path.add(new Cordinates(3, 5));
		path.add(new Cordinates(3, 6));
		path.add(new Cordinates(3, 7));
		expected.add(path);

		path = new ArrayList<Cordinates>();
		path.add(new Cordinates(1, 0));
		path.add(new Cordinates(1, 1));
		path.add(new Cordinates(2, 1));
		path.add(new Cordinates(2, 2));
		path.add(new Cordinates(3, 2));
		path.add(new Cordinates(3, 3));
		path.add(new Cordinates(3, 4));
		path.add(new Cordinates(2, 4));
		path.add(new Cordinates(1, 4));
		path.add(new Cordinates(0, 4));
		path.add(new Cordinates(0, 5));
		path.add(new Cordinates(0, 6));
		path.add(new Cordinates(0, 7));
		expected.add(path);

		for (int i = 0; i < expected.size(); ++i) {
			for (Cordinates cord : expected.get(i)) {
				board[cord.x][cord.y] = 1;
			}
		}

		List<List<Cordinates>> actual = FindAllPathsThroughGrid.findPathsFromTopToBottomDownAndRightOnly(board);
		assertEquals(actual.size(), expected.size());
		for (int i = 0; i < expected.size(); ++i) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}

}
