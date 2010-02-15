package net.azib.java.lessons.basic;

import net.azib.java.lessons.basic.OuterClass.StaticInnerClass;

/**
 * InnerClassDemo
 *
 * @author anton
 */
public class InnerClassDemo {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		System.out.println(outer.innerClassField.innerField);
		
		outer.outerField = "demo";
		OuterClass.InnerClass inner = outer.new InnerClass();
		System.out.println(inner.innerField);
		
		StaticInnerClass staticInner = new StaticInnerClass();
		System.out.println(staticInner.innerField);
	}
}
