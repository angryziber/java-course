package net.azib.java.students.t104887.Lecture9;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class MethodsDemo {
	public static void main(String[] args) {
		System.out.println("Public methods");
		for (Method method : String.class.getMethods()) {
			System.out.println(method.getName() + Arrays.toString(method.getParameterTypes()));
			int modifiers = method.getModifiers();
			Modifier.isStatic(modifiers);
			System.out.println(method.getName() + Arrays.toString(method.getParameterAnnotations()));
		}

		System.out.println("Non public methods");
		for (Method method : String.class.getDeclaredMethods()) {
			System.out.println(method.getName() + Arrays.toString(method.getParameterTypes()));
			int modifiers = method.getModifiers();
			Modifier.isStatic(modifiers);
			System.out.println(method.getName() + Arrays.toString(method.getParameterAnnotations()));
		}
	}
}
