package net.azib.java.students.t104971.generics.shapes;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.*;

/**
 * @author Jaroslav
 */
public class ShapeAggregatorImpl implements ShapeAggregator {

    private List<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void addShapes(Shape... shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

    @Override
    public void addShapes(Collection<? extends Shape> shapesCollection) {
        this.shapes.addAll(shapes);
    }

    @Override
    public Shape min() {
        return Collections.min(shapes);
    }

    @Override
    public Shape max() {
        return Collections.max(shapes);
    }

    @Override
    public <T extends Shape> List<T> sortedShapes() {
        Collections.sort(shapes);
        return (List<T>) this.shapes;
    }

    @Override
    public void copyTo(Collection<? super Shape> shapesCollection) {
        shapesCollection.addAll(shapes);
    }

    @Override
    public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
        shapesCollection.add(smallestShape);
        shapesCollection.addAll(shapes);
    }

    @Override
    public double totalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }

}
