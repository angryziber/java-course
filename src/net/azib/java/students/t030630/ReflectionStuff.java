package net.azib.java.students.t030630;

import net.azib.java.lessons.net.RequestHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * StringClassMethods
 * 
 * @author Kasutaja
 */
public class ReflectionStuff {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
		// Class<String> clazz = String.class;
		// for (Method m : clazz.getMethods()) {
		// System.out.println(m.getName());
		// }

		// for(Method m : String.class.getDeclaredMethods()){
		// methods
		// System.out.println(m.getName());
		// }

		// returns only private methods names
		// Class clazz = Class.forName("java.lang.String");

		// Class clazz = "".getClass() == ;
		// for (Method m : String.class.getDeclaredMethods()) {
		// if (Modifier.isPublic(m.getModifiers())) {
		// System.out.println(m.getName());
		// System.out.println(Arrays.toString(m.getParameterTypes()));
		// //m.invoke(obj, args);
		// }
		// }

		// Class<Date> clazz = Date.class;
		// System.out.println(clazz.newInstance());

		// String requestHandlerClassNameToUse = "net.azib.java.lessons.net." +
		// "Echo" + "RequestHandler";
		// Class clazz = Class.forName(requestHandlerClassNameToUse);
		// RequestHandler requestHandler = (RequestHandler) clazz.newInstance();
		// System.out.println(requestHandler.getClass().getName());

		// String requestHandlerClassNameToUse = "java.util.Date";
		// Class clazz = Class.forName(requestHandlerClassNameToUse);
		// Date date = (Date)
		// clazz.getConstructor(long.class).newInstance(65765675765765L);
		// System.out.println(date.getClass().getName());

		RequestHandler requestHandler = (RequestHandler) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] { RequestHandler.class }, new InvocationHandler() {
					@Override
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
