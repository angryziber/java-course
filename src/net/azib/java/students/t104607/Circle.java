package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.Shape;

public class Circle extends Shape{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (this.getClass() == o.getClass()) {
			Circle circle = (Circle)o;
			if (this.radius == circle.radius) return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new Double(radius).hashCode();
	}

	@Override
	public String toString() {
		return "Circle with radius " + this.radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
}
