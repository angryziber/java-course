package net.azib.java.students.t092859.hometask5;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author kostya
 */
public class Circle extends Shape{
	private final double radius;

	/**
	 * @param radius - radius of circle
	 */
	public Circle(double radius){
		super();
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if ((o != null) && (o.getClass().equals(this.getClass()))){
			return radius == ((Circle)o).radius;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Double.toHexString(radius).hashCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

}
