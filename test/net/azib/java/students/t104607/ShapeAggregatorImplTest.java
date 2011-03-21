package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeAggregatorImplTest {

	@Test
	public void addShapes() throws Exception {
		ShapeAggregatorImpl aggregator = create();
		assertEquals(4,aggregator.internalCollection.size());
		assertEquals(324.0,aggregator.internalCollection.get(3).area(),0.00001);
	}

	@Test
	public void min() throws Exception {
	    ShapeAggregatorImpl aggregator = create();
		assertEquals("Square with side length 18.0",aggregator.min().toString());
	}

	@Test
	public void max() throws Exception {
		ShapeAggregatorImpl aggregator = create();
		assertEquals("Circle with radius 33.0",aggregator.max().toString());
	}

	@Test
	public void sortedShapes() throws Exception {
	 	ShapeAggregatorImpl aggregator = create();
		assertEquals("Square with side length 18.0",aggregator.<Shape>sortedShapes().get(0).toString());
	}

	@Test
	public void copyTo() throws Exception {
	 	ShapeAggregatorImpl aggregator = create();
		aggregator.copyTo(aggregator.internalCollection);
		assertEquals(8,aggregator.internalCollection.size());
	}

	@Test
	public void copyLargerTo() throws Exception {
		ShapeAggregatorImpl aggregator = create();
		ShapeAggregatorImpl secondAggregator = new ShapeAggregatorImpl();
		aggregator.copyLargerTo(aggregator.internalCollection.get(2),secondAggregator.internalCollection);
		assertEquals(2,secondAggregator.internalCollection.size());
	}

	@Test
	public void totalArea() throws Exception {
		ShapeAggregatorImpl aggregator = create();
		assertEquals(7066.63675,aggregator.totalArea(),0.00001);
	}

	ShapeAggregatorImpl create() {
		ShapeAggregatorImpl aggregator = new ShapeAggregatorImpl();
		aggregator.addShapes(new Square(44),new Circle(33),new Circle(21), new Square(18));
		return aggregator;
	}
}
