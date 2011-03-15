package net.azib.java.students.t093759.hometasks.fourth;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.*;

/**
 * 15.03.11 9:50
 *
 * @author Dionis
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	List<Shape> shapeAggregator = new LinkedList<Shape>();

	@Override
	public void addShapes(Shape... shapes) {
		shapeAggregator.addAll(Arrays.asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		shapeAggregator.addAll(shapesCollection);
	}

	@Override
	public Shape min() {
		Shape minShape = null;
		for (Shape shape : shapeAggregator) {
			if (minShape == null)
				minShape = shape;
			else if (shape.area() < minShape.area())
				minShape = shape;
		}

		return minShape;
	}

	@Override
	public Shape max() {
		Shape maxShape = null;
		for (Shape shape : shapeAggregator) {
			if (maxShape == null)
				maxShape = shape;
			else if (shape.area() > maxShape.area())
				maxShape = shape;
		}

		return maxShape;
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public <T extends Shape> List<T> sortedShapes() {
		Collections.sort(shapeAggregator);
		return (List<T>) Collections.unmodifiableList(shapeAggregator);
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(shapeAggregator);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Shape shape : shapeAggregator) {
			if (shape.compareTo(smallestShape) == 1) {
				shapesCollection.add(shape);
			}
		}
	}

	@Override
	public double totalArea() {
		double totalArea = 0.0;
		for (Shape shape : shapeAggregator) {
			totalArea += shape.area();
		}
		return totalArea;
	}

	public static void main(String[] args) {
		ShapeAggregatorImpl aggregator = new ShapeAggregatorImpl();
		Shape[] shapes = {new Circle(1), new Circle(2), new Square(2), new Square(1)};
		aggregator.addShapes(shapes);
		System.out.println("Min shape is " + aggregator.min());
		System.out.println("Max shape is " + aggregator.max());

		System.out.println("Sorting");
		List<Shape> sortedShapes = aggregator.sortedShapes();
		sortedShapes.add(new Circle(1));
		for (Shape shape : sortedShapes) {
			System.out.println(shape);
		}
	}
}
