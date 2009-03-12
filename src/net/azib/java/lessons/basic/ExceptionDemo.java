package net.azib.java.lessons.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;

/**
 * ExceptionDemo
 *
 * @author anton
 */
public class ExceptionDemo {
	@SuppressWarnings({"unchecked", "unused"})
	public static void main(String[] args) {				
		try {
			String[] s = {"a"};
			//System.out.println(s[10]);
			
			Collection c = new ArrayList();
			c.add("A");
			for (Object object : c) {
				c.add("B");
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Bug: array out of bounds");
		}
		catch (ConcurrentModificationException e) {
			throw new UnsupportedOperationException(e);
		}
		catch (NullPointerException e) {
			// not recommended
		}
		catch (Exception t) {
			t.printStackTrace();
		}
		catch (Error e) {
			System.err.println("Something eally bad happened: " + e);
		}
		finally {
			System.out.println("Finished!");
		}
	}
}
