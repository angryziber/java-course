package net.azib.java.students.t092875.hw4.part2;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Mihhail
 */
public class Square extends Shape {
	private double side;
	
	public Square(double side){
		this.side = side;
	}
	
	public double getSide(){
		return this.side;
	}
	
	@Override
	public double area() {
		return this.side*this.side;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Square){
			Square oo = (Square) o;
			return oo.getSide()==this.side?true:false;
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash*32 + (int) this.side;
		hash = hash*32 + (int) this.area();
		return hash;
	}

	@Override
	public String toString() {
		return "This is a Square with a side "+this.side+" and are of "+this.area();
	}

}
