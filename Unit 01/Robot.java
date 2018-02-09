//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      //call head method
      Robot part1 = new Robot();
      part1.head(window);
      
      //call other methods
      Robot part2 = new Robot();
      part2.lowerBody(window);
      
      Robot part3 = new Robot();
      part3.upperBody(window);
      
   }

   public void head( Graphics window )
   {
      window.setColor(Color.GREEN);
      window.fillArc(300, 190, 100, 100, 0, 180);
      window.setColor(Color.BLACK);
      window.fillArc(315, 210, 15, 15, 0, 360);
      window.fillArc(370, 210, 15, 15, 0, 360);
				
   }

   public void upperBody( Graphics window )
   {
	   	window.setColor(Color.GREEN);
	   	window.fillRect(260, 250, 30, 100);
	   	window.fillRect(410, 250, 30, 100);
   }

   public void lowerBody( Graphics window )
   {
	   	window.setColor(Color.GREEN);
	   	window.fillRect(300, 250, 100, 125);
   }
}