package net.azib.java.students.t072073.tasks;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import net.azib.java.lessons.collections.Shape;

import org.junit.Test;

/**
 * ShapeAggregatorImplTest
 * 
 * @author janika
 */
public class ShapeAggregatorImplTest {
	private ShapeAggregatorImpl shapeAggregator = new ShapeAggregatorImpl();
	private Shape[] shapeArray = new Shape[] { new Square(12), new Circle(17), new Circle(10) };
	private List<Shape> shapeList = new LinkedList<Shape>(Arrays.asList(shapeArray));

	@Test
	public void addShapesArray() throws Exception {
		shapeAggregator.addShapes(shapeArray);
		assertEquals(shapeList, shapeAggregator.shapesList);
	}

	@Test
	public void addShapesCollection() throws Exception {
		Collection<? extends Shape> shapeCollection = shapeList;
		shapeAggregator.addShapes(shapeCollection);
		assertEquals(shapeList, shapeAggregator.shapesList);
	}

	@Test
	public void maxShape() throws Exception {
		Collection<? extends Shape> shapeCollection = shapeList;
		shapeAggregator.addShapes(shapeCollection);
		assertEquals(new Circle(17), shapeAggregator.max());
	}

	@Test
	public void minShape() throws Exception {
		Collection<? extends Shape> shapeCollection = shapeList;
		shapeAggregator.addShapes(shapeCollection);
		assertEquals(new Square(12), shapeAggregator.min());
	}

	@Test
	public void sortedShapes() throws Exception {
		shapeAggregator.addShapes(shapeArray);
		Arrays.sort(shapeArray);
		List<Shape> expectedShapes = Arrays.asList(shapeArray);
		assertEquals(expectedShapes, shapeAggregator.sortedShapes());
		assertEquals(new Circle(17), shapeAggregator.sortedShapes().get(2));

	}
}
