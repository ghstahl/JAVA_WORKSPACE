package recursion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FindAllPathsThroughGridTest {

	public static int[][] BuildRandomGrid(int x, int y, int percentOpen) {
		int board[][] = new int[x][y];

		int total = x * y;
		int totalOpen = total * percentOpen / 100;
		Random randomGenerator = new Random();
		while (totalOpen > 0) {
			int randomIntX = randomGenerator.nextInt(20);
			int randomIntY = randomGenerator.nextInt(20);
			if (board[randomIntX][randomIntY] == 0) {
				board[randomIntX][randomIntY] = 1;
				--totalOpen;
			}
		}
		return board;

	}

	@Test
	public void testPercolation() {

		int nTotal = 1000;
		int nPerc = 0;

		for (int i = 0; i < nTotal; ++i) {
			int board[][] = BuildRandomGrid(20, 20, 60);
			assertNotNull(board);
			List<List<Cordinates>> actual = FindAllPathsThroughGrid.findPathsToBottom(false, board);
			if (actual.size() > 0) {
				++nPerc;
			}
		}
		int percentPerc = (nPerc * 100) / nTotal;

		System.out.println("PercentPerc:" + percentPerc);
		// assertEquals(actual.size(), 1);
	}

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

		List<List<Cordinates>> actual = FindAllPathsThroughGrid.findPathsToBottom(true, board);
		assertEquals(actual.size(), expected.size());
		for (int i = 0; i < expected.size(); ++i) {
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	@Test
	public void test_findAtLeastOne() {

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

		List<List<Cordinates>> actual = FindAllPathsThroughGrid.findPathsToBottom(false, board);
		assertEquals(actual.size(), 1);
		assertEquals(expected.get(0), actual.get(0));

	}
}
