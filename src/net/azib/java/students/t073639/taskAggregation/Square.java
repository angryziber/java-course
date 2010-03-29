package net.azib.java.students.t073639.taskAggregation;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author t073639
 */
public class Square extends Shape {
	double a;
	
	public Square(double a) {
		this.a = a;
	}

	@Override
	public double area() {
		return a*a;
	}

	@Override
	public boolean equals(Object o) {
		if (o.hashCode()==this.hashCode()) return true;
		else return false;
	}

	@Override
	public int hashCode() {
		return (int)a*1031;
	}

	@Override
	public String toString() {
		return Double.toString(a);
	}

}
