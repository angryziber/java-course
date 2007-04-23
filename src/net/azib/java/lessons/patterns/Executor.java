package net.azib.java.lessons.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Executor
 *
 * @author anton
 */
public class Executor {
	public static void main(String[] args) {
		Host host = Host.getInstance();
		System.out.println(host.acquireDog().getName());
		System.out.println(host.acquireDog().getName());
		System.out.println(host.acquireDog().getName());
	}
}
