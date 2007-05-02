package net.azib.java.students.t030656.shape;

import net.azib.java.lessons.collections.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * ShapeTest
 *
 * @author t030656
 */
public class ShapeTest {
	public static void main(String[] args) {
		List<Shape> ls = new ArrayList<Shape>();
		List<Circle> lc = new ArrayList<Circle>();
		List<Square> lsq = new ArrayList<Square>();
		
		ls.add(new Square(13.5));
		lc.add(new Circle(13.8));
		lsq.add(new Square(987.987));
	}
}
