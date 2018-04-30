//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class PowerUpList
{
	private ArrayList<PowerUp> powerup;
	private int numberofpowerup;
	private int spcbtwpowerup;
	private String directionh, directionv;
	private int height;
	private int speed;

	public PowerUpList(int size, int starty, int startx, int spacing)
	{
		speed = 2;
		height = starty;
		directionh = "RIGHT";
		directionv = "UP";
		spcbtwpowerup = spacing;
		System.out.println("PowerUpHorde Constructor");
		numberofpowerup = 0;
		powerup = new ArrayList<PowerUp>();
		for (int i = 0; i<size; i++) {
			System.out.println("makePowerUp");
			PowerUp tempPowerUp = new PowerUp(((numberofpowerup*spcbtwpowerup)+startx),starty,35,35,speed);
			powerup.add(tempPowerUp);
			numberofpowerup++;
		}
	}

	public void add(PowerUp al)
	{
		powerup.add(al);
		numberofpowerup++;
	}

	public void drawAll( Graphics window )
	{
		for(int i = 0; i<powerup.size(); i++) {
			powerup.get(i).draw(window);
		}
	}

// MOVEMENT PATTERNS FOR powerup
	
	public void setSpeed(int SPEED)
	{
		speed = SPEED;
		for (int i=0; i<powerup.size(); i++)
		{
			powerup.get(i).setSpeed(speed);
		}
	}
	
	public void moveAllHorizontal(int rb, int lb)
	{
		for (int i=powerup.size()-1; i>=0; i--) {
			if (powerup.get(i).getX() > rb && powerup.get(i).getStatus().equals("ALIVE")) {
				System.out.println("left " + i);
				directionh = "LEFT";
			} 
		}
		for (int i=0; i<powerup.size(); i++) {
			if (powerup.get(i).getX() < lb && powerup.get(i).getStatus().equals("ALIVE")) {
				System.out.println("right" + i);
				directionh = "RIGHT";
			}
		}
		moveDirection(directionh);
	}
	
	public void moveAllVertical(int top, int bot)
	{
		for (int i=powerup.size()-1; i>=0; i--) {
			if (powerup.get(i).getY() > bot && powerup.get(i).getStatus().equals("ALIVE")) {
				System.out.println("UP " + i);
				directionv = "UP";
			} 
		}
		for (int i=0; i<powerup.size(); i++) {
			if (powerup.get(i).getY() < top && powerup.get(i).getStatus().equals("ALIVE")) {
				System.out.println("DOWN " + i);
				directionv = "DOWN";
			}
		}
		moveDirection(directionv);
	}
	
	public void moveDirection(String direction)
	{
		if (direction.equals("RIGHT")){
			for(int i=0; i<powerup.size(); i++) { powerup.get(i).setX(powerup.get(i).getX()+powerup.get(i).getSpeed()); }
		} else if (direction.equals("LEFT")) {
			for(int i=0; i<powerup.size(); i++) { powerup.get(i).setX(powerup.get(i).getX()-powerup.get(i).getSpeed()); }
		} else if (direction.equals("UP")) {
			for(int i=0; i<powerup.size(); i++) { powerup.get(i).setY(powerup.get(i).getY()-powerup.get(i).getSpeed()); }
		} else if (direction.equals("DOWN")) {
			for(int i=0; i<powerup.size(); i++) { powerup.get(i).setY(powerup.get(i).getY()+powerup.get(i).getSpeed()); }
		} else if (direction.equals("STOP")) {
			
		}
	}

	public void removeDeadOnes()
	{
		for(int i=0; i<powerup.size(); i++) {
			if (powerup.get(i).getStatus().equals("DEAD")) {
				powerup.remove(i);
			}
		}
	}

	public int getLength() {
		return powerup.size();
	}
	
	public PowerUp getPowerUp(int index) {
		return powerup.get(index);
	}
	
	public String toString()
	{
		return "" + powerup;
	}
}
