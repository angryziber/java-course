package net.azib.java.students.t093759.hometasks.fourth;

import net.azib.java.lessons.collections.Shape;

/**
 * 15.03.11 9:45
 *
 * @author Dionis
 */
public class Square extends Shape {
	private double sideLength;

	public Square(double sideLength) {
		if (sideLength < 0.0) throw new IllegalArgumentException();
		this.sideLength = sideLength;
	}

	@Override
	public String toString() {
		return "Square with side length " + sideLength + " and area " + area();
	}

	@Override
	public double area() {
		return sideLength * sideLength;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Square square = (Square) o;

		if (Double.compare(square.sideLength, sideLength) != 0) return false;

		return true;
	}

	@Override
	public int hashCode() {
		long temp = sideLength != +0.0d ? Double.doubleToLongBits(sideLength) : 0L;
		return (int) (temp ^ (temp >>> 32));
	}
}
