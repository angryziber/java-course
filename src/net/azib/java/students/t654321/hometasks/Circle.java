package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Karl
 */
public class Circle extends Shape {

	private double radius;
	private static final int HASH_PRIME = 113;
	
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle & this.radius == ((Circle)o).radius) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return HASH_PRIME * Double.toString(radius).hashCode();
	}

	@Override
	public String toString() {
		return "This is circle with radius" + this.radius + ".";
	}

}
