package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import net.azib.java.lessons.collections.Shape;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * ShapeAggregateImplTest
 *
 * @author Administrator
 */
public class ShapeAggregateImplTest {
	
	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#addShapes(net.azib.java.lessons.collections.Shape[])}.
	 */
	@Test
	public void testAddShapesShapeArray() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,c3,sq1,sq2);
		List<Shape> col = new LinkedList<Shape>();
		col.add(c1);
		col.add(c2);
		col.add(c3);
		col.add(sq2);
		col.add(sq1);
		Collections.sort(col);
		assertEquals(col.toString(), shapes.sortedShapes().toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#addShapes(java.util.Collection)}.
	 */
	@Test
	public void testAddShapesCollectionOfQextendsShape() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		List<Shape> col = new LinkedList<Shape>();
		col.add(c1);
		col.add(c2);
		col.add(c3);
		col.add(sq2);
		col.add(sq1);
		Collections.sort(col);
		shapes.addShapes(col);
		assertEquals(col.toString(), shapes.sortedShapes().toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#copyLargerTo(net.azib.java.lessons.collections.Shape, java.util.Collection)}.
	 */
	@Test
	public void testCopyLargerTo() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,sq1,sq2,c3);
		List<Shape> col = new LinkedList<Shape>();
		col.add(c1);
		col.add(c2);
		col.add(sq2);
		Collections.sort(col);
		List<Shape> col2 = new LinkedList<Shape>();
		shapes.copyLargerTo(c3, col2);
		assertEquals(col.toString(), col2.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#copyTo(java.util.Collection)}.
	 */
	@Test
	public void testCopyTo() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,sq1,sq2,c3);
		List<Shape> col = new LinkedList<Shape>();
		col.add(c1);
		col.add(c2);
		col.add(c3);
		col.add(sq1);
		col.add(sq2);
		Collections.sort(col);
		List<Shape> col2 = new LinkedList<Shape>();
		shapes.copyTo(col2);
		assertEquals(col.toString(), col2.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#max()}.
	 */
	@Test
	public void testMax() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,sq1,sq2,c3);
		assertEquals(c2.toString(), shapes.max().toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#min()}.
	 */
	@Test
	public void testMin() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,sq1,sq2,c3);
		assertEquals(sq1.toString(), shapes.min().toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#sortedShapes()}.
	 */
	@Test
	public void testSortedShapes() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,sq1,sq2,c3);
		List<Shape> lst = new LinkedList<Shape>();
		lst.add(sq1);
		lst.add(c3);
		lst.add(sq2);
		lst.add(c1);
		lst.add(c2);
		assertEquals(Collections.unmodifiableList(lst).toString(), shapes.sortedShapes().toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.ShapeAggregatorImpl#totalArea()}.
	 */
	@Test
	public void testTotalArea() {
		Circle c1 = new Circle(10.1456);
		Circle c2 = new Circle(24.058);
		Circle c3 = new Circle(3.456);
		Square sq1 = new Square(5.05);
		Square sq2 = new Square (17.97722);
		double areas = 2527.8942341738175;
		ShapeAggregatorImpl shapes = new ShapeAggregatorImpl();
		shapes.addShapes(c1,c2,sq1,sq2,c3);
		assertEquals(areas, shapes.totalArea(), 0.000000000000);
	}

}
