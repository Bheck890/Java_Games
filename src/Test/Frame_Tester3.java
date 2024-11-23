package Test;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class Frame_Tester3 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		Frame_Tester3 frame = new Frame_Tester3();
		frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	JFrame jf = new JFrame(); 
	//int playerindex = 0;
	//Graphics d;
	
	@SuppressWarnings({ })
	public Frame_Tester3() 
	{
		//getContentPane().setBackground(new Color(30, 144, 255));
		//getContentPane().setLayout(null);
		
		
		jf.setSize(600, 800);
		jf.setVisible(true);
		jf.getContentPane().setVisible(true);
		
		
		System.out.println("[Pannel] Create Content3");
		//System.out.println("Game Over Screen");
		//jf.getContentPane().setVisible(true);
		//jf.getContentPane().setBackground(Color.WHITE);
		
		jf.getContentPane().repaint();
		//jf.paint(d);
		
		//paint(d);
	}
	
	
	public void paintComponent(Graphics g) // Repaint / Render
	{
		super.paintComponents(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(100, 50, 50, 100);
		
		g.setColor(Color.BLUE);
		g.fillRect(200, 40, 50, 10);
		
		g.setColor(Color.ORANGE);
		g.fillRect(300, 45, 50, 10);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
		
		
		//HAVE Read this in file and Export in this format 
		/* 
		 * For Difficulty: (Difficulty)
		 * 1. (Number)
		 * 2. (Number)
		 * 3. (Number)
		 * 
		 * So on so forth...
		 */
		
		
		// Variable-Panel in Frame System Started in v.0.10
		/*
		// Review how YOU Did this and do it for this Game!!!!
		JFrame jf3 = new JFrame();
		jf3.setVisible(false);
		Level lev = new Level();
		lev.CP(jf3);
		
		lev.setVisible(false);
		jf3.getContentPane().setBackground(new Color(255, 255, 255));
		jf3.setTitle("Choose Level");
		jf3.setResizable(false);
		jf3.setSize(450, 500);
		jf3.setBackground(new Color(205, 133, 63));
		jf3.getContentPane().setLayout(null);
		jf3.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf3.setVisible(true);
		*/
		
		
		
		
		
		
		
		
		
	
}
