package net.azib.java.students.t110051.Lesson5;

import net.azib.java.lessons.collections.Shape;

public class Square extends Shape{
	private final double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public boolean equals(Object o) {
		if( o == null) return false;
		if (this == o) return true;
		return false;
	}

	@Override
	public int hashCode() {
		return new Double(side).hashCode();
	}

	@Override
	public String toString() {
		return "Square with a side" + side;
	}

	@Override
	public double area() {
		return side*side;
	}
}
