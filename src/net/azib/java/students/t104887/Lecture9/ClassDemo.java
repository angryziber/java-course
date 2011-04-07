package net.azib.java.students.t104887.Lecture9;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class ClassDemo {
	public static void main(String[] args)throws NoSuchMethodException {
		Object o = new Date();
		Class clazz = o.getClass();

		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());

		Method m = clazz.getMethod("getTime");
		System.out.println(m.getReturnType());

		//m.invoke(o);
	}
}
