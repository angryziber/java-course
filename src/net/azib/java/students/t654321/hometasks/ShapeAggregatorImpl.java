package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * ShapeAggregatorImpl
 *
 * @author Karl
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	
	private List<Shape> listOfShapes = new LinkedList<Shape>();
	
	public void addShapes(Shape... shapes) {
		for (int i = 0; i < shapes.length; i++) {
			listOfShapes.add(shapes[i]);
		}
	}

	public void addShapes(Collection<? extends Shape> shapesCollection) {
		listOfShapes.addAll(shapesCollection);
	}

	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Iterator<Shape> shapeIterator = listOfShapes.iterator(); shapeIterator.hasNext();) {
			Shape shapeObject = (Shape) shapeIterator.next();
			if (shapeObject.area() > smallestShape.area()){
				shapesCollection.add(shapeObject);
			}	
		}
	}

	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(listOfShapes);
	}

	public Shape max() {
		return listOfShapes.get(listOfShapes.size() - 1);	}

	public Shape min() {
		return listOfShapes.get(0);
	}

	public List<? extends Shape> sortedShapes() {
		Collections.sort(listOfShapes);
		return Collections.unmodifiableList(listOfShapes);
	}

	public double totalArea() {
		double totalArea = 0;
		for (Iterator<Shape> shapeIterator = listOfShapes.iterator(); shapeIterator.hasNext();) {
 			totalArea = totalArea + shapeIterator.next().area();
		}
		return totalArea;
	}
}
