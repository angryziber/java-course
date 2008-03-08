package net.azib.java.students.t001370.lectures.lec4.home;

import net.azib.java.lessons.collections.Shape;
/**
 * Square
 *
 * @author maksim
 */
public class Square extends Shape{
	int edgeLenght;
	
	Square(int el){
		this.edgeLenght = el;
	}
	
	public int getEdgeLenght(){
		return edgeLenght;
	}

	@Override
	public double area() {
		return edgeLenght*edgeLenght;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) 
			return false;
		else if (o == this)
			return true;
		else if (o.getClass() != this.getClass()) 
			return false;
		else if (((Square)o).getEdgeLenght() == this.edgeLenght) 
			return true;
		else 
			return false;
	}

	@Override
	public int hashCode() {
		return edgeLenght;
	}

	@Override
	public String toString() {
		return "Shape is a Square with: " +
		"r = " + this.edgeLenght + " and " +
		"S = " + this.area();
	}
}
