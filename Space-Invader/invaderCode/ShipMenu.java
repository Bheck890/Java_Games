package invaderCode;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import frames.Frame;

@SuppressWarnings("serial")
public class ShipMenu extends JPanel implements KeyListener{

public static void main(String[] args) 
{
	Frame.content = 3;
	Frame.content();
}
	

	GaligaGame GG = new GaligaGame();


public void shipBegin() {
		
	GG.setFocusable(true);
	GG.addKeyListener(this);
	//GG.addKeyListener(new KeyInputHandler());
	GG.setFocusTraversalKeysEnabled(false);
	
	setFocusable(true);
	addKeyListener(this);
	//addKeyListener(new KeyInputHandler());
	setFocusTraversalKeysEnabled(false);
	
	Frame.jf3.setFocusable(true);
	Frame.jf3.addKeyListener(this);
	//Frame.jf3.addKeyListener(new KeyInputHandler());
	Frame.jf3.setFocusTraversalKeysEnabled(false);
	
	
		Frame.jf1.setVisible(false);
		// Call for AI to start
		
		setLayout(null);
		setVisible(true);
		
		JLabel lblVersion = new JLabel("Version 1.8 ");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVersion.setForeground(Color.white);
		lblVersion.setBounds(450, 450, 224, 19);
		Frame.jf3.add(lblVersion);
		
		Button button = new Button("Begin");
		button.setBackground(Color.GRAY);
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Bauhaus 93", Font.ITALIC, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				
				// Start game here
				// as player defetes 2 Rounds Level Rises
				//StartGame();
				Frame.jf3.setContentPane(GG);
				Frame.jf3.setLayout(null);
				GG.setFocusable(true);
				//GG.addKeyListener(this);
				GG.setFocusTraversalKeysEnabled(false);
				
				GG.Start();
				Frame.jf3.setVisible(true);
				GG.setVisible(true);
				System.out.println("[Galiga menu] Start Game");
				GG.setBackground(Color.black);
				
			}
		});
		button.setBounds(240, 100, 100, 50);
		Frame.jf3.add(button);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Pressed");
		GG.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		GG.keyReleased(e);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

