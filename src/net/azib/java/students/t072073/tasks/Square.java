package net.azib.java.students.t072073.tasks;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author janika
 */
public class Square extends Shape {

	protected final double width;
	
	public Square(double width){
		this.width = width;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}


	@Override
	public double area() {
		return Math.pow(width, 2);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Square){
			Square that = (Square)o;
			return this.area() == that.area();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new Double(area()).intValue() ;
	}

	@Override
	public String toString() {
		return "Square with width " + String.valueOf(width);
	}
}
