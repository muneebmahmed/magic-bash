package gui;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class Game extends JPanel {
	
	protected String instructions;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public Game(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public Game(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void parse(String message);

}
