package net.azib.java.students.t073857.hw4;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Joshua
 */
public class Square extends Shape{
double width, length;
	
	public Square(double width, double length){
		this.width = width;
		this.length = length;
	}
	
	@Override
	public double area() {
		return width*length;
	}

	@Override
	public boolean equals(Object o) {
		if(o.hashCode() == this.hashCode())return true;
		else return false;
	}

	@Override
	public int hashCode() {
		// No idea how to hash correctly...
		return (int)(width*length);
	}

	@Override
	public String toString() {
		return "Square with sides "+width+" and "+length;
	}
}
