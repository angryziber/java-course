package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class ShapeAggregatorImpl implements ShapeAggregator {
	private final Collection<Shape> shapes = new ArrayList<Shape>();

	@Override
	public void addShapes(final Shape... shapes) {
		if (shapes == null) throw new IllegalArgumentException("can't add null shape list");

		addShapes(asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapes) {
		if (shapes == null) throw new IllegalArgumentException("can't add null shape collection");

		this.shapes.addAll(shapes);
	}

	@Override
	public Shape min() {
		return Collections.min(shapes);
	}

	@Override
	public Shape max() {
		return Collections.max(shapes);
	}

	@Override
	public List<Shape> sortedShapes() {
		final List<Shape> copyOfShapes = new ArrayList<Shape>(shapes);
		Collections.sort(copyOfShapes);
		return Collections.unmodifiableList(copyOfShapes);
	}

	@Override
	public void copyTo(final Collection<? super Shape> shapesCollection) {
		shapesCollection.clear();
		shapesCollection.addAll(shapes);
	}

	@Override
	public void copyLargerTo(final Shape smallestShape, final Collection<? super Shape> shapesCollection) {
		shapesCollection.clear();
		for (final Shape shape : shapes)
			if (shape.compareTo(smallestShape) > 0) shapesCollection.add(shape);
	}

	@Override
	public double totalArea() {
		double totalArea = 0;
		for (final Shape shape : shapes)
			totalArea += shape.area();
		return totalArea;
	}
}
