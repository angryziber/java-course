package net.azib.java.students.t092859.hometask5;

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
 * @author kostya
 */
public class ShapeAggregatorImpl implements ShapeAggregator{

	private List<Shape> shapeList = new LinkedList<Shape>();
	
	@Override
	public void addShapes(Shape... shapes) {
		addShapes(Arrays.asList(shapes));
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		shapeList.addAll(shapesCollection);
		Collections.sort(shapeList);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		int nextLargerShape = shapeList.size(); //in case all shapes are smaller
		for(Shape shape : shapeList){
			if(shape.compareTo(smallestShape) == 1){
				nextLargerShape = shapeList.indexOf(shape);
				break;
			}
		}
		shapesCollection.addAll(shapeList.subList(nextLargerShape, shapeList.size()));
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
			shapesCollection.addAll(shapeList);
	}

	@Override
	public Shape max() {
		return shapeList.get(shapeList.size() - 1);
	}

	@Override
	public Shape min() {
		return shapeList.get(0);
	}

	@Override
	public List<? extends Shape> sortedShapes() {
		return Collections.unmodifiableList(shapeList);
	}

	@Override
	public double totalArea() {
		double totalArea = 0;
		for(Shape shape : shapeList)
			totalArea += shape.area();
		return totalArea; 
	}

}
