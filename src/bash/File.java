package bash;

import java.util.*;

public class File implements Comparable<File> {	//implements comparable for sorting
	
	protected String filepath;		//absolute filepath, including file name
	protected String name;			//just the name of the file, not including filepath
	private boolean executable; //says if the file is .exe
	private String message;

	public File() {
		// TODO Auto-generated constructor stub
	}
	
	public File(String name) {
		this.name = name;
		if(name.contains(".exe"))
		{
			setExecutable(true);
		}
		else
		{
			setExecutable(false);
		}
		filepath = null;
		message = "Created  at " + java.lang.System.currentTimeMillis();
	}
	
	/*
	 * Executes this file and launches the appropriate mini game
	 * Perhaps this function should check the name of the file, and then create a new instance of the appropriate class?
	 */
	public void execute() {
		
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

}
