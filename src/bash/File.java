package bash;

import java.util.*;

public class File implements Comparable<File> {	//implements comparable for sorting
	
	protected String filepath;		//absolute filepath, including file name
	protected String name;			//just the name of the file, not including filepath

	public File() {
		// TODO Auto-generated constructor stub
	}
	
	public File(String name) {
		this.name = name;
		filepath = null;
	}
	
	/*
	 * Executes this file and launches the appropriate mini game
	 */
	public void execute() {
		
	}
	
	@Override
	public int compareTo(File o) {	//this method allows an ArrayList of Files to be sorted alphabetically
		return name.compareTo(o.name);
	}

}
