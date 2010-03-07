package net.azib.java.students.t093052.hometask04;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * ShapeAggregatorTest
 *
 * @author Kostja
 */
public class ShapeAggregatorTest {

	@Test
	public void totalArea() throws Exception {
		ShapeAggregator aggregator = new ShapeAggregatorImpl();
		
		aggregator.addShapes(Arrays.asList(new Circle(5), new Square(5)));
		
		assertEquals(103.53, aggregator.totalArea(), 0.01);
	}
	
	@Test
	public void max() throws Exception {
		ShapeAggregator aggregator = new ShapeAggregatorImpl();
		
		aggregator.addShapes(new Square(6), new Circle(5), new Square(4), 
				new Circle(3), new Square(5));
		
		assertEquals(new Circle(5), aggregator.max());
	}
	
	@Test
	public void min() throws Exception {
		ShapeAggregator aggregator = new ShapeAggregatorImpl();
		
		aggregator.addShapes(new Square(6), new Circle(5), new Square(4), 
				new Circle(3), new Square(5));
		
		assertEquals(new Square(4), aggregator.min());
	}
	
	@Test
	public void sortedShapes() throws Exception {
		ShapeAggregator aggregator = new ShapeAggregatorImpl();
		
		aggregator.addShapes(new Square(6), new Circle(5), new Square(4), 
				new Circle(3), new Square(5));
		
		assertEquals(Arrays.asList(new Square(4), new Square(5), new Circle(3), 
			new Square(6), new Circle(5)), aggregator.sortedShapes());
	}
	
	@Test
	public void copyLargerTo() throws Exception {
		ShapeAggregator aggregator = new ShapeAggregatorImpl();
		
		aggregator.addShapes(new Square(6), new Circle(5), new Square(4), 
				new Circle(3), new Square(5));
		
		List<Shape> shapes = new ArrayList<Shape>();
		
		aggregator.copyLargerTo(new Circle(3), shapes);
		
		assertEquals(Arrays.asList(new Square(6), new Circle(5)), shapes);
	}
	
	@Test
	public void copyTo() throws Exception {
		ShapeAggregator aggregator = new ShapeAggregatorImpl();
		
		aggregator.addShapes(new Square(6), new Circle(5), new Square(4), 
				new Circle(3), new Square(5));
		
		List<Shape> shapes = new ArrayList<Shape>();
		
		aggregator.copyTo(shapes);
		
		assertEquals(Arrays.asList(new Square(6), new Circle(5), new Square(4), 
				new Circle(3), new Square(5)), shapes);
	}
}
