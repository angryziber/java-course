package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.collections.Shape;

/**
 * Author: Vadim
 * Date: 23.03.11
 * Time: 13:31
 */
public class Square extends Shape {
	private double side;

	public Square(double sideLength) {
		this.side = sideLength;
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
