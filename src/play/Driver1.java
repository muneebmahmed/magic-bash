package play;

import bash.*;

/*
 * This is a driver class used to initialize everything
 */
public class Driver1 {

	public Driver1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a new bash object, as well as the directories and files we need
		Bash bash = new Bash();
		//first directory to be created should be home
		Directory home = new Directory("~");
		File helloworld = new File("helloworld.bin");
		home.addFile(helloworld);
		//create more directories and files as needed
		//add files to directories before adding directories to bash
		bash.setHome(home);
		//now add directories to bash, in alphabetical order
		
	}

}
