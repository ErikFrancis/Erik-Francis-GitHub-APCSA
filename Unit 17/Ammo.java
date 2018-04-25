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

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(10,10,5);
	}

	public Ammo(int x, int y)
	{
		this(x,y,5);
	}

	public Ammo(int x, int y, int s)
	{
		setX(x);
		setY(y);
		setSpeed(s);
		setWidth(10);
		setHeight(10);
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	
	public void move( String direction )
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

	public boolean collide (Object ahk) {
		MovingThing obj = (MovingThing) ahk;
		if (getY() < obj.getY()+obj.getHeight() && getY() > obj.getY() && getX() < obj.getX()+obj.getWidth() && getX() > obj.getX()) {
			return true;
		} else if (getY() < obj.getY()+obj.getHeight() && getY() > obj.getY() && getX()+getWidth() < obj.getX()+obj.getWidth() && getX()+getWidth() > obj.getX()) {
			return true;
		}
		return false;
	}
	
	public void remove() {
		setX(-10);
		setY(-10);
		setWidth(0);
		setHeight(0);
		setSpeed(0);
	}	
	
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
