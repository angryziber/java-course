package net.azib.java.students.t020544.hometasks.task04;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 * 
 * @author Julija Kondratjeva
 */
public class Circle extends Shape {

	private double radius;

	/**
	 * 
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/**
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		return Double.valueOf(radius).equals(((Circle) o).radius);

	}

	@Override
	public int hashCode() {
		return Double.valueOf(radius).hashCode();
	}

	@Override
	public String toString() {
		return "Created circle with area: " + area() + " and hashCode(): " + hashCode();
	}

}
