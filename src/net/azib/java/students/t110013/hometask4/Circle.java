package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.collections.Shape;

/**
 * Author: Vadim
 * Date: 23.03.11
 * Time: 16:59
 */
public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Square))
			return false;
		return Double.compare(radius, ((Circle)o).radius) == 0;
	}

	@Override
	public int hashCode() {
		long temp = radius != +0.0d ? Double.doubleToLongBits(radius) : 0L;
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "Circle(radius " + radius + ", area " + area() + ", circumference " + 2 * Math.PI * radius + ")";
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
}
