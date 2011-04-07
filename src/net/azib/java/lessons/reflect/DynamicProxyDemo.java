package net.azib.java.lessons.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo implements InvocationHandler {
	private Runnable runnable;

	public DynamicProxyDemo(Runnable runnable) {
		this.runnable = runnable;
	}

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};
		runnable.run();

		runnable = (Runnable) Proxy.newProxyInstance(runnable.getClass().getClassLoader(), runnable.getClass().getInterfaces(), new DynamicProxyDemo(runnable));

		System.out.println(runnable.getClass());
		runnable.run();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before");
		method.invoke(runnable);
		System.out.println("After");
		return null;
	}
}
