package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.*;
import net.azib.java.lessons.collections.Shape;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * ShapeAggregatorImplTest
 * 
 * @author t030633
 */
public class ShapeAggregatorImplTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.ShapeAggregatorImpl#addShapes(net.azib.java.lessons.collections.Shape[])}.
	 */
	@Test
	public void testAddShapesShapeArray() {

		ShapeAggregatorImpl a = new ShapeAggregatorImpl();
		a.addShapes(new Circle(1), new Square(2));
		assertEquals(4.0, a.max().area());
		assertEquals(Math.PI, a.min().area());

	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.ShapeAggregatorImpl#addShapes(java.util.Collection)}.
	 */
	@Test
	public void testAddShapesCollectionOfQextendsShape() {

		ShapeAggregatorImpl a = new ShapeAggregatorImpl();
		Collection<Shape> coll = new LinkedList<Shape>();
		coll.add(new Circle(1));
		coll.add(new Square(2));
		a.addShapes(coll);
		assertEquals(4.0, a.max().area());
		assertEquals(Math.PI, a.min().area());

	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.ShapeAggregatorImpl#copyLargerTo(net.azib.java.lessons.collections.Shape, java.util.Collection)}.
	 */
	@Test
	public void testCopyLargerTo() {

		ShapeAggregatorImpl a = new ShapeAggregatorImpl();
		a.addShapes(new Circle(1), new Square(2));

		List<Shape> list = new LinkedList<Shape>();

		a.copyLargerTo(new Circle(1), list);

		assertEquals(1, list.size());
		assertEquals("2.0", list.get(0).toString());

	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.ShapeAggregatorImpl#copyTo(java.util.Collection)}.
	 */
	@Test
	public void testCopyTo() {

		ShapeAggregatorImpl a = new ShapeAggregatorImpl();
		a.addShapes(new Circle(1), new Square(2));

		List<Shape> list = new LinkedList<Shape>();

		a.copyTo(list);

		assertEquals(2, list.size());
		assertEquals("1.0", list.get(0).toString());
		assertEquals("2.0", list.get(1).toString());

	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.ShapeAggregatorImpl#sortedShapes()}.
	 */
	@Test
	public void testSortedShapes() {

		ShapeAggregatorImpl a = new ShapeAggregatorImpl();
		a.addShapes(new Circle(1), new Square(5), new Square(3), new Circle(100), new Circle(19));
		List<?> list = a.sortedShapes();

		assertEquals(new Square(3).hashCode(), list.get(1).hashCode());
		assertEquals("19.0", list.get(3).toString());

	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.ShapeAggregatorImpl#totalArea()}.
	 */
	@Test
	public void testTotalArea() {

		ShapeAggregatorImpl a = new ShapeAggregatorImpl();
		a.addShapes(new Circle(1), new Square(2), new Square(3));
		assertEquals(13 + Math.PI, a.totalArea());

	}

}
