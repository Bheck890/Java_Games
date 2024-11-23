package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

private double x;
private double y;
private int height = 15;
private int width = 150;

	public Paddle(double X, double Y)
	{
		this.x = X;
		this.y = Y;
	}
	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.GRAY);
		g.fillRect((int)x, (int)y, width, height);
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
