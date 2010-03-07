package net.azib.java.students.t073857.hw4;

import net.azib.java.lessons.collections.Shape;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ShapeAggregatorImplDemo
 *
 * @author Joonas Vali
 */
public class ShapeAggregatorImplDemo {
	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat("0.00");
		
		ShapeAggregatorImpl s = new ShapeAggregatorImpl();
		s.addShapes(
				new Circle(5),
				new Circle(1),
				new Circle(5.1),
				new Circle(15),
				new Circle(17),
				new Circle(2.1),
				new Circle(1.7),
				new Circle(8.2),
				new Square(1,1),
				new Square(1,5),
				new Square(15,20),
				new Square(16,15)		
		);
		
		System.out.println("max area: "+s.max());
		System.out.println("min area: "+s.min());
		System.out.println("Total area size: "+s.totalArea());
		
		List<? extends Shape> sorted = s.sortedShapes();
		System.out.println("\nShapes in sorted order:\n");
		for(Shape shape: sorted){
			System.out.println(shape+"\t\t\t(area: "+nf.format(shape.area())+")");
		}
		
		Collection<Shape> larger = new ArrayList<Shape>();
		s.copyLargerTo(sorted.get(5), larger);
		System.out.println("\nShapes bigger than 6th shape in sorted list:\n");
		for(Shape shape: larger){
			System.out.println(shape+"\t\t\t(area: "+nf.format(shape.area())+")");
		}
		
	}
}
