package net.azib.java.students.t110051.Lesson5;

import net.azib.java.lessons.collections.Shape;

public class Circle extends Shape{
	 private final double radius;

	public Circle ( final double radius){
		if (radius <= 0) throw new IllegalArgumentException("Circle radius cannot be 0 or negative");
		this.radius = radius;

	}
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (this != o) return false;
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
		return Math.PI * radius*radius;
	}
}
