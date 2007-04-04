package net.azib.java.students.t050209;

import net.azib.java.lessons.net.RequestHandler;
import java.util.Date;
import org.junit.runner.Request;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;


/**
 * ReflectionStuff
 *
 * @author t050209
 */
public class ReflectionStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, 
												  InstantiationException, 
												  IllegalAccessException{
		// TODO Auto-generated method stub
		//Class<Date> clazz = Date.class;
		//System.out.println(clazz.newInstance());
		
		//String requestHandlerClassNameToUse = "net.azib.java.lessons.net.EchoRequestHandler";
		//Class clazz = Class.forName(requestHandlerClassNameToUse);
		//RequestHandler requestHandler = (RequestHandler) clazz.newInstance();
		//System.out.println(requestHandler.getClass().toString());
	
//		RequestHandler requestHandler = Proxy.newProxyInstance
//										(ClassLoader.getSystemClassLoader(), 
//										 new Class[] {RequestHandler.class}, 
//										 new InvocationHandler() {
//											public Object invoke(Object proxy,
//																 Method method, 
//																 Object[] args)
//												System.out.println(method.getName());
//												return null;
//											}
//	});
	}

}
