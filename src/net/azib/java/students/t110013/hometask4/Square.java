package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.collections.Shape;

/**
 * @author Vadim
 */
public class Square extends Shape {
	private double side;

	public Square(double side) {
		if (side < 0)
			throw new IllegalArgumentException("Negative integers are not supported!");

		this.side = side;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Square))
			return false;
		return Double.compare(side, ((Square)o).side) == 0;
	}

	@Override
	public int hashCode() {
		long temp = side != +0.0d ? Double.doubleToLongBits(side) : 0L;
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "Square(side " + side + ", area " + area() + ")";
	}

	@Override
	public double area() {
		return side * side;
	}
}
