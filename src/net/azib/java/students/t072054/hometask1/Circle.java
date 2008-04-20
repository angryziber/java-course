package net.azib.java.students.t072054.hometask1;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author Roman
 */
public class Circle extends Shape {
	
	int x, y;
	int rad;
	
	/**
	 * Constructs a Circle instance.
	 */
	protected void Shape(int l_x, int l_y, int l_rad) {
		x = l_x;
		y = l_y;
		rad = l_rad;
	}
	
	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Circle o){
		if (o.x == x && o.y == y && o.rad == rad)
			return true;
		else
			return false;
	}
}
