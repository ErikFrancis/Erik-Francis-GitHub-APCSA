//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
   }


   //add the other Paddle constructors

   public Paddle(int x, int y) {
		setX(x);
		setY(y);
		setSpeed(5);
		setHeight(10);
		setWidth(10);
		setColor(Color.BLACK);
   }


   public Paddle(int x, int y, int s) {
	    setX(x);
		setY(y);
		setSpeed(s);
		setHeight(10);
		setWidth(10);
		setColor(Color.BLACK);
   }


   public Paddle(int x, int y, int k, int l, int s) {
	    setX(x);
		setY(y);
		setSpeed(s);
		setHeight(l);
		setWidth(k);
		setColor(Color.BLACK);
   }


   public Paddle(int x, int y, int k, int l, Color green, int s) {
	    setX(x);
		setY(y);
		setSpeed(s);
		setHeight(l);
		setWidth(k);
		setColor(green);
   }
   
   //add set methods
   public void setSpeed(int i) {
	   speed = i;
   }
   
   //add get methods
   public int getSpeed() {
	   return speed;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()+getSpeed());
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()-getSpeed());
	   draw(window);
   }
   
   
   //add a toString() method
   public String toString() {
	   return getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor()+" "+getSpeed();
   }
}