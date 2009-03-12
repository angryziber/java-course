package net.azib.java.lessons.basic;

import net.azib.java.lessons.basic.OuterClass.StaticInnerClass;

import java.util.Map;

/**
 * InnerClassDemo
 *
 * @author anton
 */
public class InnerClassDemo {
	@SuppressWarnings({"unused", "unchecked"})
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		o.inner.doSomething();
		
		OuterClass.StaticInnerClass si = new StaticInnerClass();
		si.doSomething();
		
		// also inner
		Map.Entry e;
	}
}
