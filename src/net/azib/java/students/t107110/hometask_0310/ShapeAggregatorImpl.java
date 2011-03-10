package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class ShapeAggregatorImpl implements ShapeAggregator {
	private List<Shape> shapes = new ArrayList<Shape>();

	@Override
	public void addShapes(final Shape... shapes) {
		addShapes(asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		shapes.addAll(shapesCollection);
	}

	@Override
	public Shape min() {
		Shape smallestShape = null;
		for (Shape shape : shapes) {
			if (smallestShape == null || smallestShape.area() > shape.area()) {
				smallestShape = shape;
			}
		}
		return smallestShape;
	}

	@Override
	public Shape max() {
		Shape biggestShape = null;
		for (Shape shape : shapes) {
			if (biggestShape == null || biggestShape.area() < shape.area()) {
				biggestShape = shape;
			}
		}
		return biggestShape;
	}

	@Override
	public List<? extends Shape> sortedShapes() {
		final List<Shape> sortedShapes = new ArrayList<Shape>(shapes);
		Collections.sort(sortedShapes);
		return Collections.unmodifiableList(sortedShapes);
	}

	@Override
	public void copyTo(final Collection<? super Shape> shapesCollection) {
		shapesCollection.clear();
		shapesCollection.addAll(shapes);
	}

	@Override
	public void copyLargerTo(final Shape smallestShape, final Collection<? super Shape> shapesCollection) {
		shapesCollection.clear();
		for (final Shape shape : shapes) {
			if (shape.area() > smallestShape.area()) {
				shapesCollection.add(shape);
			}
		}
	}

	@Override
	public double totalArea() {
		double totalArea = 0;
		for (final Shape shape : shapes) {
			totalArea += shape.area();
		}
		return totalArea;
	}

	public static void main(final String[] args) {
		final ShapeAggregator shapes = new ShapeAggregatorImpl();
		shapes.addShapes(new Circle(2), new Square(2), new Circle(1), new Square(1), new Square(3));

		System.out.println("the smallest shape is " + shapes.min());
		System.out.println("the biggest shape is " + shapes.max());
		System.out.println("total area is " + shapes.totalArea());

		System.out.println();
		System.out.println("sorted shapes:");
		for (final Shape shape : shapes.sortedShapes()) {
			System.out.println(shape);
		}

		System.out.println();
		System.out.println("copied shapes:");
		final List<Shape> copyShapes = new ArrayList<Shape>();
		shapes.copyTo(copyShapes);
		for (final Shape shape : copyShapes) {
			System.out.println(shape);
		}

		final Shape thresholdShape = new Circle(1);
		System.out.println();
		System.out.println("shapes larger than " + thresholdShape + ':');
		final List<Shape> largeShapes = new ArrayList<Shape>();
		shapes.copyLargerTo(thresholdShape, largeShapes);
		for (final Shape shape : largeShapes) {
			System.out.println(shape);
		}
	}
}
