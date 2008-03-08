package net.azib.java.students.t001370.lectures.lec4.home;

import static org.junit.Assert.*;

import net.azib.java.lessons.collections.Shape;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ShapeAggregatorImplTest
 *
 * @author maksim
 */
public class ShapeAggregatorImplTest {
	Shape[] shapes = new Shape[]{new Square(10), new Square(2)};


	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.ShapeAggregatorImpl#max()}.
	 */
	@Test
	public void testMax() {
		ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
		sai.addShapes(shapes);

		assertEquals("!!!ShapeAggregatorImpl max failed!!!",
				shapes[0], sai.max());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.ShapeAggregatorImpl#min()}.
	 */
	@Test
	public void testMin() {
		ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
		sai.addShapes(shapes);

		assertEquals("!!!ShapeAggregatorImpl min failed!!!",
				shapes[1], sai.min());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.ShapeAggregatorImpl#sortedShapes()}.
	 */
	@Test
	public void testSortedShapes() {
		ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
		sai.addShapes(shapes);
		List<? extends Shape> list = new ArrayList<Shape>();
		list = sai.sortedShapes();

		assertArrayEquals("!!!ShapeAggregatorImpl sortedShapes failed!!!",
				list.toArray(), new Shape[]{shapes[1], shapes[0]});
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.ShapeAggregatorImpl#totalArea()}.
	 */
	@Test
	public void testTotalArea() {
		ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
		sai.addShapes(shapes);

		assertEquals("!!!ShapeAggregatorImpl totalArea failed!!!",
				shapes[0].area() + shapes[1].area(), sai.totalArea());
	}

}
