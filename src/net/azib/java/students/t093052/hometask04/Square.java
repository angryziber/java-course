package net.azib.java.students.t093052.hometask04;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Kostja
 */
public class Square extends Shape {
	private double side;
	
	public Square(double side) {
		this.side = side;
	}
	
	@Override
	public double area() {
		return side * side;
	}

	@Override
	public boolean equals(Object another) {
		if (another == null || !(another instanceof Square)) {
			return false;
		}
		return side == ((Square) another).side;
	}

	@Override
	public int hashCode() {
		return new Double(side).hashCode();
	}

	@Override
	public String toString() {
		return "Square with side " + side;
	}

}
