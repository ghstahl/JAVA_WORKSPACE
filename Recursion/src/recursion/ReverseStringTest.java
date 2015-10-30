package recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseStringTest {

	@Test
	public void testReverse() {
		String original = "recursion";
		String expected = "noisrucer";
		String actual = ReverseString.reverse(original);
		assertEquals(actual, expected);

	}

}
