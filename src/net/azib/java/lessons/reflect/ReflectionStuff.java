package net.azib.java.lessons.reflect;

import net.azib.java.lessons.net.RequestHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ReflectionStuff
 *
 * @author anton
 */
public class ReflectionStuff {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
		RequestHandler requestHandler = (RequestHandler) Proxy.newProxyInstance(
			ClassLoader.getSystemClassLoader(), 
			new Class[] {RequestHandler.class}, 
			new InvocationHandler() {
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println(method.getName());
					return null;
				}
			});
		
		requestHandler.cloneForRequest(null);
		requestHandler.getClass();
		requestHandler.toString();
		
	}
}






