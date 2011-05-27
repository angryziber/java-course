package net.azib.java.students.t103800.homework.decathlon.argument;

/**
 * Argument objects are used to describe argument inputs.
 * Argument objects contain methods and parameters. Methods are
 * described in the Method enumeration.
 *
 * @see ArgumentHandler
 * @see Method
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class Argument {

	private Method method;
	private String parameter;

	/**
	 * Constructs a new argument.
	 * @param method the method.
	 * @param parameter the parameter.
	 */
	public Argument(Method method, String parameter) {
		this.method = method;
		this.parameter = parameter;
	}

	/**
	 * Returns the method that the argument contains.
	 * @return method.
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * Returns the parameter value that the argument contains.
	 * @return parameter.
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * Used to convert a string to a method.
	 * @param method method as a string.
	 * @return method as a Method object.
	 * @throws ArgumentException throws when there are no methods equal to this string.
	 */
	public static Method stringToMethod(String method) throws ArgumentException {
		for(Method argument : Method.values())
			if(method.equals(argument.getMethodString())) return argument;
		throw new ArgumentException("Method " + method + " does not exist.");
	}

	/**
	 * Method enumeration holds all method descriptions.
	 * Every method has a string value and might be with a parameter.
	 *
	 * @see Argument
	 *
	 * @author Jaan Aigro
	 * @version 1.0
	 * @since 22/05/2011
	 */
	public enum Method {
		CONSOLE("-console", false),
		CSV("-csv", true),
		DB("-db", true),
		XML("-xml", true),
		HTML("-html", true);

		private String methodAsString;
		private boolean usesParameter;

		Method(String method, boolean hasParameter) {
			methodAsString = method;
			usesParameter = hasParameter;
		}

		/**
		 * Returns the method as a string.
		 * @return method as string.
		 */
		public String getMethodString() {
			return methodAsString;
		}

		/**
		 * Tells if the method requires a parameter.
		 * @return true if method requires a parameter.
		 */
		public boolean hasParameter() {
			return this.usesParameter;
		}
	}
}