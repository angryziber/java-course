/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture4;

import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

/**
 *
 * @author karlb
 */
public class ShapeAggregatorImpl implements ShapeAggregator {

    List<Shape> listOfShapes = new LinkedList<Shape>();

    public void addShapes(Shape... shapes) {
        listOfShapes.addAll(Arrays.asList(shapes));
    }

    public void addShapes(Collection<? extends Shape> shapesCollection) {
        listOfShapes.addAll(shapesCollection);
    }

    public Shape min() {
        return Collections.min(listOfShapes);
    }

    public Shape max() {
        return Collections.max(listOfShapes);
    }

    public List<? extends Shape> sortedShapes() {
        Collections.sort(listOfShapes);
        return listOfShapes;
    }

    public void copyTo(Collection<? super Shape> shapesCollection) {
        shapesCollection.addAll(listOfShapes);
    }

    public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
        for (Shape shape : listOfShapes) {
            if(shape.area() > smallestShape.area()){
                shapesCollection.add(shape);
            }
        }
    }

    public double totalArea() {
        double totalAreaOfShapes = 0;
        for (Shape shape : listOfShapes) {
            totalAreaOfShapes += shape.area();
        }
        return totalAreaOfShapes;
    }
}
