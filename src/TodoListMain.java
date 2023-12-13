import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Driver class for the To-Do List application. Starts the 
 * application and upon exiting, user is asked a final 
 * question on whether they would like to print their list
 * to an external .txt file
 * 
 * @author rargueta
 *
 */
public class TodoListMain {

	/**
	 * The main method for the driver class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scnr = new Scanner(System.in)) {
	        TodoList list = new TodoList();
	        UserInterface UI = new UserInterface(list, scnr);
	        
	        // Start the User Interface
	        UI.start();
	    
	        // User Interface has been exited, and user has option to print list to a file
	        System.out.println("Before you leave, would you like to export your to-do list to a .txt file? 'Y' for yes, 'N' for no:");
	        String userChoice = scnr.nextLine();
		
	        if(userChoice.equalsIgnoreCase("n")) {
	        	System.out.println("Ok, enjoy your day!");
	        }
	        else if (userChoice.equalsIgnoreCase("y")){
	        	
	        	try {
                    UI.printToFile();
                    System.out.println("Look for the 'List.txt' file for your To-Do List.");
                } 
	        	catch (IOException e) {
                    System.out.println("Error exporting to file: " + e.getMessage());
                }
			}
		}
	}

}
