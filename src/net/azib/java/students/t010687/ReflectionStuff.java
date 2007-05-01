package net.azib.java.students.t010687;


/**
 * ReflectionStuff
 *
 * @author t010687
 */
public class ReflectionStuff {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//RequestHandler requestHandler = (RequestHandler) Proxy.newProxyInstance(
		//		ClassLoader.getSystemClassLoader(), new Class[]{RequestHandler.class},
		//		new InvocationHandler(){
		//			@Override
		//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//				System.out.println(method.getName());
		//				return null;
		//			}
		//		}
		//}
		
		

		
		
		//String DateName = "java.util.Date";
		//Class claxz = Class.forName(DateName);
		//Date Datex = (Date) claxz.newInstance();
		//System.out.println(Datex.getClass().toString());
		
		//String requestHandlerClassNameToUse = "net.azib.java.lessons.net.EchoRequestHandler";
		//Class clazz = Class.forName(requestHandlerClassNameToUse);
		//RequestHandler requestHandler =(RequestHandler) clazz.newInstance();
		//System.out.println(requestHandler.getClass().toString());
		
		//Class <Date> clazz = Date.class;
		//System.out.println(clazz.newInstance());
		
	}

}
