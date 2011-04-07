package net.azib.java.lessons.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodsDemo {
	public static void main(String[] args) {
		System.out.println("Public methods:");
		for (Method method : String.class.getMethods()) {
			int modifiers = method.getModifiers();
			System.out.println(method.getName() + Arrays.toString(method.getParameterTypes()) + ": " + Modifier.toString(modifiers));
		}

		System.out.println("Non-public methods:");
		for (Method method : String.class.getDeclaredMethods()) {
			int modifiers = method.getModifiers();
			if (!Modifier.isPublic(modifiers))
				System.out.println(method.getName() + Arrays.toString(method.getParameterTypes()) + ": " + Modifier.toString(modifiers));
		}
	}
}
