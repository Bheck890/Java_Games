package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

private double x;
private double y;

	public Ball(double X, double Y)
	{
		this.x = X;
		this.y = Y;
	}
	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.darkGray);
		g.fillOval((int)x, (int)y, 15, 15);
	}
	
	public int RandNumber()
	{
		return (((int)Math.random())*100);
	}
	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
