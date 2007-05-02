package net.azib.java.students.t030656.shape;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author t030656
 */
public class Square extends Shape{

	private double side;
	private double area;
	Square(double s){
		side = s;
		area = side * side;
	}
	
	@Override
	public double area() {
		return area;
	}


	@Override
	public boolean equals(Object o) {
		if (o instanceof Square) {
			Square compSquare = (Square) o;
			
			return compSquare.side == side; 
		}
		return false;
	}


	@Override
	public int hashCode() {
		return (int)side;
	}

	@Override
	public String toString() {
		return "Type: Square, area:" + area +", side: " + side + ";";
	}	
}
