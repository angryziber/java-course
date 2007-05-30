
/**
 * MyRobot
 *
 * @author Marek Soobik t020632
 */

import java.awt.Color;

import robocode.*;

public class MyRobot extends Robot {
	
	
	public void run(){
		
		setColors(Color.black,Color.black,Color.red);
		
		while(true){
			move();
		}
	}
	
	
	/**
	 * Method moves robot to the specific location
	 * 
	 * @param x		x coordinate of the location
	 * @param y		y coordinate of the location
	 */
	public void goToPosition(int x, int y){
		double distance = Math.sqrt(Math.pow(getX() - x, 2) + Math.pow(getY() - y, 2));
		double angle = Math.toDegrees(Math.atan((getY() - y)/(getX() - x))); 
		double newHeading = 0.0;
		
		
		if(x >= getX() && y >= getY()){
			angle = 90 - angle;
		}
		else if(x >= getX() && y <= getY()){
			angle = angle + 90;
		}
		else if(x < getX() && y <= getY()){
			angle = 90 - angle;
			angle = angle + 180;
		}
		else 
			angle = angle + 270;
		
		newHeading = getHeading() - angle;
		
		if(newHeading > 0){
			turnLeft(newHeading);
		}
		else{
			newHeading = -newHeading;
			turnRight(newHeading);
		}
		
		ahead(distance);
		
	}
	
	
	/**
	 * Moves robot
	 */
	public void move(){
		
		goToPosition(200, 300);
		goToPosition(400, 400);
		goToPosition(550, 200);
		
	}
	
	
	/**
	 * Fires enemy if scanned robot is close enough  
	 * 
	 */
	public void onScannedRobot(ScannedRobotEvent e){
		
		
		int angle = 3;
		
		// Calculates firepower
		double power = Math.min(500 / e.getDistance(), 3);
		
		
		if(e.getDistance() < 100)
			angle = 5;
		if(e.getDistance() < 50)
			angle = 7;
		
		// Fires if enemy is not moving or in front of robot
		if(e.getVelocity()== 0 || Math.abs(e.getBearing()) < angle){
			fire(3);
		}
		else if(power > 1.0){
			fire(power);
		}

		scan();
		
	}
	
	/**
	 * Turns robot left when hit by bullet
	 */
	public void onHitByBullet(HitByBulletEvent event){
		
		turnLeft(90);
	}
	
	/**
	 * Moves robot back or forward when hit by other robot 
	 * 
	 */
	public void onHitRobot(HitRobotEvent event){
		
		double heading = event.getBearing();
		
		
		if(Math.abs(heading) <= 90){
			fire(3);
			back(60);
		}
		else{
			ahead(60);
		}
	}
	
	/**
	 * Turns robot left when hit by wall
	 */
	public void onHitWall(HitWallEvent event){
		turnLeft(90);
	}
	
}