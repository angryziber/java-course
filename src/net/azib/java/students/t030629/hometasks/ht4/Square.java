package net.azib.java.students.t030629.hometasks.ht4;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author anton_chepurov
 */
public class Square extends Shape {
	
	private final double side;
	
	public Square(double side){
		this.side = side;
	}

	@Override
	public double area() {
		return side * side;
	}

	@Override
	public boolean equals(Object that) {
		return that instanceof Square && Double.valueOf(side).equals(((Square)that).side);
	}

	@Override
	public int hashCode() {
		return Double.valueOf(side).hashCode();
	}

	@Override
	public String toString() {
		return "Square with side " + side;
	}

}
