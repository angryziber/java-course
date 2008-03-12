package net.azib.java.students.t980814.lec4;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * ShapeAggregatorImpl
 *
 * @author dell
 */
public class ShapeAggregatorImpl implements ShapeAggregator {

	private TreeSet<Shape> setOfShapes;
	
	/**
	 * 
	 */
	public ShapeAggregatorImpl() {
		setOfShapes = new TreeSet<Shape>();
	}

	public ShapeAggregatorImpl(Shape... shapes) {
		setOfShapes = new TreeSet<Shape>(Arrays.asList(shapes));
	}
	
	public ShapeAggregatorImpl(Collection<? extends Shape> shapesCollection) {
		setOfShapes = new TreeSet<Shape>(shapesCollection);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#addShapes(net.azib.java.lessons.collections.Shape[])
	 */
	public void addShapes(Shape... shapes) {
		setOfShapes.addAll(Arrays.asList(shapes));
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#addShapes(java.util.Collection)
	 */
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		setOfShapes.addAll(shapesCollection);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#copyLargerTo(net.azib.java.lessons.collections.Shape, java.util.Collection)
	 */
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(setOfShapes.tailSet(smallestShape));		
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#copyTo(java.util.Collection)
	 */
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(setOfShapes);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#max()
	 */
	public Shape max() {
		return setOfShapes.last();
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#min()
	 */
	public Shape min() {
		return setOfShapes.first();
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#sortedShapes()
	 */
	public List<? extends Shape> sortedShapes() {
		return new LinkedList<Shape>(setOfShapes);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.ShapeAggregator#totalArea()
	 */
	public double totalArea() {
		double area = 0.0;
		for (Shape s : setOfShapes)
			area += s.area();
		return area;
	}

}
