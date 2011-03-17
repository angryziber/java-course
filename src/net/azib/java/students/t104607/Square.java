package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.collections.Shape;

public class Square extends Shape{
	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this == o) return true;
		if (this.getClass() == o.getClass()) {
			Square square = (Square)o;
			if (this.side == square.side) return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new Double(side).hashCode();
	}

	@Override
	public String toString() {
		return "Square with side length " + this.side;
	}

	@Override
	public double area() {
		return this.side * this.side;
	}
}
