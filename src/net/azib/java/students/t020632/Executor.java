package net.azib.java.students.t020632;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Executor
 *
 * @author t020632
 */
public class Executor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Host host = Host.getHost();
		System.out.println(host.aquireDog().getName());
		
		//List list = new ArrayList();
		//list = Collections.unmodifiableList(list);

	}

}
