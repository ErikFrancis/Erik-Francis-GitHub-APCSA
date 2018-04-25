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

public class Bullets
{
	private ArrayList<Ammo> ammo;
	private int timeofmostrecentshot;
	private int shotdelay;

	public Bullets()
	{
		System.out.println("Bullet Constructor");
		shotdelay = 50;
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo al, int time)
	{
		if (time-timeofmostrecentshot > shotdelay) {
			ammo.add(al);
			timeofmostrecentshot = time;
		}
	}
	
	public void setTimeofmostrecentshot(int i)
	{
		timeofmostrecentshot = i;
	}

	//post - draw each Ammo
	public void drawAll( Graphics window )
	{
		for(int i = 0; i<ammo.size(); i++) {
			ammo.get(i).draw(window);
		}
	}

	public void moveAll()
	{
		moveDirection("UP");
	}

	public void moveDirection(String direction)
	{
		if (direction.equals("RIGHT")){
			for(int i=0; i<ammo.size(); i++) { ammo.get(i).setX(ammo.get(i).getX()+ammo.get(i).getSpeed()); }
		} else if (direction.equals("LEFT")) {
			for(int i=0; i<ammo.size(); i++) { ammo.get(i).setX(ammo.get(i).getX()-ammo.get(i).getSpeed()); }
		} else if (direction.equals("UP")) {
			for(int i=0; i<ammo.size(); i++) { ammo.get(i).setY(ammo.get(i).getY()-ammo.get(i).getSpeed()); }
		} else if (direction.equals("DOWN")) {
			for(int i=0; i<ammo.size(); i++) { ammo.get(i).setY(ammo.get(i).getY()+ammo.get(i).getSpeed()); }
		} else if (direction.equals("STOP")) {
			
		}
	}
	
	public void remove()
	{
		for (int i = 0; i<ammo.size(); i++) {
			if (ammo.get(i).getY() < 0 || ammo.get(i).getY() > 600 || ammo.get(i).getX() < 0 || ammo.get(i).getX() > 800) {
				ammo.remove(i);
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}
	
	public int getLength()
	{
		return ammo.size();
	}
	
	public Ammo getBullet(int i)
	{
		return ammo.get(i);
	}

	public String toString()
	{
		return "" + ammo;
	}
}
