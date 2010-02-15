package net.azib.java.lessons.basic;

/**
 * InnerClassDemo
 *
 * @author anton
 */
public class OuterClass {
	
	String outerField = "outer";
	InnerClass innerClassField = new InnerClass();

	class InnerClass {
		String innerField = OuterClass.this.outerField;
	}
	
	static class StaticInnerClass {
		String innerField = "static";
	}
	
}
