package net.azib.java.students.t030630;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 * 
 * @author Kasutaja
 */
public class Circle extends Shape {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */

	private double r;

	public Circle(double r) {
		super();
		this.r = r;
	}

	@Override
	public double area() {
		return (r * r * Math.PI);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle)
			if (this.r == ((Circle) o).getR())
				return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int)r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("It is a circle with radius equals " + r);
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

}
