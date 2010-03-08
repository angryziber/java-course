package net.azib.java.students.t073857.hw4;

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
 * @author Joonas Vali
 */
public class ShapeAggregatorImpl implements ShapeAggregator{
	
	Collection<Shape> aggregator = new ArrayList<Shape>();
	
	@Override
	public void addShapes(Shape... shapes) {
		aggregator.addAll(Arrays.asList(shapes));		
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		aggregator.addAll(shapesCollection);		
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for(Shape s: aggregator){
			if(s.compareTo(smallestShape) == 1) shapesCollection.add(s);
		}		
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {		
		shapesCollection.addAll(aggregator);
	}

	@Override
	public Shape max() {
		return Collections.max(aggregator);
	}

	@Override
	public Shape min() {
		return Collections.min(aggregator);
	}

	@Override
	public List<? extends Shape> sortedShapes() {		
		List<Shape> list = new ArrayList<Shape>(aggregator);
		Collections.sort(list);
		return (List<Shape>) Collections.unmodifiableList(list);		
	}

	@Override
	public double totalArea() {
		double sum=0;
		for(Shape s : aggregator){
			sum += s.area();
		}
		return sum;
	}

}
