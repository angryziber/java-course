package net.azib.java.students.t040719.lessons;

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
 * @author Romi
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	
	private List<Shape> shapeList = new LinkedList<Shape>();
	
	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#addShapes(net.azib.java.lessons.collections.Shape[])
	 */
	public void addShapes(Shape... shapes) {
		shapeList.addAll(Arrays.asList(shapes));
		Collections.sort(shapeList);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#addShapes(java.util.Collection)
	 */
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		shapeList.addAll(shapesCollection);
		Collections.sort(shapeList);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#copyLargerTo(net.azib.java.lessons.collections.Shape, java.util.Collection)
	 */
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for (Shape s : shapeList)
			if (s.compareTo(smallestShape) == 1)
				shapesCollection.add(s);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#copyTo(java.util.Collection)
	 */
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(shapeList);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#max()
	 */
	public Shape max() {
		return shapeList.get(shapeList.size()-1);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#min()
	 */
	public Shape min() {
		return shapeList.get(0);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#sortedShapes()
	 */
	public List<? extends Shape> sortedShapes() {
		return Collections.unmodifiableList(shapeList);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#totalArea()
	 */
	public double totalArea() {
		double area = 0;
		for (Shape s : shapeList){
			area += s.area();
		}
		return area;
	}
}
