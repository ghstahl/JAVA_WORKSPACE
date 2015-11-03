package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsThroughGrid {

	private boolean _findAll = true;
	private List<List<Cordinates>> _cords = new ArrayList<List<Cordinates>>();
	private int[][] _board = null;

	private Cordinates _constraintCord = null;

	public boolean foundAtLeastOne() {
		return _cords.size() > 0;
	}

	public FindAllPathsThroughGrid(boolean findAll, int[][] board) {
		this._findAll = findAll;
		this._board = board;
		_constraintCord = new Cordinates(_board.length - 1, _board[0].length - 1);
	}

	public static List<Cordinates> makeCopy(List<Cordinates> original, int beginIndex) {
		List<Cordinates> clone = new ArrayList<Cordinates>();
		for (int i = beginIndex; i < original.size(); ++i) {
			clone.add(original.get(i).clone());
		}
		return clone;
	}

	public static List<List<Cordinates>> findPathsToBottom(boolean findAll, int[][] board) {

		// make a virtual starting point.
		Cordinates entryCord = new Cordinates(0, -1);
		Cordinates previousCord = new Cordinates(-1, -1);
		FindAllPathsThroughGrid fap = new FindAllPathsThroughGrid(findAll, board);

		fap.RecursiveTopToBottomDownAndRightOnly(new ArrayList<Cordinates>(), entryCord, previousCord);
		return fap.get_cords();
	}

	private void RecursiveTopToBottomDownAndRightOnly(List<Cordinates> containerOfCurrentPath, Cordinates currentCord,
			Cordinates previousCord) {

		if (_findAll == false && foundAtLeastOne()) {
			return;// bail out and just let it unwind
		}

		// base case.
		containerOfCurrentPath.add(currentCord);
		if (currentCord.y == _constraintCord.y) {
			// we be at the bottom.
			_cords.add(makeCopy(containerOfCurrentPath, 0));
		} else {
			// we go right or left, so get the next cords
			if (currentCord.x < _constraintCord.x
					&& (currentCord.y == -1 || _board[currentCord.x + 1][currentCord.y] == 1)) {
				Cordinates newX = new Cordinates(currentCord.x + 1, currentCord.y);

				if (!newX.equals(previousCord)) {
					RecursiveTopToBottomDownAndRightOnly(containerOfCurrentPath, newX, currentCord);

				}
			}

			// since bottoming out on y is covered we just keep going
			if (_board[currentCord.x][currentCord.y + 1] == 1) {
				// got a good x.
				Cordinates newX = new Cordinates(currentCord.x, currentCord.y + 1);
				// this is to show we already have been here, so no more right
				// traversal
				if (currentCord.y == -1) {
					// set start fresh as we are going down for the first
					// time.
					List<Cordinates> internalCurrentPath = new ArrayList<Cordinates>();
					RecursiveTopToBottomDownAndRightOnly(internalCurrentPath, newX, currentCord);
				} else {
					RecursiveTopToBottomDownAndRightOnly(containerOfCurrentPath, newX, currentCord);
				}

			}
			// now see if we need to go left.
			if (currentCord.y > -1 && currentCord.x > 0 && _board[currentCord.x - 1][currentCord.y] == 1) {
				// this is to show we already have been here, so no more right
				// traversal
				Cordinates newX = new Cordinates(currentCord.x - 1, currentCord.y);
				if (!newX.equals(previousCord)) {
					RecursiveTopToBottomDownAndRightOnly(containerOfCurrentPath, newX, currentCord);
				}
			}
		}
		if (containerOfCurrentPath.size() > 0) {
			// get rid of the cord that was added as it is a dead end.
			containerOfCurrentPath.remove(containerOfCurrentPath.size() - 1);
		}

	}

	public List<List<Cordinates>> get_cords() {
		return _cords;
	}

}
