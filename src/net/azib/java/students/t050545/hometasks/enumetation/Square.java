package net.azib.java.students.t050545.hometasks.enumetation;


import static java.lang.Math.pow;
import static java.lang.Math.PI;

/**
 * Square
 *
 * @author libricon
 */
public class Square extends Shape {
	
	Square(double side){
		super();
		this.side=side;
	}
	
	Square(){
		super();
		this.side = 1;
	}
	
	public double getSide(){
		return side;
	}
	
	@Override
	public int hashCode(){
		return new Double(side).intValue(); 
	}
	
	@Override
	public double area(){
		return PI*pow(side, 2)/2;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Square){
			Square malevits = (Square)o;
			return malevits.area() == this.area();
		}
	    return false;
	}
	
	@Override
	public String toString(){
		return "The Square's area is "+area();
	}
	
	private double side;
}
