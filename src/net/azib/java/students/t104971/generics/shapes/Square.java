package net.azib.java.students.t104971.generics.shapes;

import net.azib.java.lessons.collections.Shape;

/**
 * @author Jaroslav
 */
public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass().equals(Square.class) ? side == ((Square) o).side : false;
    }

    @Override
    public int hashCode() {
        long temp = side != +0.0d ? Double.doubleToLongBits(side) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " side = " + side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
