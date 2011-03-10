package net.azib.java.lessons.collections;

import java.util.Collection;
import java.util.List;

/**
 * Aggregator of Shapes.
 * Used in the 5th lesson - Generics.
 * 
 * @author anton
 */
public interface ShapeAggregator {
	
	/**
	 * Adds all passed Shapes to the aggregator
	 * @param shapes
	 */
	public void addShapes(Shape ... shapes);
	
	/**
	 * Adds many shapes to the aggregator
	 * @param shapesCollection
	 */
	public void addShapes(Collection<? extends Shape> shapesCollection);

	/**
	 * @return the smallest Shape
	 */
	public Shape min();
	
	/**
	 * @return the largest Shape
	 */
	public Shape max();

	/**
	 * @return all contained Shapes in natural sorted order
	 * The returned List is unmodifiable.
	 */
	public <T extends Shape> List<T> sortedShapes();
	
	/**
	 * Copies all contained Shapes to the provided Collection
	 * @param shapesCollection the Collection, where to copy Shapes
	 */
	public void copyTo(Collection<? super Shape> shapesCollection);
	
	/**
	 * Copies all contained Shapes, which are larger than smallestShape to the provided Collection
	 * @param smallestShape only Shapes larger than this one should be copied
	 * @param shapesCollection the Collection, where to copy Shapes
	 */
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection);
	
	/**
	 * @return the total area of all Shapes (sum of all areas)
	 */
	public double totalArea();
	
}
