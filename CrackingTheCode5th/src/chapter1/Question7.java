package chapter1;

public class Question7 {
	/**
	 * Write an algorithm such that if an element in an MxN matrix is 0, its
	 * entire row and column are set to 0.
	 */

	public static void ZeroOutColumsAndRows_Quadratic(ImageContainer imageContainer) {

		boolean xMap[] = new boolean[imageContainer.matrix.length];
		boolean yMap[] = new boolean[imageContainer.matrix[0].length];

		// O(N) just to find the master zeros
		for (int x = 0; x < imageContainer.matrix.length; ++x) {
			for (int y = 0; y < imageContainer.matrix[0].length; ++y) {

				if (imageContainer.matrix[x][y] == 0) {
					xMap[x] = true;
					yMap[y] = true;
				}
			}
		}

		// O(N) here too, so 0(N^2)
		for (int x = 0; x < xMap.length; ++x) {
			if (xMap[x]) {
				// all ys have to be turned.
				for (int y = 0; y < imageContainer.matrix[0].length; ++y) {
					imageContainer.matrix[x][y] = 0;
				}
			}
		}
		for (int y = 0; y < yMap.length; ++y) {
			if (yMap[y]) {
				// all ys have to be turned.
				for (int x = 0; x < imageContainer.matrix.length; ++x) {
					imageContainer.matrix[x][y] = 0;
				}
			}
		}

	}
}
