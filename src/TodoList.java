import java.util.ArrayList;

/**
 * TodoList class creates an ArrayList object and associated
 * methods to work with the UserInterface class. TodoList class
 * assists in adding, printing, removing, and clearing tasks/items in
 * the UserInterface class. Additional helper methods created to
 * work with creating an external file for the user to take the
 * list with them
 * 
 * @author rargueta
 *
 */
public class TodoList {
	private ArrayList<String> todoList;
	
	/**
	 * Constructor with no parameters, creates ArrayList object
	 */
	public TodoList() {
		this.todoList = new ArrayList<>();
	}
	
	/**
	 * Adds a "task" to the list
	 * 
	 * @param task - to be added to the list
	 */
	public void add(String task) {
		todoList.add(task);
	}
	
	/**
	 * Prints the current tasks on the list
	 */
	public void print() {
		
		for(int i = 0; i < todoList.size(); i++) {
			System.out.println((i + 1) + ": " + todoList.get(i));
		}
		
	}
	
	/**
	 * Removes indicated index of task on the list
	 * 
	 * @param number - (index + 1) of item to be removed
	 * from the list
	 */
	public void remove(int number) {
		todoList.remove(number - 1);
	}
	
	/**
	 * Clears the entire list
	 */
	public void clear() {
		todoList.clear();
	}
	
	/**
	 * Confirmation of whether the list is empty
	 * 
	 * @return - true if list is empty
	 */
	public boolean isEmpty() {
		if(!todoList.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Overwritten toString() method used to create readability
	 * in external .txt file when created and opened by user
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (String item: todoList) {
			output.append(item).append("\n");
		}
		return output.toString();
	}
}
