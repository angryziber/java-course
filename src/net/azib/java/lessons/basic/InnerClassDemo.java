package net.azib.java.lessons.basic;

public class InnerClassDemo {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		System.out.println(outer.someField);
		System.out.println(OuterClass.someStaticField);

		OuterClass.InnerClass inner = outer.new InnerClass();
		outer.someField = 123;
		System.out.println(inner);

		OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
		System.out.println(staticInner);
	}
}
