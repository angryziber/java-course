package net.azib.java.students.t073857.hw4;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Joonas Vali
 */
public class Circle extends Shape{
	double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.pow(radius,2)*Math.PI;
	}

	@Override
	public boolean equals(Object o) {
		if(o.hashCode() == this.hashCode())return true;
		else return false;
	}

	@Override
	public int hashCode() {
		// No idea how to hash correctly...
		return (int)(radius*1000);
	}

	@Override
	public String toString() {
		return "Circle with radius "+radius;
	}

}
