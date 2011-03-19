package net.azib.java.students.t107110.hometask_0310;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;


/**
 * @author Eduard Shustrov
 */
public class CircleTest {
	@Test(expected = IllegalArgumentException.class)
	public void negativeRadiusNotSupported() {
		new Circle(-1);
	}

	@Test
	public void circlesOfDifferentRadiusAreNotEqual() {
		assertThat(new Circle(1), is(not(new Circle(0))));
	}

	@Test
	public void circlesOfTheSameRadiusAreEqual() {
		assertThat(new Circle(1), is(new Circle(1)));
	}

	@Test
	public void circlesOfTheSameRadiusHaveTheSameHashCode() {
		assertThat(new Circle(1).hashCode(), is(new Circle(1).hashCode()));
	}

	@Test
	public void textFormOfZeroRadiusCircle() {
		assertThat(new Circle(0).toString(), is("Circle{radius=0.0,area=0.0}"));
	}

	@Test
	public void textFormOfOneRadiusCircle() {
		assertThat(new Circle(1).toString(), is("Circle{radius=1.0,area=" + Math.PI + "}"));
	}

	@Test
	public void areaOfZeroRadiusCircle() {
		assertThat(new Circle(0).area(), is(0.0));
	}

	@Test
	public void areaOfOneRadiusCircle() {
		assertThat(new Circle(1).area(), is(Math.PI));
	}

	@Test
	public void areaOfTenRadiusCircle() {
		assertThat(new Circle(10).area(), is(Math.PI * 100));
	}
}
