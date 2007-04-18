package net.azib.java.students.t010687;

/**
 * SingleHost
 *
 * @author t010687
 */
public class SingleHost {
	private static SingleHost UniqInstance;
	private String Name;
	private int DogsCnt;
	//----------------------------------------------------------------//
	private SingleHost(){
		Name = "Juku";
	}
	
	public static SingleHost getInstance() {
		if (UniqInstance == null){//double check! (Y)
			synchronized(SingleHost.class){
				if (UniqInstance == null){
					UniqInstance = new SingleHost();
				}
			}
		}
		return UniqInstance;
	}
	
	public String getName(){
		return Name;
	}
	
	public Dog aquiredDog(){
		DogsCnt++;
		return new Dog(Name + "'s " + DogsCnt + " Dog");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SingleHost.getInstance().getName());
		System.out.println(SingleHost.getInstance().aquiredDog());
		System.out.println(SingleHost.getInstance().aquiredDog());
		System.out.println(SingleHost.getInstance().aquiredDog());

	}

}
