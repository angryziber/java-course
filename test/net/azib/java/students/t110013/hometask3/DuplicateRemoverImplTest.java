package net.azib.java.students.t110013.hometask3;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class DuplicateRemoverImplTest {
	private DuplicateRemoverImpl dr = new DuplicateRemoverImpl();

	@SuppressWarnings("NullArgumentToVariableArgMethod")
	@Test(expected = NullPointerException.class)
	public void nullArgument() {
		dr.removeDuplicateStrings(null);
	}

	@Test
	public void noArgument() {
		assertThat(dr.removeDuplicateStrings(), returns());
	}

	@Test
	public void noDuplicates() {
		assertThat(dr.removeDuplicateStrings("b", "c", "a"), returns("b", "c", "a"));
	}

	@Test
	public void removeDuplicatesKeepOrder() {
		assertThat(dr.removeDuplicateStrings("a", "b", "c", "b", "a", "v", "f", "c", "b"), returns("a", "b", "c", "v", "f"));
	}

	private Matcher<String[]> returns(String... expected) {
		return is(expected);
	}
}
