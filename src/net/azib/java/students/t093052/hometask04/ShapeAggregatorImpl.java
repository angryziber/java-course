package net.azib.java.students.t093052.hometask04;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ShapeAggregatorImpl
 *
 * @author Kostja
 */
public class ShapeAggregatorImpl extends ArrayList<Shape> implements ShapeAggregator {

	@Override
	public void addShapes(Shape... shapes) {
		addAll(Arrays.asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		addAll(shapesCollection);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, 
			Collection<? super Shape> shapesCollection) {
		for (Shape shape : this) {
			if (shape.compareTo(smallestShape) > 0) {
				shapesCollection.add(shape);
			}
		}
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(this);
	}

	@Override
	public Shape max() {
		Shape max = null;
		
		for (Shape shape : this) {
			if (max == null || shape.compareTo(max) > 0) {
				max = shape;
			}
		}
		return max;
	}

	@Override
	public Shape min() {
		Shape min = null;
		
		for (Shape shape : this) {
			if (min == null || shape.compareTo(min) < 0) {
				min = shape;
			}
		}
		return min;
	}

	@Override
	public List<? extends Shape> sortedShapes() {
		List<Shape> list = new ArrayList<Shape>(this);
		Collections.sort(list);
		return Collections.unmodifiableList(list);
	}

	@Override
	public double totalArea() {
		double total = 0.0;
		
		for (Shape shape : this) {
			total += shape.area();
		}
		
		return total;
	}

}
