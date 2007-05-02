package net.azib.java.students.t020632;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author t020632
 */
public class Circle extends Shape {

	double radius;
	
	public Circle(double r){
		radius = r;
	}
	
	@Override
	public double area() {
		double result;
		
		result = Math.PI * radius * radius;
		
		return result;
	}

	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle){
			Circle c = (Circle)o;
			if(this.area() == c.area()){
				return true;
			}
			
		}
		
		return false;
	}

	
	@Override
	public int hashCode() {
		
		return (int)radius;
	}

	
	@Override
	public String toString() {
		
		return null;
	}

}
