package net.azib.java.students.t093759.hometasks.fourth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * 24.03.11 12:30
 *
 * @author Dionis
 */
public class CircleTest {
	@Test(expected = IllegalArgumentException.class)
	public void unableToCreateCircleWithNegativeRadius() {
		new Circle(-1);
	}

	@Test
	public void circlesAreaIsOk() {
		double sideLength = 1.0;
		double correctArea = Math.PI * sideLength * sideLength;
		assertThat(new Circle(sideLength).area(), is(correctArea));
	}

	@Test
	public void circlesStringRepresentationLookLikesSoAsItShouldBe() {
		double sideLength = 1.0;
		String correctStringRepresentation = "Square with side length " + sideLength + " and area " + new Square(sideLength).area();
		assertThat(new Circle(sideLength).toString(), equalTo(correctStringRepresentation));
	}

	@Test
	public void twoCirclesWithTheSameSideLengthHaveTheSameHashCode() {
		double sideLength = 99.0;
		Circle a = new Circle(sideLength);
		Circle b = new Circle(sideLength);
		assertThat(a, not(sameInstance(b)));
		assertThat(a.hashCode(), equalTo(b.hashCode()));
	}

	@Test
	public void twoCirclesWithTheSameSideLengthAreEqual() {
		double sideLength = 99.0;
		Circle a = new Circle(sideLength);
		Circle b = new Circle(sideLength);
		assertThat(a, not(sameInstance(b)));
		assertThat(a, equalTo(b));
	}
}
