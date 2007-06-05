package net.azib.java.students.t020543.homework;

/**
 * A class, which checks input data for logical correctness 
 * @author t020543
 */
public class DataValidation implements IDataValidation{
	
	@Override
	public boolean checkNegative(double input){
		 if (input < 0) {
			 return true;
		 }
		 return false;
	}
	
	@Override
	public boolean checkAllNegative(IAthlete man){
		
		boolean conj =	(man.getSprint100() < 0) || (man.getLongJump() < 0) || 
						(man.getSprint400() < 0) || (man.getHighJump() < 0) ||
						(man.getDiscusThrow() < 0) || (man.getHurdles110() < 0) ||
						(man.getJavelinThrow() < 0) || (man.getPoleVault() < 0) ||
						(man.getRace1500() < 0) || (man.getShotPut() < 0);			
		return conj; 
	}

	@Override
	public boolean checkWorldRecord(IAthlete man){
		 
		/*reading constants from Event enum using the IEvent interface*/
		IEvent sprint100m = Event.SPRINT100;
		IEvent longJump	= Event.LONG_JUMP;	
		IEvent shotPut 	= Event.SHOT_PUT ;		
		IEvent highJump	= Event.HIGH_JUMP;	
		IEvent sprint400 = Event.SPRINT400;	
		IEvent hurdles110 = Event.HURDLES110;	
		IEvent discusThrow = Event.DISCUS_THROW;	
		IEvent poleVault = Event.POLE_VAULT;	
		IEvent javelinThrow = Event.JAVELIN_THROW;	
		IEvent race1500 = Event.RACE1500;	
		
		boolean conj = 	sprint100m.compareWorldRecord(man.getSprint100()) ||
						longJump.compareWorldRecord(man.getLongJump())||
						shotPut.compareWorldRecord(man.getShotPut()) ||
						highJump.compareWorldRecord(man.getHighJump()) ||
						sprint400.compareWorldRecord(man.getSprint400()) ||
						hurdles110.compareWorldRecord(man.getHurdles110()) ||
						discusThrow.compareWorldRecord(man.getDiscusThrow()) ||
						poleVault.compareWorldRecord(man.getPoleVault()) ||
						javelinThrow.compareWorldRecord(man.getJavelinThrow()) ||
						race1500.compareWorldRecord(man.getRace1500());
		
		return conj;
		
	}

	
}
