package gui;

import bash.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

/*
 * This class holds and plays the various mini games
 */
public class MiniGame extends JFrame {
	
	private Bash shell;						//contains a link to shell that spawned this window
	public static final Font code = new Font("Courier New", Font.PLAIN, 12);

	private JPanel game;						//the actual game
	private JPanel editorPane;				//panel holding a code editor
	private JTextArea editor;				//holds code to be typed
	private JScrollPane instructionPane;		//panel holding instructions for this task
	private JTextArea instructions;			//holds the actual instructions
	private JButton run;						//executes script
	
	public MiniGame() {
		// TODO Auto-generated constructor stub
		editor = new JTextArea(100, 300);
		editor.setBackground(Color.DARK_GRAY);
		editor.setFont(code);
		editorPane = new JPanel();
		editorPane.setLayout(new FlowLayout());
		run = new JButton("Run!");
		editorPane.add(editor);
		editorPane.add(run);
		instructions = new JTextArea(300, 200);
		instructions.setEditable(false);
		instructionPane = new JScrollPane(instructions);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
