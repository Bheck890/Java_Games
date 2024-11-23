package invaderObjects;

import java.awt.Color;
import java.awt.Graphics;


public class Lazer {

	
	
	private int x;
	private int y;
	public int Pos = 0; //position of the laser on the array
	public int xhalf;
	public int type;
	
	public Lazer(int x, int y, int T)
	{
		this.x = x;
		this.y = y;
		type = T;
		//xhalf = (int)(this.x/2);
	}
	
	
	public void paintComponent(Graphics g)
	{
		if(type == 0)
		{
			g.setColor(Color.yellow);
			g.fillRect(x, y, 10, 25);
		}
		else if(type == 1)
		{
			g.setColor(Color.white);
			g.fillRect(x, y, 10, 10);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setPos(int x, int y) //offset from size of ship
	{
		this.x = x + 12;
		this.y = y - 15;
	}
	
	
	public void setx(int x)
	{
		this.x = x;
	}
	public int getx()
	{
		return x;
	}
	
	public void sety(int y)
	{
		this.y = y;
	}
	public int gety()
	{
		return y;
	}
	
	public void setPost(int Pos)
	{
		this.Pos = Pos;
	}
	public int getPos()
	{
		return Pos;
	}
}
