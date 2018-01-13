package bash;

import java.util.ArrayList;
import java.util.Scanner;

public class Bash implements Runnable {		//should this class implement Runnable?
	
	private Directory current;	//this is the current directory
	private Directory home;		//contains link to home directory
	private ArrayList<Directory> directories;	//should this class have a list of all directories?
	private ArrayList<File> files;	//list of all the files
	private int helpCount;		//counter for the level the help list is currently at
	private String userName;

	public Bash() {
		directories = new ArrayList<Directory>();
		files = new ArrayList<File>();
		helpCount = 0;
		userName = "root";
	}
	
	public void setName(String name) {
		userName = name;
	}
	
	public void setHome(Directory home) {
		this.home = home;
	}
	
	public void setCurrent(Directory current) {
		this.current = current;
	}
	
	public void addDirectory(Directory d) {
		directories.add(d);
		files.addAll(d.files);
	}
	
	//parses input
	public int parse(String input) {
		//if just a filepath is passed in (e.g ~/folder/file) then that file is found and executed
		//if this is a directory and not a file, then an error message is printed
		//using .. is valid, so I'd suggest taking .. and replacing it with the filepath of the current directory's super directory
		//same for . which refers to the current directory
		//e.g. if file1 is located in ~/folder, and the current directory is folder, it should be able to be
			//executed by typing ~/folder/file1, or by just typing ./file1
		//typing open followed by a filepath should do this same thing, but only if time permits
		
		//if cd with an absolute filepath (e.g. cd ~/folder) is passed in that cd to that directory
		//if just cd then cd to home
		//if cd with a relative filepath (e.g. cd folder) is passed then the current directory's cd command is called
		
		//help brings up help list
		//help followed by a command name lists the usage of that command
		
		//quit/exit quits the game. In this case, return 1
		if (input.equals("quit") || input.equals("exit") || input.equals("logout")) { return 1; }
		//pwd prints out the filepath of the current directory
		if (input.equals("pwd")) { System.out.println(current.filepath); }
		//whoami prints out the userName of the user
		if (input.equals("whoami")) { System.out.println(userName); }
		//if none of the above, then print error message stating unrecognized input
		System.out.println("Your input couldn't be recognized" );
		return 0;
	}
	
	/*
	 * cd Command to switch the current directory
	 */
	public void cd(String path) {
		if(path == null || path.compareTo("") == 0)
		{
			this.current = this.home;
			return;
		}
		else
		{
			for(int i = 0; i < this.directories.size(); i++)
			{
				if(path.compareTo(directories.get(i).filepath) == 0)
				{
					this.current = directories.get(i);
				}
			}
			//searching for directory match
		}
		this.current = this.current;//do nothing if you don't find the directory// potentially would want an error message
		return;
		//if path is null switch to home
		//otherwise, search directories for matching path
	}
	
	/*
	 * when ls is called and passed a filepath, it should show contents of that directory
	 * this function should find the directory corresponding to the path, and call its ls function
	 */
	public void ls(String path) {
		for (Directory d : directories) {
			if (path.equals(d.filepath)) {
				d.ls();
				return;
			}
		}
		current.ls(path);
	}
	
	/*
	 * Executes a file when the absolute filepath is passed to the shell
	 * The file is found from the list of files, 
	 */
	public void execute(String path) {
		
	}
	
	/*
	 * prints help list
	 * should print possible commands as well as any other relevant information
	 */
	public void help() {
		//check helpCount to see how much should be printed
	}
	
	/*
	 * prints usage info for a specific command
	 * should print an error if not passed the name of a command
	 */
	public void help(String command) {
		
	}
	
	/*
	 * Prints the prompt, call it after each command is executed
	 */
	public void printPrompt() {
		System.out.print("Unix-Test:" + current.name + " " + userName + "$ ");
	}

	@Override
	public void run() {
		String input;
		Scanner scanner = new Scanner(System.in);
		int result;
		//print welcome message here
		printPrompt();
		while (true) {
			input = scanner.nextLine();
			result = parse(input);
			if (result == 1) { break; }		//this is when 'quit' or 'exit' is entered
			printPrompt();
		}
		//print logout message
		scanner.close();
	}

}
//cd, ls, help/man, quit/exit, pwd, ./

//typing help at any time prints out a list of valid commands with their descriptions
//at first, only ls, help, and quit are in the help list
//as time goes on, more commands get added (cd, pwd)
//keep a counter that indicates which level the help list is currently at; when it is incremented, more commands will be printed out
