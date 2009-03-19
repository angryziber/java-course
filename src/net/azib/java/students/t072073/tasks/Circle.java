package net.azib.java.students.t072073.tasks;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author janika
 */
public class Circle extends Shape {

	private final double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	
	@Override
	public double area() {
		return (Math.pow(radius, 2)* Math.PI)/2;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle){
			Circle that = (Circle)o;
			return this.area() == that.area();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new Double(area()).intValue() ;
	}

	@Override
	public String toString() {
		return "Circle with radius " + String.valueOf(radius);
	}

}
