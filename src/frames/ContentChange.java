package frames;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

 // !!! Cloud Data !!!
public class ContentChange extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int content2;
	
	public static void main(String[] args) {
		content2 = 0;
		Frame.main(null);
	}
	public void CP(JFrame jf)
	{
		
		if(content2 == 1) //Menu Content to select the Game
		{
			System.out.println("[Pannel] Create Content1 Menu");
			setBackground(new Color(192, 192, 192));
			setLayout(null);
			setVisible(true);
			
			JLabel lblVersion = new JLabel("Version 1.7 ");
			lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVersion.setBounds(10, 400, 224, 19);
			jf.getContentPane().add(lblVersion);
			
			JLabel lblOwner = new JLabel("Created By Brandon Heck");
			lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblOwner.setHorizontalAlignment(SwingConstants.RIGHT);
			lblOwner.setBounds(255, 425, 169, 19);
			jf.getContentPane().add(lblOwner);
		
			Button button = new Button("SNAKE");
			button.setBackground(Color.green);
			button.setForeground(new Color(0, 0, 0));
			button.setFont(new Font("Bauhaus 93", Font.ITALIC, 20));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					removeAll();
					Frame.content = 2;
					Frame.content();
					jf.setVisible(false);
					System.out.println("[Pannel] Finishing Content1 (Starting Snake)");
					
				}
			});
			button.setBounds(10, 10, 155, 92);
			jf.getContentPane().add(button);
			
			Button button2 = new Button("Galiga");
			button2.setBackground(Color.RED);
			button2.setForeground(new Color(0, 0, 0));
			button2.setFont(new Font("Bauhaus 93", Font.ITALIC, 20));
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					removeAll();
					Frame.content = 3;
					Frame.content();
					jf.setVisible(false);
					System.out.println("[Pannel] Starting Galiga");
					
				}
			});
			button2.setBounds(250, 10, 155, 92);
			jf.getContentPane().add(button2);
			
			
			
			Button button3 = new Button("Brick Breaker");
			button3.setBackground(Color.RED);
			button3.setForeground(new Color(0, 0, 0));
			button3.setFont(new Font("Bauhaus 93", Font.ITALIC, 20));
			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					removeAll();
					Frame.content = 4;
					Frame.content();
					jf.setVisible(false);
					System.out.println("[Pannel] Starting Galiga");
					
				}
			});
			button3.setBounds(500, 10, 155, 92);
			jf.getContentPane().add(button3);
		}
		
	}
}
