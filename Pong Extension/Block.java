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
		xPos=0;
		yPos=0;
		width=0;
		height=0;
		color=Color.BLACK;
	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y) {
		setPos(x, y);
		width=10;
		height=10;
		color=Color.BLACK;
	}
	public Block(int x, int y, int width) {
		setPos(x, y);
		setWidth(width);
		height =10;
		color=Color.BLACK;
	}
	public Block(int x, int y, int width, int height){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		color=Color.BLACK;
	}
	public Block(int x, int y, int width, int height, Color col){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setColor(col);
	}
   //add the other set methods
  
	public void setX(int x){
		xPos=x;
	}
	public void setY(int y){
		yPos=y;
	}
	public void setPos(int x, int y){
		xPos=x;
		yPos=y;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
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
		Block block = (Block) obj;
		if(xPos==block.getX() && yPos==block.getY() && width==block.getWidth() && height==block.getHeight()){
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
	public Color getColor() {
		return color;
	}

   //add a toString() method  - x , y , width, height, color
	
	public String toString(){
		String output = xPos + " " + yPos + " " + width + " " + height + " " + color;
		return output;
	}
}