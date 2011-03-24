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
		double radius = 1.0;
		double correctArea = Math.PI * radius * radius;
		assertThat(new Circle(radius).area(), is(correctArea));
	}

	@Test
	public void circlesStringRepresentationLookLikesSoAsItShouldBe() {
		double radius = 1.0;
		String correctStringRepresentation = "Circle with radius " + radius + " and area " + new Circle(radius).area();
		assertThat(new Circle(radius).toString(), equalTo(correctStringRepresentation));
	}

	@Test
	public void twoCirclesWithTheSameRadiusHaveTheSameHashCode() {
		double radius = 99.0;
		Circle a = new Circle(radius);
		Circle b = new Circle(radius);
		assertThat(a, not(sameInstance(b)));
		assertThat(a.hashCode(), equalTo(b.hashCode()));
	}

	@Test
	public void twoCirclesWithTheSameRadiusAreEqual() {
		double radius = 99.0;
		Circle a = new Circle(radius);
		Circle b = new Circle(radius);
		assertThat(a, not(sameInstance(b)));
		assertThat(a, equalTo(b));
	}
}
