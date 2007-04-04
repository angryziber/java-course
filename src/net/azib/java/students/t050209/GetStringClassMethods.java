package net.azib.java.students.t050209;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * GetStringClassMethods
 * ReflectionStuff
 * @author t050209
 */
public class GetStringClassMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		//Class<String> clazz = String.class;
		Class clazz = Class.forName("java.lang.String");
		for(Method m : clazz.getDeclaredMethods()) { //getMethods annab ainult public
			// ainult private, ilma selleta väljastab kõik
			//if(Modifier.isPrivate(m.getModifiers())) { 
			if(Modifier.isPublic(m.getModifiers())) {
				System.out.println(m.getName());
				System.out.println(Arrays.toString(m.getParameterTypes()));
				/*m.invoke(obj, args)*/ /* args = [B, int, int]*/
			}
		}
	}

}
