package net.azib.java.students.t030633;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 * 
 * @author t030633
 */
public class Square extends Shape {

	private double s; // side

	public Square() {
	}

	public Square(double side) {
		s = side;
	}

	@Override
	public double area() {
		return Math.pow(s, 2);
	}

	@Override
	public boolean equals(Object o) {
		return this == o;
	}

	@Override
	public int hashCode() {
		return (int)s;
	}

	@Override
	public String toString() {
		return Double.toString(s);
	}

	public void setSide(double side) {
		s = side;
	}
}
