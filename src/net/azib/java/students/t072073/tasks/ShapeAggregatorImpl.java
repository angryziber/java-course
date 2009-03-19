package net.azib.java.students.t072073.tasks;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ShapeAggregatorImpl
 *
 * @author janika
 */
public class ShapeAggregatorImpl implements ShapeAggregator {

	List<Shape> shapesList = new LinkedList<Shape>();
	
	public void addShapes(Shape... shapes) {
		shapesList.addAll(Arrays.asList(shapes));
	}

	public void addShapes(Collection<? extends Shape> shapesCollection) {
		this.shapesList.addAll(shapesCollection);

	}

	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesList) {
		// TODO write implementation

	}

	public void copyTo(Collection<? super Shape> shapesList) {
		// TODO write implementation

	}

	public Shape max() {
		int lastIndex = sortedShapes().size() -1;
		return sortedShapes().get(lastIndex);
	}

	public Shape min() {
		return sortedShapes().get(0);
	}

	public List<? extends Shape> sortedShapes() {
		Collections.sort(shapesList);
		return shapesList;
	}

	public double totalArea() {
		double totalArea = 0;
		while(shapesList.iterator().hasNext()){
			totalArea =+ shapesList.iterator().next().area();
		}
		return totalArea;
	}
}
