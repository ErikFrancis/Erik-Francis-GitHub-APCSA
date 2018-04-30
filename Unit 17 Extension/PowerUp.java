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

public class PowerUp extends MovingThing
{
	private int speed;
	private Image image;
	private String status;

	public PowerUp()
	{
		this(0,0,30,30,0);
	}

	public PowerUp(int x, int y)
	{
		this(x,y,30,30,0);
	}

	public PowerUp(int x, int y, int s)
	{
		this(x,y,30,30,s);
	}

	public PowerUp(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		status = "ALIVE";
		speed=s;
		try
		{
//			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(new File("H:\\APCSA\\Workspace\\Unit 17 Extension\\src\\PowerUp.jpg"));
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
		if (getY() > obj.getY() &&  getY() < obj.getY()+obj.getHeight() && (getX() > obj.getX() &&  getX() < obj.getX()+obj.getWidth() || getX()+getWidth() > obj.getX() &&  getX()+getWidth() < obj.getX()+obj.getWidth())) {
			return true;
		} 
		if (getY()+getHeight() > obj.getY() &&  getY()+getHeight() < obj.getY()+obj.getHeight() && (getX() > obj.getX() &&  getX() < obj.getX()+obj.getWidth() || getX()+getWidth() > obj.getX() &&  getX()+getWidth() < obj.getX()+obj.getWidth())) {
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "";
	}
}
