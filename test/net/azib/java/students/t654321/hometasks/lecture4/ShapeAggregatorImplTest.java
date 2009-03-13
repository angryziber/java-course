/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture4;

import java.util.LinkedList;
import java.util.List;
import net.azib.java.lessons.collections.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karlb
 */
public class ShapeAggregatorImplTest {

    ShapeAggregatorImpl sai = new ShapeAggregatorImpl();
    
    private List<Shape> createreferanceListOfShapes() {

        List<Shape> shapes = new LinkedList<Shape>();
        shapes.add(new Circle(20.0));
        shapes.add(new Circle(21.0));
        shapes.add(new Circle(22.0));
        shapes.add(new Circle(23.0));
        shapes.add(new Circle(24.0));
        return shapes;
    }

    private Shape[] createreferanceArrayOfShapes() {
        return new Shape[] {new Circle(20.0),new Circle(21.0),new Circle(22.0), new Circle(23.0), new Circle(24.0)};
    }

    @Test
    public void addShapeArray(){
        sai.addShapes(createreferanceArrayOfShapes());
        assertEquals(createreferanceListOfShapes(), sai.listOfShapes);
    }

    @Test
    public void addShapeCollection(){
        sai.addShapes(createreferanceListOfShapes());
        assertEquals(createreferanceListOfShapes(), sai.listOfShapes);
    }

    @Test
    public void smallestShape(){
        Shape smallestShape = new Circle(20.0);
        sai.addShapes(createreferanceListOfShapes());
        assertEquals(smallestShape, sai.min());
    }

    @Test
    public void largestShape(){
        Shape smallestShape = new Circle(24.0);
        sai.addShapes(createreferanceListOfShapes());
        assertEquals(smallestShape, sai.max());
    }
    
    @Test
    public void copyingShapes(){
        List<Shape> shapes = new LinkedList<Shape>();
        sai.addShapes(createreferanceListOfShapes());
        sai.copyTo(shapes);
        assertEquals(createreferanceListOfShapes(), shapes);
    }

    @Test
    public void copyingLargerShapes(){
        Shape refShape = new Circle(21.0);
        List<Shape> largerShapes = new LinkedList<Shape>();
        largerShapes.add(new Circle(22.0));
        largerShapes.add(new Circle(23.0));
        largerShapes.add(new Circle(24.0));

        List<Shape> shapes = new LinkedList<Shape>();

        sai.addShapes(createreferanceListOfShapes());
        sai.copyLargerTo(refShape, shapes);

        assertEquals(largerShapes, shapes);
    }

    @Test
    public void calculateTotalArea(){
        double refTotalArea = 7634.070148;
        sai.addShapes(createreferanceListOfShapes());
        assertEquals(refTotalArea, sai.totalArea(), 0.00001);
    }



}