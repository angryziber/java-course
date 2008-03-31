package net.azib.java.lessons.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * ReflectionDemo
 *
 * @author anton
 */
public class ReflectionDemo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<Date> clazz = Date.class; 
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.isPrimitive());
		System.out.println(Modifier.isPublic(clazz.getModifiers()));
		
		Constructor<Date> c = clazz.getConstructor(long.class);
		Date d = c.newInstance(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		System.out.println(d);
		
		for (Field f : clazz.getDeclaredFields()) {
			f.setAccessible(true);
			System.out.println(f.getName() + " " + f.getType() + " " + f.get(d));
		}
	}
}
