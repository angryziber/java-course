package net.azib.java.students.t001370.lectures.lec4.home;

import net.azib.java.lessons.collections.Shape;
/**
 * Circle
 *
 * @author maksim
 */
public class Circle extends Shape {
	final double PI = 3.1415926535897932384626433832795;
	int radius;
	
	Circle(int r){
		this.radius = r;
	}

	public int getRadius(){
		return radius;
	}
	
	@Override
	public double area() {
		return radius*radius*PI;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) 
			return false;
		else if (o == this)
			return true;
		else if (o.getClass() != this.getClass()) 
			return false;
		else if (((Circle)o).getRadius() == this.radius &&
				 ((Circle)o).area() == this.area()) 
			return true;
		else 
			return false;
	}

	@Override
	public int hashCode() {
		return this.radius;
	}

	@Override
	public String toString() {
		return "Shape is a Circle with: " +
				"r = " + this.radius + " and " +
				"S = " + this.area();
	}
	
}
