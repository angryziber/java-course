package net.azib.java.students.t030636.v_05;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Martin
 */
public class Square extends Shape {
	private double side;

	public Square (double side) {
		
	}
	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	@Override
	public double area() {
		double ar = Math.pow(side, 2);
		return ar;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Square) {
			Square compSq = (Square) o;
			return compSq.side == this.side;
		}
		else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) side;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		return "This is a square with an area of " + Double.toString(side) + " square meters"; 
	}

}
