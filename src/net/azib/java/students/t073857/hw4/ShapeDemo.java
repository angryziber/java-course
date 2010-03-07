package net.azib.java.students.t073857.hw4;

import net.azib.java.lessons.collections.Shape;

/**
 * ShapeDemo
 *
 * @author Joonas Vali
 */
public class ShapeDemo {
	public static void main(String[] args) {
		Shape s = new Circle(15);
		Shape s2 = new Square(12, 14);
		System.out.println(s+" area: "+s.area()+" hash: "+s.hashCode());
		System.out.println(s2+" area: "+s2.area()+" hash: "+s2.hashCode());		
	}
}
