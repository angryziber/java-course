package net.azib.java.students.t092875.hw4.part2;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Mihhail
 */
public class Circle extends Shape {
	private double radius;
	
	public Circle(int radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI*radius*radius;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle){
			Circle oo = (Circle) o;
			return oo.getRadius()==this.radius?true:false;
		}else{
			return false;
		}
	}

	//not sure if this is correct
	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash*32 + (int) this.radius;
		hash = hash*32 + (int) this.area();
		return hash;
	}

	@Override
	public String toString() {
		return "This is a Circle with radius "+this.radius+" and are of "+this.area();
	}

}
