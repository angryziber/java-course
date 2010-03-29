package net.azib.java.students.t073639.taskAggregation;

import net.azib.java.lessons.collections.Shape;
/**
 * Circle
 * 
 * @author t073639
 */
public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return radius*radius*Math.PI;
	}

	@Override
	public boolean equals(Object o) {
		if (this.hashCode()==o.hashCode()) return true;
		else return false;
	}

	@Override
	public int hashCode() {
		
		return (int)radius*1031;
	}

	@Override
	public String toString() {
		
		return Double.toString(radius);
	}

}
