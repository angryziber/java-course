package net.azib.java.students.t020632;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author t020632
 */
public class Square extends Shape{
	
	private double edge;
	
	public Square(double edge){
		this.edge = edge;
	}
	
	@Override
	public double area() {
		double result;
		
		result = edge*edge;
		
		return result;
	}

	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Square){
			Square s = (Square)o;
			if(this.area() == s.area())
				return true;
		}
			
		return false;
	}

	
	@Override
	public int hashCode() {
	
		return (int)edge;
	}

	
	@Override
	public String toString() {
		
		return null;
	}

}
