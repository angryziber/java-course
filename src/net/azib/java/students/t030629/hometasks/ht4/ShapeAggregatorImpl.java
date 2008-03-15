package net.azib.java.students.t030629.hometasks.ht4;

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
 * @author anton_chepurov
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	
	private List<Shape> shapes;
	
	public ShapeAggregatorImpl(){
		// Both insertion and iteration should be 
		// effective, so LinkedList is preferred
		shapes = new LinkedList<Shape>();
	}

	public void addShapes(Shape... shapes) {
		this.shapes.addAll(Arrays.asList(shapes));
	}

	public void addShapes(Collection<? extends Shape> shapesCollection) {
		this.shapes.addAll(shapesCollection);
	}

	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Shape shape : shapes){
			if (shape.compareTo(smallestShape) > 0){
				shapesCollection.add(((Square)shape).clone()); //todo: change to "shape.clone()"
			}
		}
	}

	public void copyTo(Collection<? super Shape> shapesCollection) {
		List<Shape> newList = new LinkedList<Shape>();
		Collections.copy(newList, shapes);
		shapesCollection.addAll(newList);
	}

	public Shape max() {
		return Collections.max(shapes);
	}

	public Shape min() {
		return Collections.min(shapes);
	}

	public List<? extends Shape> sortedShapes() {
		Collections.sort(shapes);
		return Collections.unmodifiableList(shapes);
	}

	public double totalArea() {
		double totalArea = 0;
		for (Shape shape : shapes){
			totalArea += shape.area();
		}
		return totalArea;
	}

}
