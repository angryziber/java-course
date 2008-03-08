package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Romi
 */
public class Circle extends Shape {
	private double radius;
	
	public Circle(){
	}
	
	public Circle(double radius){
		this.radius=radius;
	}
	
	public void setRadius(double r){
		radius = r;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */	
	@Override
	public double area() {
		return Math.PI*Math.pow(radius, 2.0);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle) 
			return this.radius == ((Circle)o).radius;			
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		return Double.toString(radius).hashCode();
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		return Double.toString(radius);
	}

}
