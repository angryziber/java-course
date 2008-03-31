package net.azib.java.lessons.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ProxyDemo
 *
 * @author anton
 */
public class ProxyDemo implements InvocationHandler {
	private List<Integer> realList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("clear")) {
			System.err.println("Ignoring clear");
			return null;
		}
		else {
			return method.invoke(realList, args);
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Integer> listProxy = (List<Integer>) Proxy.newProxyInstance(Proxy.class.getClassLoader(), 
				new Class[] {List.class}, new ProxyDemo());
		
		System.out.println(listProxy.getClass().getName());
		System.out.println(listProxy);
		listProxy.clear();
		System.out.println(listProxy);
	}
}









