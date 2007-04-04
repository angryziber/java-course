package net.azib.java.students.t010687;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;



/**
 * GetStringClassMethods
 *	Reflectionid siin
 * @author t010687
 */
public class GetStringClassMethods {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class ClassReflections  = Class.forName("java.lang.String");
		
			//See OK, ylemine lihtsalt ultra n2ide
		//Class <String>ClassReflections  = String.class ;
		
		
		
		for(Method m: ClassReflections.getDeclaredMethods()){
			if (Modifier.isPublic(m.getModifiers())){
				System.out.println(m.getName());
				System.out.println(Arrays.toString(m.getParameterTypes()));
				//m.invoke(obj, args);//[B,int,int]
			}
		}
		
		//Kuvab niii Public kui ka Private methodid
		//for(Method m: ClassReflections.getDeclaredMethods()){
		//	System.out.println(m.getName());
		//}
		
		//Kuvab ainult publicuid
		//for(Method m: ClassReflections.getMethods()){
		//	System.out.println(m.getName());
		//}

	}

}
