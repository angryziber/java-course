package net.azib.java.students.t093759.hometasks.fourth;

import net.azib.java.lessons.collections.Shape;

/**
 * 15.03.11 7:25
 *
 * @author Dionis
 */
public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		if (radius < 0.0) throw new IllegalArgumentException();
		this.radius = radius;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Circle circle = (Circle) o;

		if (Double.compare(circle.radius, radius) != 0) return false;

		return true;
	}

	@Override
	public int hashCode() {
		long temp = radius != +0.0d ? Double.doubleToLongBits(radius) : 0L;
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "Circle with radius " + radius + " and area " + area();
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
}
