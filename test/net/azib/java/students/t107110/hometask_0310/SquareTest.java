package net.azib.java.students.t107110.hometask_0310;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class SquareTest {
	@Test(expected = IllegalArgumentException.class)
	public void negativeSizeNotSupported() {
		new Square(-1);
	}

	@Test
	public void squaresOfDifferentSizeAreNotEqual() {
		assertThat(new Square(1), is(not(new Square(0))));
	}

	@Test
	public void squaresOfTheSameSizeAreEqual() {
		assertThat(new Square(1), is(new Square(1)));
	}

	@Test
	public void squaresOfTheSameSizeHaveTheSameHashCode() {
		assertThat(new Square(1).hashCode(), is(new Square(1).hashCode()));
	}

	@Test
	public void textFormOfZeroSizeSquare() {
		assertThat(new Square(0).toString(), is("Square{size=0.0,area=0.0}"));
	}

	@Test
	public void textFormOfOneSizeSquare() {
		assertThat(new Square(1).toString(), is("Square{size=1.0,area=1.0}"));
	}

	@Test
	public void areaOfZeroSizeSquare() {
		assertThat(new Square(0).area(), is(0.0));
	}

	@Test
	public void areaOfOneSizeSquare() {
		assertThat(new Square(1).area(), is(1.0));
	}

	@Test
	public void areaOfTenSizeSquare() {
		assertThat(new Square(10).area(), is(100.0));
	}
}
