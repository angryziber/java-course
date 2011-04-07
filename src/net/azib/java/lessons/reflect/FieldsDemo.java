package net.azib.java.lessons.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

public class FieldsDemo {
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		for (Field field : Date.class.getDeclaredFields()) {
			System.out.println(field.getName() + " " + field.getType() + ": " + Modifier.toString(field.getModifiers()));
		}

		Date date = new Date();
		Field timeField = Date.class.getDeclaredField("fastTime");
		timeField.setAccessible(true);
		System.out.println(timeField.get(date));
		timeField.set(date, 123);
		System.out.println(date);
		timeField.setAccessible(false);
	}
}
