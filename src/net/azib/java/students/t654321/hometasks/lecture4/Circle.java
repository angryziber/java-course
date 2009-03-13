/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture4;

import net.azib.java.lessons.collections.Shape;

/**
 *
 * @author karlb
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative!");
        }
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle){
            Circle c = (Circle)o;
            return this.radius == c.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 13 * new Double(this.radius).intValue() + 11;
    }

    @Override
    public String toString() {
        return "This is circle with radius " + this.radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
