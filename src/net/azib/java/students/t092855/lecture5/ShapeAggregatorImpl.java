package net.azib.java.students.t092855.lecture5;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.*;

public class ShapeAggregatorImpl implements ShapeAggregator {
	private List<Shape> listOfShapes = new LinkedList<Shape>();

	@Override
	public void addShapes(Shape... shapes) {
		listOfShapes.addAll(Arrays.asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
	    listOfShapes.addAll(shapesCollection);
	}

	@Override
	public Shape min() {
		return Collections.min(listOfShapes);
	}

	@Override
	public Shape max() {
		return Collections.max(listOfShapes);
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public <T extends Shape> List<T> sortedShapes() {
		Collections.sort(listOfShapes);
		return (List<T>) listOfShapes;
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(listOfShapes);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Shape s : listOfShapes) {
			if (s.compareTo(smallestShape) > 0)
				shapesCollection.add(s);
		}
	}

	@Override
	public double totalArea() {
		double result = 0.0;
		for (Shape s : listOfShapes){
			result += s.area();
		}
		return result;
	}

	@SuppressWarnings({"unchecked"})
	public <T extends Shape> List<T> getShapes() {
		return (List<T>) listOfShapes;
	}
}
