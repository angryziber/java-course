package net.azib.java.lessons.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * ReflectDemo
 *
 * @author anton
 */
public class ReflectDemo {
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class c = Date.class;
		System.out.println(c.getName());
		System.out.println(c.getPackage());
		System.out.println("public? " + Modifier.isPublic(c.getModifiers()));
		System.out.println("abstract? " + Modifier.isAbstract(c.getModifiers()));
		
		System.err.println("Public methods");
		for (Method m : c.getMethods()) {
			System.out.println(m.getName());
		}
		
		System.err.println("Private fields");
		for (Field f : c.getDeclaredFields()) {
			System.out.println(f.getName());
		}
		
		Field f = c.getDeclaredField("fastTime");
		f.setAccessible(true);
		System.out.println("fastTime=" + f.get(c.newInstance()));
		
		System.out.println(c.newInstance());
		System.out.println(Class.forName("java.net.Socket").newInstance());
	}
}
