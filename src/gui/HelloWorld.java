package gui;

import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HelloWorld extends Game {
	
	private JLabel message;

	public HelloWorld() {
		// TODO Auto-generated constructor stub
		setSize(300, 300);
		message = new JLabel();
		instructions = "Welcome to your first program. We'll begin with printing stuff";
		this.add(message);
	}

	
	/*
	 * String from editor pane
	 */
	@Override
	public void parse(String message) {
		//TODO parse to make sure everything is there
		
		this.message.setText(message);
	}

}
