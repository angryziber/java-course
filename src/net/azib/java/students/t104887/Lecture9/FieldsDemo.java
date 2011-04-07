package net.azib.java.students.t104887.Lecture9;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class FieldsDemo {
	public static void main(String[] args) {
		for (Field field : Date.class.getDeclaredFields()) {
			System.out.println(field.getName() + " " + field.getType());
		}
	}
}
