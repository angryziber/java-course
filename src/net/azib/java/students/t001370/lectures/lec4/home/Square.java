package net.azib.java.students.t001370.lectures.lec4.home;

import net.azib.java.lessons.collections.Shape;
/**
 * Square
 *
 * @author maksim
 */
public class Square extends Shape{
	int edgeLength;
	
	Square(int el){
		this.edgeLength = el;
	}

	@Override
	public double area() {
		return edgeLength*edgeLength;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		return edgeLength;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
