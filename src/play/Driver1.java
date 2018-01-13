package play;

import bash.*;
import gui.*;

/*
 * This is a driver class used to initialize everything
 */
public class Driver1 {

	public Driver1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//clear the screen
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		//Create a new bash object, as well as the directories and files we need
		Bash bash = new Bash();
		//first directory to be created should be home
		Directory home = new Directory("~");
		File helloworld = new File("helloworld.bin");
		home.addFile(helloworld);
		//create more directories and files as needed
		//Must add directories to superdirectories before adding files to them, but
		//add all files to directories before adding any directories to bash
		
		bash.setHome(home);
		bash.setCurrent(home);
		//now add directories to bash, in alphabetical order
		
		MiniGame mg = new MiniGame(new HelloWorld());
		Thread t1 = new Thread(bash);
		t1.start();
		try {
			t1.join();		//prevents program from exiting until quit has been entered
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
