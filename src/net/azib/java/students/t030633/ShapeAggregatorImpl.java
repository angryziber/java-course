package net.azib.java.students.t030633;

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
 * @author t030633
 */
public class ShapeAggregatorImpl implements ShapeAggregator {

	private List<Shape> list = new LinkedList<Shape>();
	
	public void addShapes(Shape... shapes) {

		list.addAll(Arrays.asList(shapes));
		Collections.sort(list);

	}

	public void addShapes(Collection<? extends Shape> shapesCollection) {
		list.addAll(shapesCollection);
		Collections.sort(list);
	}

	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Shape s : list) {
			if (s.area() > smallestShape.area())
				shapesCollection.add(s);
		}
	}

	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(list);
	}

	public Shape max() {
		return list.get(list.size() - 1);
	}

	public Shape min() {
		return list.get(0);
	}

	public List<? extends Shape> sortedShapes() {
		return list;
	}

	public double totalArea() {
		double total = 0.0;
		for (Shape s : list) {
			total += s.area();
		}
		return total;
	}

}
