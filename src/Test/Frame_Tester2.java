package Test;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class Frame_Tester2 implements KeyListener {

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Frame_Tester2 frame = new Frame_Tester2();
		//frame.jp.setVisible(false);
		
	}

	/**
	 * Create the frame.
	 */
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	int chara = 0;
	
	public Frame_Tester2() 
	{
		
		
		jf.setTitle("SET GAMER TAG");
		jf.setSize(300,300);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.setBackground(new Color(192, 192, 192));
		jp.setLayout(null);
		
		JTextField txtNameHere;
		txtNameHere = new JTextField();
		txtNameHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNameHere.setText("");
			}
		});
		txtNameHere.setText("Name Here");
		txtNameHere.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				chara ++;
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					chara --;
				}
				if(chara == 20)
				{
					txtNameHere.setText("");
					chara = 0;
				}
			}
		});
		txtNameHere.setBounds(28, 93, 137, 28);
		
		jp.add(txtNameHere);
		txtNameHere.setColumns(10);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblScore.setBounds(28, 157, 69, 28);
		jp.add(lblScore);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDifficulty.setBounds(28, 190, 86, 28);
		jp.add(lblDifficulty);
		
		JLabel lblScore_1 = new JLabel("Score");
		lblScore_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblScore_1.setBounds(133, 166, 76, 19);
		jp.add(lblScore_1);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLevel.setBounds(133, 199, 76, 19);
		jp.add(lblLevel);
		
		JLabel lblEnterYourGame = new JLabel("Enter Your Game Tag Here:");
		lblEnterYourGame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterYourGame.setBounds(28, 54, 167, 28);
		jp.add(lblEnterYourGame);
		
		JLabel lblMaximumOf = new JLabel("Maximum of 20 Characters");
		lblMaximumOf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMaximumOf.setBounds(28, 120, 137, 19);
		jp.add(lblMaximumOf);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(txtNameHere.getText());
				
			}
		});
		btnSelect.setForeground(Color.BLUE);
		btnSelect.setBackground(Color.LIGHT_GRAY);
		btnSelect.setBounds(175, 96, 89, 23);
		jp.add(btnSelect);
		jp.setVisible(true);
		
		
		jf.repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
