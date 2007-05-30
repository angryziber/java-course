package sample;
import java.awt.Color;
import java.util.Random;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * ShbRobot - a robot by (your name here)
 */
public class ShbRobot extends Robot
{
	/**
	 * run: ShbRobot's default behavior
	 */
	
	int distance = 400;
	int oth = 3;
	int angle = 120;
	boolean left = true;
	
	int quant = 0;
	String name = "";
	
	Random rand;
	
	public void run() {

		setGunColor(Color.ORANGE);
		setBodyColor(Color.GRAY);
		setBulletColor(Color.RED);
		
		rand = new Random();
		turnGunRight(90);
		
		while(true) {
			if(getOthers() >= oth)
				if(left) {
					runFast();
				}else {
					ahead(rand.nextInt(distance));
					turnRight(angle);
					back(rand.nextInt(distance));
					turnRight(angle);
				}
			else {
				ahead(100);
				turnGunRight(180);
				back(100);
				turnGunRight(180);
			}
		}
	}
	
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if(getOthers() < oth) {
			fire(1);
			if(e.getDistance() < 200) {
				runFast();
			}
			turnLeft(90 - e.getBearing());	
		}
		else {
			if( e.getDistance() < 100 )
				fire(3);
			else if (e.getDistance() < 200)
				fire(2);
			else if( e.getDistance() < 500)
				fire(1);
		}
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		String robotsName = e.getName();
		if(name.equals(robotsName)) {
			quant++;
		}else {
			quant = 0;
		}
		if(quant >= 3) {
			runFast();
		}
		
		if(getOthers() < oth) {
			turnLeft(90 - e.getBearing());
		}
	}
	
	public void onHitWall(HitWallEvent e) {
		if(left)
			left = false;
		else
			left = true;
	}
	
	public void onHitRobot(HitRobotEvent e) {
		if(left)
			left = false;
		else 
			left = true;
	}
	
	public void runFast() {
		ahead(rand.nextInt(distance));
		turnLeft(90);
		back(rand.nextInt(distance));
		turnLeft(90);
	}
	

}
