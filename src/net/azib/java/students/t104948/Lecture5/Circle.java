package net.azib.java.students.t104948.Lecture5;
import net.azib.java.lessons.collections.Shape;

import java.text.DecimalFormat;

public class Circle extends Shape{
	private double radius;

	public Circle(double r){
		this.radius = r;
	}

	double getRadius(){
		return radius;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass()!=o.getClass())
			return false;
		final Circle circle = (Circle)o;
		if(getRadius()!=  circle.getRadius())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (int)this.getRadius();
		return result;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return ("Circle with radius " + df.format(radius) + " and area " + df.format(area()));
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
}
