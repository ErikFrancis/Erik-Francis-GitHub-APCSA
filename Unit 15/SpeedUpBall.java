//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

	   public SpeedUpBall()
	   {
			super();
	   }

	   public SpeedUpBall(int x, int y)
	   {
			setX(x);
			setY(y);
			setWidth(10);
			setHeight(10);
			setColor(Color.BLUE);
			setXSpeed(1);
			setYSpeed(1); 
	   }

	   public SpeedUpBall(int x, int y, int wid, int ht)
	   {
			setX(x);
			setY(y);
			setWidth(wid);
			setHeight(ht);
			setColor(Color.BLUE);
			setXSpeed(1);
			setYSpeed(1);
	   }

	   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
	   {
			setX(x);
			setY(y);
			setWidth(wid);
			setHeight(ht);
			setColor(Color.BLUE);
			setXSpeed(xSpd);
			setYSpeed(ySpd);
	   }

	   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
	   {
			setX(x);
			setY(y);
			setWidth(wid);
			setHeight(ht);
			setColor(col);
			setXSpeed(xSpd);
			setYSpeed(ySpd);
	   }
@Override
   public void setXSpeed( int xSpd )
   {
	if (xSpd<0) {
		super.setXSpeed(xSpd-1);
	}else {
		super.setXSpeed(xSpd+1);
	}

   }
@Override
   public void setYSpeed( int ySpd )
   {
	if(ySpd<0) {
		super.setYSpeed(ySpd-1);
	} else {
		super.setYSpeed(ySpd+1);
	}

   }
}

