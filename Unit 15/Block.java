//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		setX(100);
		setY(150);
		setWidth(10);
		setHeight(10);
		setColor(color.BLACK);

	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y)
	{
		setX(x);
		setY(y);
		setWidth(10);
		setHeight(10);
		setColor(color.BLACK);
	}
	
	public Block(int x, int y, int wid, int ht, Color color){
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(color);
	}
	
	public Block(int x, int y, int wid, int ht){
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(color.BLACK);
	}


	
	//add the other set methods
	public void setX(int x){
		xPos = x;
	}
	
	public void setY(int y){
		yPos = y;
	}
	
	@Override
	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void setWidth(int wid){
		width = wid;
	}
	
	public void setHeight(int ht){
		height = ht;
	}

	public void setColor(Color col)
	{
		color = col;
	}

   
	public void draw(Graphics window)
	{
   	//uncomment after you write the set and get methods
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col)
	{
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
   
	public boolean equals(Object obj)
	{
		Block ahk = (Block) obj;
		if(getX() == ahk.getX() && getY() == ahk.getY() && getWidth() == ahk.getWidth() && getHeight() == ahk.getHeight()){
			return true;
		}
		return false;
	}   

   //add the other get methods
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Color getColor(){
		return color;
	}
   //add a toString() method  - x , y , width, height, color
	
	public String toString(){
		return getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor();
	}

}