package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ShapeTest
 *
 * @author anton
 */
public class ShapeTest {
	public static void main(String[] args) {
		List<Shape> lsp = new ArrayList<Shape>();
		List<Circle> lc = new ArrayList<Circle>();
		List<Square> ls = new ArrayList<Square>();
		
		List<?> a = lc;
	}
}
