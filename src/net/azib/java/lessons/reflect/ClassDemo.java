package net.azib.java.lessons.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ClassDemo {
	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		Object o = new Date();
		Class clazz = o.getClass();

		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());

		Method m = clazz.getMethod("getTime");
		System.out.println(m.getReturnType());

		Object result = m.invoke(o);
		System.out.println(result);

		clazz = Class.forName("java.util.Date");
		System.out.println(clazz.newInstance());

		System.out.println(byte.class.isPrimitive());
		System.out.println(byte[].class.isArray());
		System.out.println(Date.class.isPrimitive());
	}
}
