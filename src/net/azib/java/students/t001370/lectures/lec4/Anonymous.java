package net.azib.java.students.t001370.lectures.lec4;

/**
 * Anonymous
 *
 * @author maksim
 */
public class Anonymous {

	public static interface HelloCallback{
		public String name();
	}
	
	public static void sayHello(HelloCallback callback){
		System.out.println("Hello, " + callback.name() + " !");
	}
	
	/*public static class TestHC implements HelloCallback{
		public String name(){
			return System.getProperty("user.name");
		}
	}*/
	
	public static void main(String[] args) {
		
		HelloCallback helloCallback = new HelloCallback(){		//see on anonüümne class
			public String name(){
				return System.getProperty("user.name");
			}
		};

		sayHello(/*new TestHC*/helloCallback);
	}

}
