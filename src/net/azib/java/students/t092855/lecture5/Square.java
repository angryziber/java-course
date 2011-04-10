package net.azib.java.students.t092855.lecture5;


import net.azib.java.lessons.collections.Shape;

public class Square extends Shape {
	private double side;

	public Square(double sideLength) {
		if (sideLength >= 0.0)
			side = sideLength;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		Square square = (Square)o;
		if (Double.compare(this.side, square.side) == 0) return true;
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * new Double(side).hashCode();
	}

	@Override
	public String toString() {
		return "Square with side length of " + side + " and area of " + area();
	}

	@Override
	public double area() {
		return side*side;
	}
}
