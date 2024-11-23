package invaderObjects;

import java.awt.Color;
import java.awt.Graphics;

import frames.Frame;

public class Ship{
	
	private int x;
	private int y;
	public int width = 24;
	public int height = 40;
	
	// THIS IS THE CORE SHIP THE PLAYER USES!!!!
	public Ship(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	public void paintComponent(Graphics g)
	{
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, width, height);
		Frame.jf3.setBackground(Color.BLACK);
		
		
		 
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

}
