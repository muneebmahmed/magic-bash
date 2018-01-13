package bash;

import java.util.*;

//Should directories and files both extend another class?
public class Directory {
	
	//these are protected so Bash and other directories can modify them
	
	protected String filepath;		//absolute filepath. The filepath of home is ~
	protected String name;			//just the name of this directory, not filepath
	protected Directory home;		//every directory has link to same home directory
	protected Directory back;		//this is the super directory (..)
	protected ArrayList<Directory> folders;	//arraylist of subdirectories
	protected ArrayList<File> files;			//arraylist of files in directory

	public Directory() {
		// TODO Auto-generated constructor stub
		folders = new ArrayList<Directory>();
		files = new ArrayList<File>();
	}
	
	public Directory(String name) {
		this();
		this.name = name;
		filepath = "~";
		home = null;
	}
	
	public void addDirectory(Directory d) {
		d.filepath = filepath + "/" + d.name;
		folders.add(d);
		d.back = this;
	}
	
	public void addFile(File f) {
		f.filepath = filepath + "/" + f.name;		//sets filepath
		files.add(f);
	}
	
	/*
	 * This is the ls command. It prints all directories and files in directory
	 */
	public void ls() {
		
	}
	
	/*
	 * Used when the shell is passed in the name of a folder in this directory instead of the path
	 */
	public void ls(String dirName) {
		for (Directory d : folders) {
			if (dirName.equals(d)) {
				d.ls();
				return;
			}
		}
		//TODO print error message
	}
	
	/*
	 * Used when the shell is passed in a relative filepath (e.g. cd folder instead of cd ~/folder)
	 * In this case, Bash's current directory calls the cd command
	 *  and Bash switches its current directory to this function's output
	 */
	public Directory cd(String name) {
		for (Directory d : folders) {
			if (name.equals(d.name)) {
				return d;
			}
		}
		return null;
	}
	
	/*
	 * I don't think this one is necessary since files should be executed by typing ./file1, not just file1
	 */
	public void execute(String filename) {
		
	}

}
