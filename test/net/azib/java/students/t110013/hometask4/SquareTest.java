package net.azib.java.students.t110013.hometask4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class SquareTest {

	@Test(expected = IllegalArgumentException.class)
	public void negativeSideLengthsAreNotSupported() {
		new Square(-1);
	}

	@Test
	public void squaresWithDifferentSideLengthsAreNorEqual() {
		assertThat(new Square(3), is(not(new Square(2))));
	}

	@Test
	public void squaresWithEqualSideLengthsAreEqual() {
		assertThat(new Square(0), equalTo(new Square(0)));
	}

	@Test
	public void squaresWithEqualSideLengthsHaveEqualHashCodes() {
		assertThat(new Square(8).hashCode(), equalTo(new Square(8).hashCode()));
	}
}
