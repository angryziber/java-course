package net.azib.java.students.t104971.generics.shapes;

import net.azib.java.lessons.collections.Shape;

/**
 * @author Jaroslav
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass().equals(Circle.class) ? radius == ((Circle) o).radius : false;
    }

    @Override
    public int hashCode() {
        long temp = radius != +0.0d ? Double.doubleToLongBits(radius) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " radius = " + radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
