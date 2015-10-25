package chapter1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Question6Test {

	@Test
	public void testRotate90_EvenGrid() {

		/*
		 * {1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}
		 */
		ImageContainer image = new ImageContainer(4);
		image.matrix[0] = new int[] { 1, 2, 3, 4 };
		image.matrix[1] = new int[] { 2, 3, 4, 5 };
		image.matrix[2] = new int[] { 3, 4, 5, 6 };
		image.matrix[3] = new int[] { 4, 5, 6, 7 };

		/*
		 * {4,3,2,1},{5,4,3,2},{6,5,4,3},{7,6,5,4}
		 */
		ImageContainer expectedImage = new ImageContainer(4);
		expectedImage.matrix[0] = new int[] { 4, 5, 6, 7 };
		expectedImage.matrix[1] = new int[] { 3, 4, 5, 6 };
		expectedImage.matrix[2] = new int[] { 2, 3, 4, 5 };
		expectedImage.matrix[3] = new int[] { 1, 2, 3, 4 };

		Question6.Rotate90(image);
		for (int i = 0; i < 4; ++i) {
			int[] one = image.matrix[i];
			int[] two = expectedImage.matrix[i];
			assertArrayEquals(one, two);
		}

	}

	@Test
	public void testRotate90_OddGrid() {

		ImageContainer image = new ImageContainer(5);
		image.matrix[0] = new int[] { 1, 2, 3, 4, 5 };
		image.matrix[1] = new int[] { 2, 3, 4, 5, 6 };
		image.matrix[2] = new int[] { 3, 4, 5, 6, 7 };
		image.matrix[3] = new int[] { 4, 5, 6, 7, 8 };
		image.matrix[4] = new int[] { 5, 6, 7, 8, 9 };

		ImageContainer expectedImage = new ImageContainer(5);
		expectedImage.matrix[0] = new int[] { 5, 6, 7, 8, 9 };
		expectedImage.matrix[1] = new int[] { 4, 5, 6, 7, 8 };
		expectedImage.matrix[2] = new int[] { 3, 4, 5, 6, 7 };
		expectedImage.matrix[3] = new int[] { 2, 3, 4, 5, 6 };
		expectedImage.matrix[4] = new int[] { 1, 2, 3, 4, 5 };
		Question6.Rotate90(image);
		for (int i = 0; i < 5; ++i) {
			int[] one = image.matrix[i];
			int[] two = expectedImage.matrix[i];
			assertArrayEquals(one, two);
		}

	}

}
