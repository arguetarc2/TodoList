import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;


/**
 * UserInterface class that works with the user to add, list, remove, clear items on a list, or exit the interface
 * 
 * @author rargueta
 *
 */
public class UserInterface {
	private TodoList todoList;
	private Scanner scnr;
	
	/**
	 * Constructor method that takes in type TodoList and Scanner parameters
	 * Establishes objects
	 * 
	 * @param todoList - references the TodoList object
	 * @param scnr - references a scanner object
	 */
	public UserInterface(TodoList todoList, Scanner scnr) {
		this.todoList = todoList;
		this.scnr = scnr;
	}
	
	/**
	 * Start method that initializes the user interface and provides user with options
	 * to work with their list
	 */
	public void start() {
		
		while(true) {
			System.out.println("Welcome to your To-Do List! What would you like to do? \n'Add' to add an item \n'List' to list out the items in your To-do List "
					+ "\n'Remove' to remove an item \n'Clear' to clear the list \n'Stop' to exit");
			String userInput = scnr.nextLine();
			
			// Adds item to list
			if(userInput.equalsIgnoreCase("add")) {
				System.out.println("To add: ");
				String itemAdd = scnr.nextLine();
				todoList.add(itemAdd);
				System.out.println();
				
				// Confirmation if item has been successfully added or not
				if(!todoList.isEmpty()) {
					System.out.println("Item added successfully!\n");
				}
				else {
					System.out.println("There was an error adding your item.");
				}
			}
			
			// Lists the current items in list, if empty, user is advised
			else if(userInput.equalsIgnoreCase("list")) {
				if(todoList.isEmpty()) {
					System.out.println("There's nothing on the list, currently.");
				}
				
				todoList.print();
				System.out.println();
			}
			
			// Removes item from list
			else if(userInput.equalsIgnoreCase("remove")) {
				System.out.println("What item on the list would you like to remove? \n");
				todoList.print();
				int itemRemove = Integer.valueOf(scnr.nextLine());
				
				todoList.remove(itemRemove);
				System.out.println();
			}
			
			// Clears items on list
			else if(userInput.equalsIgnoreCase("clear")) {
				todoList.clear();
				System.out.println();
			}
			
			// Exits user interface
			else if(userInput.equalsIgnoreCase("stop")) {
				break;
			}
			
			// Advise user if invalid option selected
			else {
				System.out.println("Not a valid option! Try again.");
			}
				
		}
	}
	
	/**
	 * Prints the list to an external txt file
	 * 
	 * @throws IOException - handles issues when creating and working
	 * with file
	 */
	public void printToFile() throws IOException {
		PrintWriter fileOut = null;
		
		// Try-catch-finally block to create file and handle exception
		try {
			fileOut = new PrintWriter("List.txt");
			fileOut.println(todoList);
			fileOut.close();
		}
		catch (IOException exception) {
			System.out.println("Error" + exception.getMessage());
		}
		finally {
			if (fileOut != null) {
	            fileOut.close();
	        }
		}
	}	

}
