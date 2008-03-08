package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Romi
 */
public class Square extends Shape {
	private double side;
	
	public Square() {
	}
	
	public Square(double side){
		this.side = side;
	}
	
	public void setSide(double s){
		side = s;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	@Override
	public double area() {
		return Math.pow(side, 2.0);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Square) 
			return this.side == ((Square)o).side;			
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		return Double.toString(side).hashCode();
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		return Double.toString(side);
	}

}
