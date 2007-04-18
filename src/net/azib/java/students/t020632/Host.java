package net.azib.java.students.t020632;

/**
 * Host
 *
 * @author t020632
 */
public class Host {
	private String name;
	public static Host host;
	public static int lastDogID;
	
	public static Host getHost(){
		if(host == null){
			synchronized(Host.class){
				if(host == null){
					host = new Host();
				}
			}
		}
		return host;
	}
	
	private Host(){
		name = "Default name";
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Dog aquireDog(){
		lastDogID++;
		return new Dog("Pontu " + this.getName()+ " " +lastDogID);
	}
	
}
