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

public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	private String status;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,30,30,0);
	}

	public Alien(int x, int y, int s)
	{
		this(x,y,30,30,s);
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		status = "ALIVE";
		speed=s;
		try
		{
//			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(new File("F:\\Documents\\Eclipse\\Unit 17\\src\\alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
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
	
	public String getStatus() 
	{
		return status;
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
		status = "DEAD";
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
		return "";
	}
}
