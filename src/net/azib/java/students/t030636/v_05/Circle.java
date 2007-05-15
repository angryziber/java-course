package net.azib.java.students.t030636.v_05;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Martin
 */
public class Circle extends Shape {
	private double radius;
	
	Circle (double radius){
		
	}
	@Override
	public double area() {
		double area = Math.PI * Math.pow(radius, 2);
		
		return area;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle) {
			Circle compCi = (Circle) o;
			return compCi.radius == this.radius;
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
		return (int) radius;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle - radius " + Double.toString(radius) + " meters";
	}

}
