package net.azib.java.lessons.reflect;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * ClassDemo
 *
 * @author anton
 */
public class ClassDemo {
	public static void hello(String failure) throws IOException {
		throw new IOException("I am a " + failure);
	}
	
	public static void main(String[] args) throws Exception {
		Class<Date> clazz = Date.class;
		Date date = clazz.newInstance();
		System.out.println(date);
		
		for (Method method : clazz.getMethods()) {
			System.out.println(method.getName());
		}
		
		Method toStringMethod = clazz.getMethod("toString");
		System.out.println(toStringMethod.invoke(date));
		
		Method helloMethod = ClassDemo.class.getMethod("hello", String.class);
		try {
			helloMethod.invoke(null, "failure");
		}
		catch (InvocationTargetException e) {
			System.out.println(e.getCause());
		}
		
		for (Field field : clazz.getDeclaredFields()) {
			System.out.print(field.getName() + ": ");
			field.setAccessible(true);
			System.out.print(field.get(date));
			System.out.print(", private: " + Modifier.isPrivate(field.getModifiers()));
			System.out.println(", static: " + Modifier.isStatic(field.getModifiers()));
		}		
	}
}
