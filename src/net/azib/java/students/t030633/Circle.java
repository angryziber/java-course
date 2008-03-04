package net.azib.java.students.t030633;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 * 
 * @author t030633
 */
public class Circle extends Shape {

	private double r; // radius

	public Circle() {
	}

	public Circle(double radius) {
		r = radius;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(r, 2);
	}

	@Override
	public boolean equals(Object o) {
		return this == o;
	}

	@Override
	public int hashCode() {
		return (int) r;
	}

	@Override
	public String toString() {
		return Double.toString(r);
	}

	public void setRadius(double radius) {
		r = radius;
	}

}
