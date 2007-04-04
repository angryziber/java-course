package net.azib.java.students.t050657;

import net.azib.java.lessons.net.RequestHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * StringClassLook
 *
 * @author t050657
 */
public class StringClassLook {

	public static void main(String[] args)
			throws ClassNotFoundException, 
				   InstantiationException, 
				   IllegalAccessException,
				   InvocationTargetException,
				   NoSuchMethodException{
		
		RequestHandler requestHandler = (RequestHandler)Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] {RequestHandler.class},
				new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) {
							System.out.println(method.getName());
							return null;
						}
				});
		
		requestHandler.cloneForRequest(null);
		requestHandler.getClass();
		requestHandler.toString();
		
//		String requestHandlerClassNameToUse = "java.azib.net.lessons" + "Echo" + "RequestHandler";
//		Class clazz = Class.forName(requestHandlerClassNameToUse);
//		RequestHandler requestHandler = (RequestHandler) clazz.newInstance();
//		requestHandler.readRequest();
		
//		String dateToUse = "java.util.Date";
//		Class clazz = Class.forName(dateToUse);
//		Date date = (Date) clazz.getConstructor(long.class).newInstance(456423123165L);
//		System.out.println(date);
//	
//		clazz = Class.forName("java.lang.String");
//		for(Method m : clazz.getDeclaredMethods()) {
//			if(Modifier.isPublic(m.getModifiers())) {
//				System.out.print(m.getName());
//				System.out.println(Arrays.toString(m.getParameterTypes()));
//			}
//		}
	}
}
