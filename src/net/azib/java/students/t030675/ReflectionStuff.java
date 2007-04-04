package net.azib.java.students.t030675;

import net.azib.java.lessons.net.RequestHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.sql.Date;
import java.util.Arrays;

/**
 * Test
 *
 * @author t030675
 */
public class ReflectionStuff {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		/*1*/ Class<String> clazz = String.class;
//		/*2*/ Class clazz = Class.forName("java.lang.String");
//		/*3*/ Class clazz = "".getClass();
//		for (Method m : clazz.getDeclaredMethods()) {
//			if(Modifier.isPrivate(m.getModifiers())){
//				System.out.println(m.getName());
//				System.out.println(Arrays.toString(m.getParameterTypes()));
//			}
//		}
		
//		Class<Date> clazz = Date.class;
//		System.out.println(clazz.newInstance());
		
//		String requestHandlerClassNameToUse = "net.azib.java.lessons.net." + "Echo" + "RequestHandler";
//		Class clazz = Class.forName(requestHandlerClassNameToUse);
//		RequestHandler requestHandler = (RequestHandler) clazz.newInstance();
//		System.out.println(requestHandler.getClass().getName());
		
//		String className = "java.util.Date";
//		Class clazz = Class.forName(className);
//		//Date date = (Date) clazz.newInstance();
//		Date date = (Date) clazz.getConstructor(long.class).newInstance(54654667657325L);
//		System.out.println(date);
		
//		RequestHandler requestHandler = (RequestHandler) Proxy.newProxyInstance(
//					ClassLoader.getSystemClassLoader(),
//					new Class[]{RequestHandler.class}, 
//					new InvocationHandler(){
//						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//							System.out.println(method.getName());
//							return null;
//						}
//					}
//					);
//		requestHandler.cloneForRequest(null);
//		requestHandler.getClass();
//		requestHandler.toString();
		
	}
	
}
