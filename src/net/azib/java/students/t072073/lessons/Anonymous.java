package net.azib.java.students.t072073.lessons;

/**
 * Anonymous
 *
 * @author t072073
 */
public class Anonymous {
	
	public static interface HelloCallBack {
		public String name();
		
	}
	public static void sayHello(HelloCallBack callback){
		System.out.println("Hello, " + callback.name() + "!");
	}
	public static void main(String[] args) {
		/*
		 * Anonüümne klass (vt runnable näide loengu
		 * slaididelt)
		 */
		sayHello(new HelloCallBack() {
			public String name(){
				return System.getProperty("user.name");
			}
		});
	}
}
