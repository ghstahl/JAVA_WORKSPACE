package recursion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermutationsTest {

	@Test
	public void testString_Lenth1() {
		String original = "e";
		List<String> perms = Permutations.makePermutations(original);

		List<String> expected = new ArrayList<String>();
		expected.add("e");

		assertEquals(perms.size(), expected.size());
		for (int i = 0; i < perms.size(); ++i) {
			assertEquals(perms.get(i), expected.get(i));
		}
	}

	@Test
	public void testString_Lenth2() {
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

	@Test
	public void testString_Lenth3() {
		String original = "yes";
		List<String> perms = Permutations.makePermutations(original);

		List<String> expected = new ArrayList<String>();
		expected.add("yes");
		expected.add("yse");
		expected.add("eys");
		expected.add("esy");
		expected.add("sye");
		expected.add("sey");

		assertEquals(perms.size(), expected.size());
		for (int i = 0; i < perms.size(); ++i) {
			assertEquals(perms.get(i), expected.get(i));
		}
	}
}
