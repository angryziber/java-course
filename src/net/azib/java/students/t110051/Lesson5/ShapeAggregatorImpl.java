package net.azib.java.students.t110051.Lesson5;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.*;

public class ShapeAggregatorImpl implements ShapeAggregator{
	List<Shape> internalCollection = new ArrayList<Shape>();

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

	@Override
	public <T extends Shape> List<T> sortedShapes() {

		return sortedShapes();
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {

	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {

	}

	@Override
	public double totalArea() {
		double sum = 0;
		for (Shape shape : internalCollection )
			sum = sum + shape.area();
		return sum;
	}
}
