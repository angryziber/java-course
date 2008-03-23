package net.azib.java.students.t654321.hometasks;


import net.azib.java.lessons.collections.Shape;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;




/**
 * ShapeAggregatorImplTest
 *
 * @author Karl
 */
public class ShapeAggregatorImplTest {


	
	/*
	 * Still TODO:
	 * 1. One shape can be added to Shapelist
	 * 2. Circle and Square unit tests
	 * 3. Add empty list
	 * 4. Add empty array
	 */
	ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
	
	// Creates list of Shapes
	private List<Shape> shapeListCreator(){
		List<Shape> listOfShapesForTest = new LinkedList<Shape>();
		
		listOfShapesForTest.add(new Circle(2.34)); // area = 17,19
		listOfShapesForTest.add(new Square(3.00)); // area = 9.00
		listOfShapesForTest.add(new Circle(100.0)); // area = 31400
		listOfShapesForTest.add(new Square(5.34)); // area = 28,52
		listOfShapesForTest.add(new Circle(25.0)); // area = 1962,5
		listOfShapesForTest.add(new Square(3.98)); // area = 15,84
		listOfShapesForTest.add(new Square(7.54)); // area = 56,85
		listOfShapesForTest.add(new Square(20.0)); // area = 400
		Collections.sort(listOfShapesForTest);
		return listOfShapesForTest;
	}
	
	// Creates array of Shapes
	private Shape[] shapeArrayCreator(){
		Shape[] arrayOfShapesForTest = new Shape[8];
		arrayOfShapesForTest[0] = new Circle(2.34); // area = 17,19
		arrayOfShapesForTest[1] = new Square(3.0); // area = 9.00
		arrayOfShapesForTest[2] = new Circle(100.0); // area = 31400
		arrayOfShapesForTest[3] = new Square(5.34); // area = 28,52
		arrayOfShapesForTest[4] = new Circle(25.0); // area = 1962,5
		arrayOfShapesForTest[5] = new Square(3.98); // area = 15,84
		arrayOfShapesForTest[6] = new Square(7.54); // area = 56,85
		arrayOfShapesForTest[7] = new Square(20.0); // area = 400
		return arrayOfShapesForTest;
	}
	
	// Creates sorted reference list to for copyLargerTo method
	private List<Shape> referenceShapeListCreator(Shape referenceShape) {
		List<Shape> referenceShapeList = new LinkedList<Shape>();
		for (Iterator <Shape> iterator = shapeListCreator().iterator(); iterator.hasNext();) {
			Shape shape = (Shape) iterator.next();
			if(shape.area() > referenceShape.area())
				referenceShapeList.add(shape);
		}
		return referenceShapeList;
	}
	
	// Verify, that Shape array can be added to ShapeAggregatorImpl list.
	@Test
	public void shapeArrayIsAddedToList(){
		sai.addShapes(shapeArrayCreator());
		assertEquals(shapeListCreator().toString(), sai.sortedShapes().toString());
	}
	
	// Verify, that list of Shapes can be added to ShapeAggregatorImpl list.
	@Test
	public void shapeListIsAddedToList(){
		sai.addShapes(shapeListCreator());
		assertEquals(shapeListCreator().toString(), sai.sortedShapes().toString());
	}
	
	// Verify, that largest shape is found correctly.
	@Test
	public void largestShapeReturned(){
		sai.addShapes(shapeListCreator());
		assertEquals("This is circle with radius 100.0.", sai.max().toString());
	}
	
	// Verify, that smallest shape is found correctly.
	@Test
	public void smallestShapeReturned(){
		sai.addShapes(shapeListCreator());
		assertEquals("This is square with side 3.0.", sai.min().toString());
	}
	
	
 
	// Verify, that all contained Shapes are copied to provided Collection, which are larger than smallestShape
	@Test
	public void copiesLargerThanArgumentShapeToAnotherList(){
		List<Shape> largerShapes = new LinkedList<Shape>();
		Shape referenceShape = new Square(5.39);
		sai.addShapes(shapeListCreator());
		sai.copyLargerTo(referenceShape, largerShapes);
		assertEquals(referenceShapeListCreator(referenceShape).toString(), largerShapes.toString());
	}

	
	// Verify, that total area of list Shape are calculated correctly.
	@Test
	public void correctTotalAreaOfShapesReturned(){
		sai.addShapes(shapeListCreator());
		assertEquals(33907.0,Math.round(sai.totalArea()),0);
	}
	

}
