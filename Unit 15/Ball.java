//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200,10,10);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int i, int j) {
		setX(i);
		setY(j);
		setHeight(10);
		setWidth(10);
		setColor(Color.BLACK);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j, int k, int l) {
		setX(i);
		setY(j);
		setWidth(k);
		setHeight(l);
		setColor(Color.BLACK);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j, int k, int l, Color blue) {
		setX(i);
		setY(j);
		setWidth(k);
		setHeight(l);
		setColor(blue);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j, int k, int l, Color blue, int m, int n) {
		setX(i);
		setY(j);
		setWidth(k);
		setHeight(l);
		setColor(blue);
		setXSpeed(m);
		setYSpeed(n);
	}
	
	
	//add the set methods
	public void setXSpeed(int x){
	   	xSpeed = x;
   	}
   	
   	public void setYSpeed(int y){
	   	ySpeed = y;
   	}

   	public void moveAndDraw(Graphics window)
   	{
   		draw(window,Color.WHITE);

   		setX(getX()+getXSpeed());
   		setY(getY()+getYSpeed());

		draw(window);
   }
   
   public boolean equals(Object obj)
	{
		Ball ahk = (Ball) obj;
		if(getX() == ahk.getX() && getY() == ahk.getY() && getWidth() == ahk.getWidth() && getHeight() == ahk.getHeight() && getColor() == ahk.getColor() && getXSpeed() == ahk.getXSpeed() && getYSpeed() == ahk.getYSpeed()){
			return true;
		}

		return false;
	}   

   //add the get methods
   public int getXSpeed(){
	   return xSpeed;
   }

   public int getYSpeed(){
	   return ySpeed;
   }

   //add a toString() method
   public String toString(){
	   return getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor()+" "+getXSpeed()+" "+getYSpeed();
   }

@Override
public boolean didCollideLeft(Object ahk) {
	// [obj] <- [ball]
	Block obj = (Block) ahk;
	if((getX()<=obj.getX()+obj.getWidth()-Math.abs(getXSpeed()) && getX()>=obj.getX()) && (getY() >= obj.getY() && getY() + getHeight() <= obj.getY() + obj.getHeight())){
		return true;
	}
	return false;
}

@Override
public boolean didCollideRight(Object ahk) {
	// [ball] -> [obj]
	Block obj = (Block) ahk;
	if((getX()+getWidth()>=obj.getX()-Math.abs(getXSpeed()) && getX()>=obj.getX()) && (getY() >= obj.getY() && getY() + getHeight() <= obj.getY() + obj.getHeight())){
		return true;
	}
	return false;
}

@Override
public boolean didCollideTop(Object ahk) {
	// [obj above]/^[ball]
	Block obj = (Block) ahk;
	if(getY()+getHeight()>=obj.getY()-Math.abs(getYSpeed())) {
		return true;
	}
	return false;
}

@Override
public boolean didCollideBottom(Object ahk) {
	// [ball above]/[obj]
	Block obj = (Block) ahk;
	if(getY()<=obj.getY()+obj.getHeight()-Math.abs(getYSpeed())) {
		return true;
	}
	return false;
}
   
}