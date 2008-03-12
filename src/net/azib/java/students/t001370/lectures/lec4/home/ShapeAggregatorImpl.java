package net.azib.java.students.t001370.lectures.lec4.home;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * ShapeAgregatorImpl
 *
 * @author maksim
 */
public class ShapeAggregatorImpl implements ShapeAggregator{
	TreeSet<Shape> shapeAggrCollection = new TreeSet<Shape>();

	public void addShapes(Collection<? extends Shape> shapesCollection) {
		shapeAggrCollection.addAll(shapesCollection);
	}

	public void addShapes(Shape... shapes) {
		shapeAggrCollection.addAll(Arrays.asList(shapes));
		/*for (Shape shape : shapes) {
			shapeAggrCollection.add(shape);
		}*/
	}

	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		shapesCollection = shapeAggrCollection.tailSet(smallestShape);
		/*for (Shape shape : shapeAggrCollection) {
			if (smallestShape.compareTo(shape) > 0){
				shapesCollection.add(shape);
			}
		}*/
	}

	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(shapeAggrCollection);
	}

	public Shape max() {
		return shapeAggrCollection.last();
	}

	public Shape min() {
		return shapeAggrCollection.first();
	}

	public List<? extends Shape> sortedShapes() {
		List<Shape> retList = new ArrayList<Shape>();
		retList.addAll(shapeAggrCollection);
		return retList;
	}

	public double totalArea() {
		double returnTotalArea = 0;
		for (Shape shape : shapeAggrCollection) {
			returnTotalArea += shape.area();
		}
	
		return returnTotalArea;
	}
	
	public static void main(String[] args){
		ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
		Shape[] shapes = new Shape[]{new Square(3), 
									 new Circle(1),
									 new Square(2), 
									 new Circle(3), 
									 new Circle(5), 
									 new Square(4)};
		
		sai.addShapes(shapes);
		System.out.println("===== Added shapes are =====");
		for (Shape shape : shapes) {
			System.out.println(shape);
		}

		System.out.println("============================");
		System.out.println("Min shape is: " + sai.min());
		System.out.println("Max shape is: " + sai.max());
		System.out.println("Total area of all shapes is: " + sai.totalArea());
		
		System.out.println("===== Sorted shapes are ====");
		for (Shape shape : sai.sortedShapes()) {
			System.out.println(shape);
		}
		System.out.println("============================");
	}
}
