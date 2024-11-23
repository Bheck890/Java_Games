package invaderObjects;

import java.awt.Color;
import java.awt.Graphics;

//import frames.Frame;

public class AlienShip{
	
	private int L;
	public int x;
	public int y;
	public int size = 20;
	public int sizeHalf = (size/2);
	public AlienShip(int x, int y, int L)
	{
		this.x = x;
		this.y = y;
		this.L = L;
	}
	
	public void paintComponent(Graphics g)
	{
		if(L == 1)
		{
			g.setColor(Color.BLUE);
			g.fillRect(x, y, size, size);
			//Frame.jf3.setBackground(Color.BLACK);
		}
		else if(L == 2)
		{
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, size, size);
			//Frame.jf3.setBackground(Color.BLACK);
		}
		else if(L == 3)
		{
			g.setColor(Color.YELLOW);
			g.fillRect(x, y, size, size);
			//Frame.jf3.setBackground(Color.BLACK);
		}
		else if(L == 4)
		{
			g.setColor(Color.RED);
			g.fillRect(x, y, size, size);
			//Frame.jf3.setBackground(Color.BLACK);
		}
		else 
		{ //Error Ship
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 40, 10);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}
	
	public void setx(int x) {
		this.x = x;
	}

	public int getx() {
		return x;
	}

	public void sety(int y) {
		this.y = y;
	}

	public int gety() {
		return y;
	}
	
}
