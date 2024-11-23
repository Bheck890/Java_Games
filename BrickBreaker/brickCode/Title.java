package brickCode;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import frames.Frame;

public class Title extends JPanel implements KeyListener, MouseListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	brickCode BC = new brickCode();
	
	public static void main(String[] args) 
	{
		Frame.content = 4;
		Frame.content();
	}
	
	public void BrickBegin() 
	{
		Frame.jf1.setVisible(false);
		
		setLayout(null);
		setVisible(true);
		
		
		
		Frame.jf4.setFocusable(true);
		Frame.jf4.addKeyListener(this);
		Frame.jf4.addMouseListener((MouseListener) this);
		Frame.jf4.setFocusTraversalKeysEnabled(false);
		
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		setFocusable(true);
		
		BC.addKeyListener(this);
		BC.setFocusTraversalKeysEnabled(false);
		BC.setFocusable(true);
		
		JLabel lbHighScore = new JLabel("HighScore: ");
		lbHighScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbHighScore.setForeground(Color.white);
		lbHighScore.setBounds(100, 450, 224, 19);
		Frame.jf4.add(lbHighScore);
		
		
		JLabel lblVersion = new JLabel("Version 0.1 ");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVersion.setForeground(Color.white);
		lblVersion.setBounds(450, 450, 224, 19);
		Frame.jf4.add(lblVersion);
		
		Button button = new Button("Begin");
		button.setBackground(Color.GRAY);
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Bauhaus 93", Font.ITALIC, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				Frame.jf4.setContentPane(BC);
				Frame.jf4.setLayout(null);
				
				BC.setFocusable(true);
				BC.setFocusTraversalKeysEnabled(false);
				
				
				BC.Start();
				Frame.jf4.setVisible(true);
				BC.setVisible(true);
			}
		});
		button.setBounds(240, 100, 100, 50);
		Frame.jf4.add(button);
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		BC.keyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		BC.keyTyped(e);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
