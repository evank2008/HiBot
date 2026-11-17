package main;
import java.awt.event.WindowListener;

import javax.swing.*;
public class ControlPanel {

	JFrame frame;
	JPanel panel;
	public static JButton quitButton;
	public ControlPanel() {
		frame = new JFrame("hi CP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		quitButton = new JButton("Quit");
		quitButton.addActionListener(e->{
			HiBot.jda.shutdown();
			frame.dispose();
		});
		panel.add(quitButton);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
}
