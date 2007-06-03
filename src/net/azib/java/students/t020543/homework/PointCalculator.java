package decathlon;

/**
 * A class, which calculates overall points (all 10 events) 
 * for a single {@link Athlete}.
 * @author t020543
 */
public class PointCalculator implements IPointCalculator{
	
	@Override
	public final int calculatePoints(IAthlete man) {
		
	int points;
	//reading constants from Event enum through the IEvent interface
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
	
	//Input for the jumping events was read in meters, so conversion to cm needed.
	points = 	sprint100m.calculateEvent(man.getSprint100()) +
				longJump.calculateEvent(man.getLongJump() * 100)+
				shotPut.calculateEvent(man.getShotPut())+
				highJump.calculateEvent(man.getHighJump()* 100)+
				sprint400.calculateEvent(man.getSprint400())+
				hurdles110.calculateEvent(man.getHurdles110())+
				discusThrow.calculateEvent(man.getDiscusThrow())+
				poleVault.calculateEvent(man.getPoleVault() * 100)+
				javelinThrow.calculateEvent(man.getJavelinThrow())+
				race1500.calculateEvent(man.getRace1500());

	return points;

	}
}
