package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.*;

public class ShapeAggregatorImpl implements ShapeAggregator{
	List<Shape> internalCollection;

	public ShapeAggregatorImpl() {
		internalCollection = new LinkedList<Shape>();
	}

	@Override
	public void addShapes(Shape... shapes) {
		internalCollection.addAll(Arrays.asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		internalCollection.addAll(shapesCollection);
	}

	@Override
	public Shape min() {
		return Collections.min(internalCollection);
	}

	@Override
	public Shape max() {
		return Collections.max(internalCollection);
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public <T extends Shape> List<T> sortedShapes() {
		final List<T> sortedShape = new LinkedList<T>((Collection<? extends T>) internalCollection);
		Collections.sort(sortedShape);
		return sortedShape;
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
	  	shapesCollection.addAll(internalCollection);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
	   	for (Shape shape : internalCollection) {
			if (shape.compareTo(smallestShape) == 1)
				shapesCollection.add(shape);
		}
	}

	@Override
	public double totalArea() {
		double sum = 0;
		for (Shape shape : internalCollection)
			sum = sum + shape.area();
		return sum;
	}

	public static void main(String[] args) {
	  	ShapeAggregatorImpl aggregator = new ShapeAggregatorImpl();
		aggregator.addShapes(new Square(44),new Circle(33),new Circle(21), new Square(18));
		System.out.println("\nOriginal array");
		for (Shape shape : aggregator.internalCollection) {
			System.out.println(shape.toString());
		}
		System.out.println("\nSorted array");
		for (Shape shape : aggregator.sortedShapes()) {
			System.out.println(shape.toString()+" area: "+shape.area());
		}
	}
}
