package net.azib.java.students.t093759.hometasks.fourth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * 24.03.11 12:29
 *
 * @author Dionis
 */
public class SquareTest {
	@Test(expected = IllegalArgumentException.class)
	public void unableToCreateSquareWithNegativeRadius() {
		new Square(-1);
	}

	@Test
	public void squaresAreaIsOk() {
		double sideLength = 1.0;
		double correctArea = sideLength * sideLength;
		assertThat(new Square(sideLength).area(), is(correctArea));
	}

	@Test
	public void circlesStringRepresentationLookLikesSoAsItShouldBe() {
		double sideLength = 1.0;
		String correctStringRepresentation = "Square with side length " + sideLength + " and area " + new Square(sideLength).area();
		assertThat(new Square(sideLength).toString(), equalTo(correctStringRepresentation));
	}

	@Test
	public void twoSquaresWithTheSameRadiusHaveTheSameHashCode() {
		double sideLength = 99.0;
		Square a = new Square(sideLength);
		Square b = new Square(sideLength);
		assertThat(a, not(sameInstance(b)));
		assertThat(a.hashCode(), equalTo(b.hashCode()));
	}

	@Test
	public void twoSquaresWithTheSameRadiusAreEqual() {
		double sideLength = 99.0;
		Square a = new Square(sideLength);
		Square b = new Square(sideLength);
		assertThat(a, not(sameInstance(b)));
		assertThat(a, equalTo(b));
	}
}
