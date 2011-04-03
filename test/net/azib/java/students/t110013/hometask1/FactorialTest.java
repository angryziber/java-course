package net.azib.java.students.t110013.hometask1;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class FactorialTest {

	@Test(expected = IllegalArgumentException.class)
	public void factorialsOfNegativeIntegersAreNotSupported() {
		factorial(-1);
	}

	@Test
	public void factorialsOfFirstFewNumbers() {
		assertThat(factorials(1, 2, 3, 4, 5, 6, 7, 8), are("1", "2", "6", "24", "120", "720", "5040", "40320"));
	}

	@Test
	public void factorialOfHundred() {
		assertThat(factorial(100), is("933262154439441526816992388562667004907159682643816214685929638952175999932299" +
				"15608941463976156518286253697920827223758251185210916864000000000000000000000000"));
	}

	private static String factorial(int n) {
		return Factorial.compute(n).toString();
	}

	private String[] factorials(int... numbers) {
		List<String> values = new ArrayList<String>();
		for (int n : numbers) {
			values.add(factorial(n));
		}
		return values.toArray(new String[values.size()]);
	}

	private Matcher<String[]> are(String... expected) {
		return is(expected);
	}
}
