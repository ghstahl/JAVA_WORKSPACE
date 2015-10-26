package chapter1;

public class Question6 {
	/**
	 * Given an image represented by an NxN matrix, where each pixel in the
	 * image is 4 bytes, write a method to rotate the image by 90 degrees. Can
	 * you do this in place?
	 */

	/*
	 * Assume N is the length of a single side. Running time is N + N-2 +N-4...1
	 * O(N) Size is N^2 // construction of the grid.
	 */
	// Running time O(N), everything else (Memory, etc) is constant.
	public static void Rotate90(ImageContainer imageContainer) {

		int length = imageContainer.matrix[0].length;

		for (int xS = 0; xS < length / 2; ++xS) {
			int xb = length - 1 - xS;
			int yb = length - 1 - xS;

			for (int x = xS, y = xS, offset = 0; x < xb; ++x, ++y, ++offset) {
				int a = imageContainer.matrix[x][y - offset];
				int b = imageContainer.matrix[xb][y];
				int c = imageContainer.matrix[xb - offset][yb];
				int d = imageContainer.matrix[x - offset][yb - offset];

				imageContainer.matrix[x][y - offset] = d;
				imageContainer.matrix[xb][y] = a;
				imageContainer.matrix[xb - offset][yb] = b;
				imageContainer.matrix[x - offset][yb - offset] = c;
			}
		}

	}

}
