package net.azib.java.students.t092875.hw4.part2;

import net.azib.java.lessons.collections.ShapeAggregator;

/**
 * ShapeAggregatorDemo
 *
 * @author Mihhail
 */
public class ShapeAggregatorDemo {
	public static void main(String[] args) {
		Square a = new Square(10);
		Square c = new Square(15);
		Square d = new Square(5);
		ShapeAggregator sa = new ShapeAggregatorImpl();
		sa.addShapes(a,d,c);
		System.out.println(sa.max());
		System.out.println(sa.totalArea());
		
	}
}
