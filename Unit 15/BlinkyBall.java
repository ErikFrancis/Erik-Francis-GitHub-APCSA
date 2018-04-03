//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {
		setX(x);
		setY(y);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLUE);
		setXSpeed(1);
		setYSpeed(1); 
   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(Color.BLUE);
		setXSpeed(1);
		setYSpeed(1);
   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(Color.BLUE);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(col);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
   }

   public Color randomColor()
   {
	   int r = (int) (Math.random()*255);		//use Math.random()
	   int g = (int) (Math.random()*255);
	   int b = (int) (Math.random()*255);
	   System.out.println(r+" "+g+" "+b);
	   return new Color(r,g,b);
   }

   @Override
   public void moveAndDraw(Graphics window)
   {
  		draw(window,Color.WHITE);

  		setX(getX()+getXSpeed());
  		setY(getY()+getYSpeed());
		draw(window, randomColor());
   }
}