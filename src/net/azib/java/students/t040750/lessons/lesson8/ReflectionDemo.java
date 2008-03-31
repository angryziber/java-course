package net.azib.java.students.t040750.lessons.lesson8;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * ReflectionDemo
 *
 * @author t040750
 */
public class ReflectionDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		/*Class clazz = Date.class;
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.isPrimitive());*/
		Class clazz = Class.forName("java.util.Date");
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.isPrimitive());
		System.out.println(Modifier.isPublic(clazz.getModifiers()));
		
		for (Method m : clazz.getMethods()) {
			System.out.println(m.getName());
		}
	}
}
