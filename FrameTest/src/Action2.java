import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Action2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			InetAddress ip = Inet4Address.getLocalHost();
			
			int port = 9789;
			
			JFrame ReceiveFrame = new JFrame();
			ReceiveFrame.setSize(500, 200);
			ReceiveFrame.setVisible(true);
			ReceiveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel info = new JLabel("IP:" + ip + "  " + "Port: " + port);
			info.setPreferredSize(new Dimension (200,200));
			ReceiveFrame.getContentPane().add(info);
			
			
			ReceiveFrame.pack();
			
			
			
			ServerSocket server = new ServerSocket(port);
			Socket client = server.accept();
			
		
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
	}

}
