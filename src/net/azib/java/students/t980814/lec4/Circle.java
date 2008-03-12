package net.azib.java.students.t980814.lec4;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author dell
 */
public final class Circle extends Shape {

	private double radius;
	
	/**
	 * 
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return ((o instanceof Circle &&
			    ((Circle)o).getRadius() == radius) ? true : false);
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
		return "Circle with radius of " + radius;  
	}

	public double getRadius() {
		return radius;
	}
	
}
