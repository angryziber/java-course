package net.azib.java.students.t001370.lectures.lec4.home;

import net.azib.java.lessons.collections.Shape;
/**
 * Circle
 *
 * @author maksim
 */
public class Circle extends Shape {
	final double PI = 3.14;
	int radius;
	
	Circle(int r){
		this.radius = r;
	}

	@Override
	public double area() {
		return radius*radius*PI;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		return this.radius;
	}

	@Override
	public String toString() {
		return "This shape is a Circle with: r = " + this.radius + 
				" and S = " + this.area();
	}
	
}
