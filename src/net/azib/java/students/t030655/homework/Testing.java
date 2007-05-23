package net.azib.java.students.t030655.homework;

/**
 * Testing
 *
 * @author qtrines
 */
public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Points one = new Points();
		
		one.setSprint100m(12.61);
//		System.out.println((int)one.getSprint100m());
		one.setLongJump(5.00);
		one.setShotPut(9.22);
		one.setHighJump(1.50);
		one.setSprint400m(59.39);
		one.setHurdles110m(16.43);
		one.setDiscusThrow(21.60);
		one.setPoleVault(2.60);
		one.setJavelinThrow(35.81);
		one.setRace1500m(325.72);
		
		System.out.println(one.totalPoints());

	}

}
