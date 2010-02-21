package net.azib.java.students.t092875.hw2;

/**
 * Dog
 *
 * @author Mihhail
 */
public class Dog extends Pet {
	private int bonesBuried;
	
	Dog(String name, int age, int weight){
		super(name,age,weight);
		this.bonesBuried = 0;
	}
	/**
	 * Bury one bone.
	 */
	public void buryABone(){
		System.err.println("I buried a bone");
		this.bonesBuried++;
	}
	/**
	 * Bury n bones.
	 * @param n - the number of bones
	 */
	public void buryABone(int n){
		if(n<=0){
			System.err.println("I can't bury that");
		}else if(n==1){
			this.buryABone();
		}else{
			System.err.println("I buried "+n+"bones");
			this.bonesBuried = this.bonesBuried + n;
		}
	}

	@Override
	public String makeSound() {
		return "Bark";
	}
	
	public String toString(){
		return super.toString()+"This dog buried "+this.bonesBuried+" bones. ";
	}
	
}
