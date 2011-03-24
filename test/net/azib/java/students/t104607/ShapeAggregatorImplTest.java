package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.Shape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShapeAggregatorImplTest {

	private ShapeAggregatorImpl aggregator = new ShapeAggregatorImpl();

	@Before
	public void addInitialShapes() {
		aggregator.addShapes(new Square(44),new Circle(33),new Circle(21), new Square(18));
	}

	@Test
	public void addShapes() throws Exception {
		assertEquals(4,aggregator.internalCollection.size());
		assertEquals(324.0,aggregator.internalCollection.get(3).area(),0.00001);
	}

	@Test
	public void min() throws Exception {
		assertEquals("Square with side length 18.0",aggregator.min().toString());
	}

	@Test
	public void max() throws Exception {
		assertEquals("Circle with radius 33.0",aggregator.max().toString());
	}

	@Test
	public void sortedShapes() throws Exception {
		assertEquals("Square with side length 18.0",aggregator.<Shape>sortedShapes().get(0).toString());
	}

	@Test
	public void copyTo() throws Exception {
		aggregator.copyTo(aggregator.internalCollection);
		assertEquals(8,aggregator.internalCollection.size());
	}

	@Test
	public void copyLargerTo() throws Exception {
		ShapeAggregatorImpl secondAggregator = new ShapeAggregatorImpl();
		aggregator.copyLargerTo(aggregator.internalCollection.get(2),secondAggregator.internalCollection);
		assertEquals(2,secondAggregator.internalCollection.size());
	}

	@Test
	public void totalArea() throws Exception {
		assertEquals(7066.63675,aggregator.totalArea(),0.00001);
	}
}
