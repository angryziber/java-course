package net.azib.java.students.t103800.homework.decathlon.argument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

/**
 * Argument handler is used to handle arguments. This class acts like a iterator.
 * The main constructor validates automatically all input arguments and throws an
 * exception when something went wrong. All arguments will be converted from strings
 * to Argument objects.
 * @see Argument
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class ArgumentHandler {

	private ListIterator<Argument> argumentListIterator;

	/**
	 * Constructs a new argument handler using some input arguments. This constructor will
	 * convert all input strings to Argument objects.
	 * @param arguments arguments to validate and iterate. If validation is successful then
	 * these arguments are going to be converted to Argument objects.
	 * @throws ArgumentException throws when validation of arguments has failed.
	 */
	public ArgumentHandler(String[] arguments) throws ArgumentException {
		ArrayList<Argument> argList = new ArrayList<Argument>();
		ListIterator<String> argIterator = Arrays.asList(arguments).listIterator();
		String parameter = null;

		while(argIterator.hasNext()) {
			Argument.Method method = Argument.stringToMethod(argIterator.next());
			if(method.hasParameter()) {
				if(!argIterator.hasNext()) throw new ArgumentException("Method " + method + " needs a parameter.");
				parameter = argIterator.next();
			}
			argList.add(new Argument(method, parameter));
		}

		argumentListIterator = argList.listIterator();
	}

	/**
	 * Returns the next Argument object in the iteration.
	 * @return next Argument in the iteration.
	 * @throws ArgumentException throws when there are no arguments left in the iteration.
	 */
	public Argument getNextArgument() throws ArgumentException {
		if(argumentListIterator.hasNext()) return argumentListIterator.next();
		throw new ArgumentException(argumentListIterator.nextIndex() + 1 + ". argument is missing.");
	}
}
