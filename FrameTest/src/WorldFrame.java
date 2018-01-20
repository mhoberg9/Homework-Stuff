import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WorldFrame {

	public static void main (String [] args) {
		createWindow("WorldFrame", "New Window");
	}
	
	
	public static void  createWindow (String frameName, String content) {
		JFrame frame = new JFrame(frameName);
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JButton button1 = new JButton("Send");
		button1.setSize(250, 150);;
		button1.addActionListener(new Action1());
		panel.add(button1);
		
		
		JButton button2 = new JButton("Receive");
		button2.addActionListener(new Action2());
		panel.add(button2);
		
//		JLabel textcontent = new JLabel(content, SwingConstants.CENTER);
//		textcontent.setPreferredSize(new Dimension (300,100));
//		frame.getContentPane().add(textcontent, BorderLayout.CENTER);
		
		frame.setContentPane(panel);
		frame.pack();
		
	}
	
	

}
