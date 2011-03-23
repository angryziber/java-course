package net.azib.java.students.t104948.Lecture5;

import net.azib.java.lessons.collections.Shape;

import java.text.DecimalFormat;

public class Square extends Shape {
	private double side;

	public  Square(double s){
		this.side = s;
	}

	double getSide(){
		return side;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass()!=o.getClass())
			return false;
		final Square square = (Square)o;
		if(getSide()!= square.getSide())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int PRIME = 37;
		int result = 2;
		result = PRIME * result + (int)this.getSide();
		return result;  	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return("Square with side " + df.format(side) + " and area " + df.format(area()));
	}

	@Override
	public double area() {
		return side * side;
	}


}
