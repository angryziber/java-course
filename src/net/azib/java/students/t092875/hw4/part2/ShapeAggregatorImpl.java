package net.azib.java.students.t092875.hw4.part2;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * ShapeAggregatorImpl
 *
 * @author Mihhail
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	ArrayList<Shape> shapeList = new ArrayList<Shape>();
	@Override
	public void addShapes(Shape... shapes) {
		for (Shape shape : shapes) {
			shapeList.add(shape);
		}
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		Iterator<? extends Shape> i = (Iterator<? extends Shape>) shapesCollection.iterator();
		while (i.hasNext()) {
			shapeList.add(i.next());
		}
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		Iterator<Shape> i = shapeList.iterator();
		while (i.hasNext()) {
			if(smallestShape.compareTo(i.next())<0){
				shapesCollection.add(i.next());
			}
		}
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		// TODO Auto-generated method stub
		Iterator<Shape> i = shapeList.iterator();
		while (i.hasNext()) {
			shapesCollection.add(i.next());
		}
	}

	@Override
	public Shape max() {
		Shape[] shapes = shapeList.toArray(new Shape[shapeList.size()]);
		Arrays.sort(shapes);
		return shapes[shapes.length-1];
	}

	@Override
	public Shape min() {
		Shape[] shapes = shapeList.toArray(new Shape[shapeList.size()]);
		Arrays.sort(shapes);
		return shapes[0];
	}

	@Override
	public List<? extends Shape> sortedShapes() {
		List<? extends Shape> list = (List<? extends Shape>) shapeList;
		Collections.sort(list);
		return Collections.unmodifiableList(list);
	}

	@Override
	public double totalArea() {
		double totalArea = 0;
		Iterator<Shape> i = shapeList.iterator();
		while (i.hasNext()) {
			totalArea += i.next().area();
		}
		return totalArea;
	}

}
