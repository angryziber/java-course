package net.azib.java.students.t020632;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * ReflectionStuff
 *
 * @author t020632
 */
public class ReflectionStuff {
	
	public static void main(String [] args){
		Class<String> clazz = String.class;
		
		for(Method m: clazz.getDeclaredMethods()){
			if(Modifier.isPrivate(m.getModifiers())){
				System.out.println(m.getName());
				System.out.println(Arrays.toString(m.getParameterTypes()));
			}
		}
	}
}
