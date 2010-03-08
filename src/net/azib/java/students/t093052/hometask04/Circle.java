package net.azib.java.students.t093052.hometask04;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Kostja
 */
public class Circle extends Shape {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Circle)) {
			return false;
		}
		return radius == ((Circle) another).radius;
	}

	@Override
	public int hashCode() {
		return ((Double)radius).hashCode();
	}

	@Override
	public String toString() {
		return "Circle with radius " + radius;
	}

}
