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

public class AlienHorde
{
	private ArrayList<Alien> aliens;
	private int numberofaliens;
	private int spcbtwaliens;
	private String directionh, directionv;
	private int height;
	private int speed;

	public AlienHorde(int size, int starty, int startx, int spacing)
	{
		speed = 2;
		height = starty;
		directionh = "RIGHT";
		directionv = "UP";
		spcbtwaliens = spacing;
		System.out.println("AlienHorde Constructor");
		numberofaliens = 0;
		aliens = new ArrayList<Alien>();
		for (int i = 0; i<size; i++) {
			System.out.println("makealien");
			Alien tempalien = new Alien(((numberofaliens*spcbtwaliens)+startx),starty,35,35,speed);
			aliens.add(tempalien);
			numberofaliens++;
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
		numberofaliens++;
	}

	public void drawAll( Graphics window )
	{
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i).draw(window);
		}
	}

// MOVEMENT PATTERNS FOR ALIENS
	
	public void setSpeed(int SPEED)
	{
		speed = SPEED;
		for (int i=0; i<aliens.size(); i++)
		{
			aliens.get(i).setSpeed(speed);
		}
	}
	
	public void moveAllHorizontal(int rb, int lb)
	{
		for (int i=aliens.size()-1; i>=0; i--) {
			if (aliens.get(i).getX() > rb && aliens.get(i).getStatus().equals("ALIVE")) {
				System.out.println("left " + i);
				directionh = "LEFT";
			} 
		}
		for (int i=0; i<aliens.size(); i++) {
			if (aliens.get(i).getX() < lb && aliens.get(i).getStatus().equals("ALIVE")) {
				System.out.println("right" + i);
				directionh = "RIGHT";
			}
		}
		moveDirection(directionh);
	}
	
	public void moveAllVertical(int top, int bot)
	{
		for (int i=aliens.size()-1; i>=0; i--) {
			if (aliens.get(i).getY() > bot && aliens.get(i).getStatus().equals("ALIVE")) {
				System.out.println("UP " + i);
				directionv = "UP";
			} 
		}
		for (int i=0; i<aliens.size(); i++) {
			if (aliens.get(i).getY() < top && aliens.get(i).getStatus().equals("ALIVE")) {
				System.out.println("DOWN " + i);
				directionv = "DOWN";
			}
		}
		moveDirection(directionv);
	}
	
	public void moveDirection(String direction)
	{
		if (direction.equals("RIGHT")){
			for(int i=0; i<aliens.size(); i++) { aliens.get(i).setX(aliens.get(i).getX()+aliens.get(i).getSpeed()); }
		} else if (direction.equals("LEFT")) {
			for(int i=0; i<aliens.size(); i++) { aliens.get(i).setX(aliens.get(i).getX()-aliens.get(i).getSpeed()); }
		} else if (direction.equals("UP")) {
			for(int i=0; i<aliens.size(); i++) { aliens.get(i).setY(aliens.get(i).getY()-aliens.get(i).getSpeed()); }
		} else if (direction.equals("DOWN")) {
			for(int i=0; i<aliens.size(); i++) { aliens.get(i).setY(aliens.get(i).getY()+aliens.get(i).getSpeed()); }
		} else if (direction.equals("STOP")) {
			
		}
	}

	public void removeDeadOnes()
	{
		for(int i=0; i<aliens.size(); i++) {
			if (aliens.get(i).getStatus().equals("DEAD")) {
				aliens.remove(i);
			}
		}
	}

	public int getLength() {
		return aliens.size();
	}
	
	public Alien getAlien(int index) {
		return aliens.get(index);
	}
	
	public String toString()
	{
		return "" + aliens;
	}
}
