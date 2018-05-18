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
   public Paddle(int x, int y){
	   super(x, y);
	   speed=5;
   }
   public Paddle(int x, int y , int width) {
	   super(x, y, width);
	   speed=5;
   }
   public Paddle(int x, int y, int width, int height, int spd) {
	   super(x, y, width, height);
	   speed=spd;
   }
   public Paddle(int x, int y, int width, int height, Color color, int spd) {
	   super(x, y, width, height, color);
	   speed=spd;
   }
   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()+speed);
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY()-speed);
	   draw(window);
   }
   
   public void moveLeftAndDraw(Graphics window){
	   draw(window, Color.WHITE);
	   setX(getX()-speed);
	   draw(window);
   }

   public void moveRightAndDraw(Graphics window){
	   draw(window, Color.WHITE);
	   setX(getX()+speed);
	   draw(window);
   }
   //add get methods
   public int getSpeed() {
	   return speed;
   }
   
   //add a toString() method
   public String toString() {
	   String output = this.getX()+" "+this.getY()+" "+this.getWidth()+" "+this.getHeight()+" "+this.getColor()+" "+speed;
	   return output;
   }
}