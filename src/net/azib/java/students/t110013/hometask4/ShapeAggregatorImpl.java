package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.*;

/**
 * @author Vadim
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	private List<Shape> shapes = new ArrayList<Shape>();

	@Override
	public void addShapes(Shape... shapes) {
		if (shapes == null)
			throw new IllegalArgumentException("Adding null is not allowed!");

		addShapes(Arrays.asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		if (shapesCollection == null)
			throw new IllegalArgumentException("Adding null is not allowed!");

		shapes.addAll(shapesCollection);
	}

	@Override
	public Shape min() {
		return Collections.min(shapes);
	}

	@Override
	public Shape max() {
		return Collections.max(shapes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Shape> List<T> sortedShapes() {
		Collections.sort(shapes);
		return (List<T>) Collections.unmodifiableList(shapes);
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(shapes);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Shape s : shapes) {
			if (s.compareTo(smallestShape) == 1)
				shapesCollection.add(s);
		}
	}

	@Override
	public double totalArea() {
		double totalArea = 0;
		for (Shape s : shapes) {
			totalArea += s.area();
		}
		return totalArea;
	}
}
