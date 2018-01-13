package bash;

import java.util.*;
import gui.*;

public class File implements Comparable<File> {	//implements comparable for sorting
	
	protected String filepath;		//absolute filepath, including file name
	protected String name;			//just the name of the file, not including filepath
	protected boolean executable; //says if the file is .exe
	private String message;
	MiniGame mg;					//the game to launch (if executable)

	public File() {
		// TODO Auto-generated constructor stub
	}
	
	public File(String name) {
		this.name = name;
		executable = false;
		if(name.contains(".exe") || name.contains(".bin")) {
			executable = true;
		}
		filepath = null;
		message = "Created  at " + java.lang.System.currentTimeMillis();
	}
	
	/*
	 * Executes this file and launches the appropriate mini game
	 * Perhaps this function should check the name of the file, and then create a new instance of the appropriate class?
	 */
	public void execute() {
		if (name.equals("helloworld.bin")) {
			mg = new MiniGame(new HelloWorld());
			return;
		}
		//print error message
	}
	
	@Override
	public int compareTo(File o) {	//this method allows an ArrayList of Files to be sorted alphabetically
		return name.compareTo(o.name);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isExecutable() {
		return executable;
	}

	public void setExecutable(boolean executable) {
		this.executable = executable;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
