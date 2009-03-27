package net.azib.java.students.t050545.hometasks.enumetation;

import static java.lang.Math.pow;
import static java.lang.Math.PI;

/**
 * Circle
 *
 * @author libricon
 */
public class Circle extends Shape {
	
	Circle(double radius){
		super();
		this.radius=radius;
	}
	
	Circle(){
		super();
		this.radius = 1;
	}
	
	public double getRadius(){
		return radius;
	}
	
	@Override
	public int hashCode(){
		return new Double(radius).intValue(); 
	}
	
	@Override
	public double area(){
		return PI*pow(radius, 2)/2;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Circle){
			Circle circle = (Circle)o;
			return circle.area() == this.area();
		}
	    return false;
	}
	
	@Override
	public String toString(){
		return "The Circle' area is "+area();
	}
	
	private double radius;
}
