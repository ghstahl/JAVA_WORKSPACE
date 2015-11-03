package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsThroughGrid {

	public static List<Cordinates> makeCopy(List<Cordinates> original, int beginIndex) {
		List<Cordinates> clone = new ArrayList<Cordinates>();
		for (int i = beginIndex; i < original.size(); ++i) {
			clone.add(original.get(i).clone());
		}
		return clone;
	}

	public static List<List<Cordinates>> findPathsFromTopToBottomDownAndRightOnly(int[][] board) {
		Cordinates constraintCord = new Cordinates(board.length - 1, board[0].length - 1);
		List<List<Cordinates>> coords = new ArrayList<List<Cordinates>>();

		// make a virtual starting point.
		Cordinates entryCord = new Cordinates(0, -1);
		Cordinates previousCord = new Cordinates(-1, -1);
		RecursiveTopToBottomDownAndRightOnly(board, constraintCord, coords, new ArrayList<Cordinates>(), entryCord,
				previousCord);
		return coords;
	}

	public static void RecursiveTopToBottomDownAndRightOnly(int[][] board, Cordinates constraintCord,
			List<List<Cordinates>> containerOfSuccess, List<Cordinates> containerOfCurrentPath, Cordinates currentCord,
			Cordinates previousCord) {

		// base case.
		containerOfCurrentPath.add(currentCord);
		if (currentCord.y == constraintCord.y) {
			// we be at the bottom.
			containerOfSuccess.add(makeCopy(containerOfCurrentPath, 0));
		} else {
			// we go right or left, so get the next cords
			if (currentCord.x < constraintCord.x
					&& (currentCord.y == -1 || board[currentCord.x + 1][currentCord.y] == 1)) {
				Cordinates newX = new Cordinates(currentCord.x + 1, currentCord.y);

				if (!newX.equals(previousCord)) {
					RecursiveTopToBottomDownAndRightOnly(board, constraintCord, containerOfSuccess,
							containerOfCurrentPath, newX, currentCord);

				}
			}

			// since bottoming out on y is covered we just keep going
			if (board[currentCord.x][currentCord.y + 1] == 1) {
				// got a good x.
				Cordinates newX = new Cordinates(currentCord.x, currentCord.y + 1);
				// this is to show we already have been here, so no more right
				// traversal
				if (currentCord.y == -1) {
					// set start fresh as we are going down for the first
					// time.
					List<Cordinates> internalCurrentPath = new ArrayList<Cordinates>();
					RecursiveTopToBottomDownAndRightOnly(board, constraintCord, containerOfSuccess, internalCurrentPath,
							newX, currentCord);
				} else {
					RecursiveTopToBottomDownAndRightOnly(board, constraintCord, containerOfSuccess,
							containerOfCurrentPath, newX, currentCord);
				}

			}
			// now see if we need to go left.
			if (currentCord.y > -1 && currentCord.x > 0 && board[currentCord.x - 1][currentCord.y] == 1) {
				// this is to show we already have been here, so no more right
				// traversal
				Cordinates newX = new Cordinates(currentCord.x - 1, currentCord.y);
				if (!newX.equals(previousCord)) {
					RecursiveTopToBottomDownAndRightOnly(board, constraintCord, containerOfSuccess,
							containerOfCurrentPath, newX, currentCord);
				}
			}
		}
		if (containerOfCurrentPath.size() > 0) {
			// get rid of the cord that was added as it is a dead end.
			containerOfCurrentPath.remove(containerOfCurrentPath.size() - 1);
		}

	}

}
