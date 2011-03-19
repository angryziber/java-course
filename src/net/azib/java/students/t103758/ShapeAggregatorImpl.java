package net.azib.java.students.t103758;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;
import static java.util.Arrays.asList;

public class ShapeAggregatorImpl implements ShapeAggregator{
  private Collection<Shape> shapes = new TreeSet<Shape>();
  
  public static void main (String[] args) {
    /*
     * Siit vaja jätkata testimist
     * */

  }

  @Override
  public void addShapes (Shape... shapes) {
    addShapes(asList(shapes));
  }

  @Override
  public void addShapes (Collection<? extends Shape> shapesCollection) {
    shapes.addAll(shapesCollection);    
  }

  @Override
  public Shape min () {
    return Collections.min(shapes);
  }

  @Override
  public Shape max () {
    return Collections.max(shapes);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<? extends Shape> sortedShapes () {
    return Collections.unmodifiableList(new LinkedList<Shape>(shapes));
  }

  @Override
  public void copyTo (Collection<? super Shape> shapesCollection) {
    shapesCollection.clear();
    shapesCollection.addAll(shapes);    
  }

  @Override
  public void copyLargerTo (Shape smallestShape,
      Collection<? super Shape> shapesCollection) {
    shapesCollection.clear();
    for (Shape shape : shapes) {
      if (shape.area() > smallestShape.area())
        shapesCollection.add(shape);
    }
  }

  @Override
  public double totalArea () {
    double totalArea = 0;
      for (Shape shape : shapes) {
        totalArea += shape.area();
      }
    return totalArea;
  }

}
