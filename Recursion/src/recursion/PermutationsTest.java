package recursion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermutationsTest {

	@Test
	public void testString() {
		String original = "es";
		List<String> perms = Permutations.makePermutations(original);

		List<String> expected = new ArrayList<String>();
		expected.add("es");
		expected.add("se");

		assertEquals(perms.size(), expected.size());
		for (int i = 0; i < perms.size(); ++i) {
			assertEquals(perms.get(i), expected.get(i));
		}

	}

}
