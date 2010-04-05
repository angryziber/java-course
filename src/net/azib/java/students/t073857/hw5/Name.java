package net.azib.java.students.t073857.hw5;

/**
 * Name
 *
 * @author Joonas Vali
 */
public class Name {
	private String[] name;
	public Name(String name){
		if(name == null || name.length() == 0) 
			throw new IllegalArgumentException("Name must be a String with length > 0");		
		this.name = name.trim().split(" ");		
		
	}
	
	public String toString(){
		StringBuilder b = new StringBuilder();		
		for(int i = 0; i < name.length; i++){
			if(!name[i].equals(""))
				b.append(" "+name[i]);
		}
		b.deleteCharAt(0);
		return b.toString();
	}
	
	public String getFirstName(){
		return name[0];
	}
	
	public String getLastName(){
		if(name.length > 1)
			return name[name.length-1];
		else return "";
	}		
}
