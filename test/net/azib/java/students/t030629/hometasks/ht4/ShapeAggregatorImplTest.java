package net.azib.java.students.t030629.hometasks.ht4;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.azib.java.lessons.collections.Shape;

import org.junit.Before;
import org.junit.Test;

/**
 * ShapeAggregatorImplTest
 *
 * @author anton_chepurov
 */
public class ShapeAggregatorImplTest {
	
	private ShapeAggregatorImpl shapeAggregator;
	private Square square1, square2, square3;
	

	@Before
	public void initShapeAgregator(){
		shapeAggregator = new ShapeAggregatorImpl();
		square1 = new Square(2); 
		square2 = new Square(4);
		square3 = new Square(5); 
		shapeAggregator.addShapes(square3, square1, square2);
	}
	
	@Test
	public void testMin(){
		assertEquals(square1, shapeAggregator.min());
	}

	@Test
	public void testMax(){
		assertEquals(square3, shapeAggregator.max());
	}
	
	@Test
	public void testSortedShapesOrder(){
		List<? extends Shape> sortedShapes = shapeAggregator.sortedShapes();
		Iterator<? extends Shape> iterator = sortedShapes.iterator();
		assertEquals(square1, iterator.next());
		assertEquals(square2, iterator.next());
		assertEquals(square3, iterator.next());
	}
	
	@Test
	public void testTotalArea(){
		assertEquals(45, shapeAggregator.totalArea());
	}
	
	@Test
	public void smallerShapeIsNotCopiedWithCopyLargerTo(){
		Collection<Shape> shapes = new LinkedList<Shape>();
		shapeAggregator.copyLargerTo(new Square(3), shapes);
		for (Shape shape : shapes){
			assertFalse(shape == square1);
		}
	}
	
	
	
}
