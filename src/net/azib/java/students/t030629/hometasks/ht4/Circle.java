package net.azib.java.students.t030629.hometasks.ht4;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author anton_chepurov
 */
public class Circle extends Shape {
	
	private final double radius;
	
	public Circle(){
		radius = 0;
	}
	public Circle(double radius){
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public boolean equals(Object that) {
		return that instanceof Circle && Double.valueOf(radius).equals(((Circle)that).radius);
	}

	@Override
	public int hashCode() {
		return Double.valueOf(radius).hashCode();
	}

	@Override
	public String toString() {
		return "Circle with radius " + radius;
	}
	
	@Override
	public Circle clone(){
		return (Circle) super.clone();
	}

}
