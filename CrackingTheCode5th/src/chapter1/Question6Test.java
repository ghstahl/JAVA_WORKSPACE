package chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question6Test {

	@Test
	public void testRotate90() {

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
		expectedImage.matrix[0] = new int[] { 4, 3, 2, 1 };
		expectedImage.matrix[1] = new int[] { 5, 4, 3, 2 };
		expectedImage.matrix[2] = new int[] { 6, 5, 4, 3 };
		expectedImage.matrix[3] = new int[] { 7, 6, 5, 4 };

		for (int i = 0; i < 4; ++i) {
			assertEquals(image.matrix[i], expectedImage.matrix[i]);
		}

	}

}
