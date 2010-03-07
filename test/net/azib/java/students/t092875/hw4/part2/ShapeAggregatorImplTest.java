package net.azib.java.students.t092875.hw4.part2;

import static org.junit.Assert.*;

import net.azib.java.lessons.collections.Shape;


import org.junit.Test;
/**
 * ShapeAggregatorImpltest
 *
 * @author Mihhailtt
 */
public class ShapeAggregatorImplTest {
	@Test
	public void maxTest(){
		ShapeAggregatorImpl sa = new ShapeAggregatorImpl();
		Shape a = new Square(5);
		Shape b = new Square(15);
		Shape c = new Square(10);
		sa.addShapes(a,b,c);
		assertEquals(225.0,sa.max().area(),0);
	}
	
	public void minTest(){
		ShapeAggregatorImpl sa = new ShapeAggregatorImpl();
		Shape a = new Square(5);
		Shape b = new Square(15);
		Shape c = new Square(10);
		sa.addShapes(a,b,c);
		assertEquals(25.0,sa.max().area(),0);
	}
	
	public void totalAreaTest(){
		ShapeAggregatorImpl sa = new ShapeAggregatorImpl();
		Shape a = new Square(5);
		Shape b = new Square(15);
		Shape c = new Square(10);
		sa.addShapes(a,b,c);
		assertEquals(350.0,sa.totalArea(),0);
	}
	
}
