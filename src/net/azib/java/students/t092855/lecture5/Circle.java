package net.azib.java.students.t092855.lecture5;

import net.azib.java.lessons.collections.Shape;

public class Circle extends Shape {
	private double radius;

	public Circle (double radius) {
		if (radius >= 0.0)
			this.radius = radius;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		Circle circle = (Circle)o;
		if (Double.compare(this.radius, circle.radius) == 0) return true;
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * new Double(radius).hashCode();
	}

	@Override
	public String toString() {
		return "Circle with radius of " + radius + " and area of " + area();
	}

	@Override
	public double area() {
		return Math.PI * (radius * radius);
	}
}
