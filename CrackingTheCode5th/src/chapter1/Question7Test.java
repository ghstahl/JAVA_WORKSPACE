package chapter1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Question7Test {

	@Test
	public void testZeroOutColumsAndRows() {

		ImageContainer image = new ImageContainer(4);
		image.matrix[0] = new int[] { 0, 2, 3, 4 };
		image.matrix[1] = new int[] { 2, 3, 4, 5 };
		image.matrix[2] = new int[] { 3, 4, 5, 6 };
		image.matrix[3] = new int[] { 4, 5, 6, 0 };

		ImageContainer expectedImage = new ImageContainer(4);
		expectedImage.matrix[0] = new int[] { 0, 0, 0, 0 };
		expectedImage.matrix[1] = new int[] { 0, 3, 4, 0 };
		expectedImage.matrix[2] = new int[] { 0, 4, 5, 0 };
		expectedImage.matrix[3] = new int[] { 0, 0, 0, 0 };

		Question7.ZeroOutColumsAndRows(image);
		for (int i = 0; i < 4; ++i) {
			int[] one = image.matrix[i];
			int[] two = expectedImage.matrix[i];
			assertArrayEquals(one, two);
		}
	}

}
