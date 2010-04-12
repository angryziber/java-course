package net.azib.java.lessons.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * ProxyDemo
 *
 * @author anton
 */
public class ProxyDemo implements InvocationHandler {
	
	private List original;
	
	public ProxyDemo(List original) {
		this.original = original;
	}

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("A");
		
		list = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), new Class[] {List.class}, new ProxyDemo(list));
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println(method);
		if (method.getName().equals("clear")) {
			System.err.println("clear call intercepted and disabled");
			return null;
		}
		return method.invoke(original, args);
	}
}
