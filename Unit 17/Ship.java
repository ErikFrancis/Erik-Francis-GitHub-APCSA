//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
		this(x,y,10,10,10);
	}

	public Ship(int x, int y, int s)
	{
		this(x,y,10,10,s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
//			URL url = getClass().getResource("H:\\APCSA\\Workspace\\Unit 17\\src\\ship.jpg");
			image = ImageIO.read(new File("F:\\Documents\\Eclipse\\Unit 17\\src\\ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("error in constructor");
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		if (direction.equals("RIGHT")){
			setX(getX()+getSpeed());
		} else if (direction.equals("LEFT")) {
			setX(getX()-getSpeed());
		} else if (direction.equals("UP")) {
			setY(getY()-getSpeed());
		} else if (direction.equals("DOWN")) {
			setY(getY()+getSpeed());
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public void remove() {
		setX(-10);
		setY(-10);
		setWidth(0);
		setHeight(0);
		setSpeed(0);
	}
	
	public boolean collide (Object ahk) {
		MovingThing obj = (MovingThing) ahk;
		if (getY() < obj.getY()+obj.getHeight() && getY() > obj.getY() && getX() < obj.getX()+obj.getWidth() && getX() > obj.getX()) {
			return true;
		} else if (getY() < obj.getY()+obj.getHeight() && getY() > obj.getY() && getX()+getWidth() < obj.getX()+obj.getWidth() && getX()+getWidth() > obj.getX()) {
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
