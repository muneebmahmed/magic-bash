package gui;

import bash.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * This class holds and plays the various mini games
 */
public class MiniGame extends JFrame {
	
	private Bash shell;						//contains a link to shell that spawned this window
	public static final Font code = new Font("Courier New", Font.BOLD, 16);

	private Game game;						//the actual game
	private JPanel editorPane;				//panel holding a code editor
	private JScrollPane editScroll;
	private JTextArea editor;				//holds code to be typed
	private JTextPane editor2;
	private JScrollPane instructionPane;		//panel holding instructions for this task
	private JTextArea instructions;			//holds the actual instructions
	private JButton run;						//executes script
	
	public MiniGame() {

	}
	
	public MiniGame(Game game) {
		this.game = game;
		editor = new JTextArea(30, 30);
		editor.setBackground(Color.DARK_GRAY);
		editor.setFont(code);
		editor.setForeground(Color.WHITE);
		editScroll = new JScrollPane(editor);
		editScroll.setAutoscrolls(true);
		editorPane = new JPanel();
		editorPane.setLayout(new FlowLayout());
		run = new JButton("Run!");
		run.addActionListener(new ButtonListener());
		editor2 = new JTextPane();
		editor2.setSize(30, 30);
		editor2.setMinimumSize(getSize());
		editor2.setBackground(Color.DARK_GRAY);
		editor2.setFont(code);
		editor2.setForeground(Color.WHITE);
		editor2.setAutoscrolls(true);
		editorPane.add(editScroll);
		editorPane.add(run);
		instructions = new JTextArea(7, 100);
		instructions.setText(game.instructions);
		instructions.setEditable(false);
		instructionPane = new JScrollPane(instructions);
		
		this.setLayout(new BorderLayout());
		add(this.game, BorderLayout.CENTER);
		add(editorPane, BorderLayout.WEST);
		add(instructionPane, BorderLayout.NORTH);
		pack();
		setMinimumSize(this.getSize());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String message = editor.getText();
			game.parse(message);
		}
		
	}

}
