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
		assertThat(uniqueStrings(nullList), are(strings(null)));
	}

	@Test
	public void noStrings() {
		assertThat(uniqueStrings(), are(strings()));
	}

	@Test
	public void oneString() {
		assertThat(uniqueStrings("one"), are(strings("one")));
	}

	@Test
	public void twoDifferentStrings() {
		assertThat(uniqueStrings("one", "two"), are(strings("one", "two")));
	}

	@Test
	public void twoSameStrings() {
		assertThat(uniqueStrings("one", "one"), are(strings("one")));
	}

	@Test
	public void aFewStringsWithDuplicates() {
		assertThat(uniqueStrings("one", "two", "one", "three", "two"), are(strings("one", "two", "three")));
	}

	private String[] uniqueStrings(final String... strings) {
		return remover.removeDuplicateStrings(strings);
	}

	private static String[] strings(final String... strings) {
		return strings;
	}

	private static <T> org.hamcrest.Matcher<T> are(T value) {
		return is(value);
	}
}
