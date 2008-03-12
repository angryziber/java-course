package net.azib.java.students.t980814.lec4;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author dell
 */
public final class Square extends Shape {

	private double sideLength;
	
	/**
	 * 
	 */
	public Square(double sideLength) {
		this.sideLength = Math.abs(sideLength);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	@Override
	public double area() {
		return sideLength * sideLength;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return ((o instanceof Shape &&
			    ((Square)o).getSideLength() == sideLength) ? true : false);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		return "Square with side length of " + sideLength;  
	}

	public double getSideLength() {
		return sideLength;
	}
}
