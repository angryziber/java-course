package net.azib.java.students.t030656.shape;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author t030656
 */
public class Circle extends Shape{

	private double radius;
	private double area;

	/**
	 * CONSTRUCTOR
	 * 
	 * input int
	 */
	public Circle(double r) {
		radius = r;
		area = Math.PI * r * r;
	}

	@Override
	public double area() {
		
		return area;
	}

	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Circle) {
			Circle compCircle = (Circle) o;
			
			return compCircle.radius == radius;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)radius;
	}

	@Override
	public String toString() {
		return "Type: Circle, radius:" + radius +", area: " + area + ";";
	}

}
