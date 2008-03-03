package net.azib.java.students.t030611;

/**
 * AnonymousDemo
 *
 * @author t030611
 */
public class AnonymousDemo {
	public static interface HelloCallBack{
		public String name();
	}
	
	public static void sayHello(HelloCallBack callback){
		System.out.println("Hello, " + callback.name()+"!");
	}

	
	public static void main(String[] args) {
		 sayHello(new HelloCallBack(){
				public String name(){
					return System.getProperty("user.name");
				} 
		 });
	}
}
