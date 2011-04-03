package net.azib.java.students.t110013.hometask4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class CircleTest {

	@Test(expected = IllegalArgumentException.class)
	public void negativeRadiiAreNotSupported() {
		new Circle(-1);
	}

	@Test
	public void circlesWithDifferentRadiiAreNorEqual() {
		assertThat(new Circle(5), is(not(new Circle(4))));
	}

	@Test
	public void circlesWithEqualRadiiAreEqual() {
		assertThat(new Circle(4), equalTo(new Circle(4)));
	}

	@Test
	public void circlesWithEqualRadiiHaveEqualHashCodes() {
		assertThat(new Circle(5).hashCode(), equalTo(new Circle(5).hashCode()));
	}
}
