package net.azib.java.students.t107110.hometask_0303;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class DuplicateRemoverImplTest {
	private DuplicateRemoverImpl remover = new DuplicateRemoverImpl();

	@Test
	public void nullStringList() {
		final String[] nullList = null;
		assertThat(uniqueStrings(nullList), are(null));
	}

	@Test
	public void noStrings() {
		assertThat(uniqueStrings(), are());
	}

	@Test
	public void oneString() {
		assertThat(uniqueStrings("one"), are("one"));
	}

	@Test
	public void twoDifferentStrings() {
		assertThat(uniqueStrings("one", "two"), are("one", "two"));
	}

	@Test
	public void twoSameStrings() {
		assertThat(uniqueStrings("one", "one"), are("one"));
	}

	@Test
	public void aFewStringsWithDuplicates() {
		assertThat(uniqueStrings("one", "two", "one", "three", "two"), are("one", "two", "three"));
	}

	private String[] uniqueStrings(final String... strings) {
		return remover.removeDuplicateStrings(strings);
	}

	private static org.hamcrest.Matcher<String[]> are(final String... strings) {
		return is(strings);
	}
}
