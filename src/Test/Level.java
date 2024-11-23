package Test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Level implements Action {

	
	public static int content;
	public static void main(String[] args) {
		content = 0;
	}
	
	public void CP(JFrame jf)
	{
		
		// Content Pane 1
		if(content == 0)
		{
			
			
		JLabel lblChooseYourLevel = new JLabel("Choose Your Level");
		lblChooseYourLevel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblChooseYourLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourLevel.setForeground(new Color(0, 100, 0));
		lblChooseYourLevel.setBounds(103, 11, 215, 70);
		jf.getContentPane().add(lblChooseYourLevel);
			
		Button button = new Button("Easy");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button.setBounds(180, 122, 70, 22);
		jf.getContentPane().add(button);
		
		Button button2 = new Button("Medium");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button2.setBounds(180, 196, 70, 22);
		jf.getContentPane().add(button2);
		
		Button button3 = new Button("Hard");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button.setVisible(false);
				button2.setVisible(false);
				button3.setVisible(false);
				jf.setSize(600, 600);
				lblChooseYourLevel.setVisible(false);
				content = 2;
				CP(jf);
				
			}
		});
		button3.setBounds(180, 280, 70, 22);
		jf.getContentPane().add(button3);
		
		
		
		
		}
		// Content pane 2
		if(content == 2)
		{
			Button button = new Button("Easy2");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			button.setBounds(180, 122, 70, 22);
			jf.getContentPane().add(button);
			
			Button button2 = new Button("Medium2");
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			button2.setBounds(180, 196, 70, 22);
			jf.getContentPane().add(button2);
			
			Button button3 = new Button("Hard2");
			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			button3.setBounds(180, 280, 70, 22);
			jf.getContentPane().add(button3);
			
			JLabel lblChooseYourLevel = new JLabel("Choose Your Level2");
			lblChooseYourLevel.setFont(new Font("Tahoma", Font.ITALIC, 20));
			lblChooseYourLevel.setHorizontalAlignment(SwingConstants.CENTER);
			lblChooseYourLevel.setForeground(new Color(0, 100, 0));
			lblChooseYourLevel.setBounds(103, 11, 215, 70);
			jf.getContentPane().add(lblChooseYourLevel);
		}
	}
		

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}
}
