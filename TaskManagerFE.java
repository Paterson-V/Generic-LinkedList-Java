/*
 * Written by Paterson Tia
 */
import java.util.Scanner;
public class TaskManagerFE {
	
	public static final Scanner keyboard = new Scanner(System.in);
	public static final String DELIM = "\t";
    public static final int BODY_FIELD_AMT = 2;

	public static void main(String[] args) {
		
		// Create an object of TaskManager
		TaskManager manager = new TaskManager();
		int choice; // variable to get the user choice
		
		// Call method printGreeting;
		printGreeting();
		 
		do 
		{
			// Call printChoices
			printChoices();
			
			System.out.print("Enter your choice: ");
			// Validate integer input 
			while(!keyboard.hasNextInt()) 
			{
				System.out.println("Invalid input. Enter a number");
				keyboard.next();
			}
			choice = keyboard.nextInt(); // Get user input
			keyboard.nextLine(); // Fix up
			
			switch(choice) 
			{
			case 1:
				addTask(manager);
				break;
			case 2:
				removeTask(manager);
				break;
			case 3:
				manager.printTasks();
				break;
			case 4:
				readTasks(manager);
				break;
			case 5:
				writeTasks(manager);
				break;
			case 9:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
			
		} while(choice != 9);
		
		keyboard.close();

	}
	
	// Method for greeting the user
	public static void printGreeting() 
	{
		System.out.println("Welcome to the Task Organizer!");
	}
	
	// Print choices
	public static void printChoices() 
	{
		System.out.println();
		System.out.println("Enter 1. To Add a Task\n"
				+ "Enter 2. To Remove a Task\n"
				+ "Enter 3. To Print a Task\n"
				+ "Enter 4. To Read from a Task File\n"
				+ "Enter 5. To Write to a Task File\n"
				+ "Enter 9. To Quit\n");
	}
	
	// Add Task
	public static void addTask(TaskManager manager) 
	{
		System.out.print("Enter the task's priority: a number from 0 to 4: ");
		int priority = keyboard.nextInt();
		keyboard.nextLine(); 
		
		System.out.print("Enter the task's action: ");
		String action = keyboard.nextLine();
		
		// Create a Task and add it
		Task aTask = new Task(action, priority);
		manager.addTask(aTask);
	}
	
	// Remove Task
	public static void removeTask(TaskManager manager) 
	{
		System.out.print("Enter the task's priority: a number from 0 to 4: ");
		int priority = keyboard.nextInt();
		keyboard.nextLine(); 
		
		System.out.print("Enter the task's action: ");
		String action = keyboard.nextLine();
		
		// Create a Task and add it
		Task aTask = new Task(action, priority);
		manager.removeTask(aTask);
	}
	
	// Read task from file
	public static void readTasks(TaskManager manager) 
	{
		// prompt the user to enter the file name
		System.out.print("Enter the file name: ");
		String filename = keyboard.nextLine();
		// Read from the file
		manager.readTaskFromFile(filename);
	}
	
	// Write task to file
	public static void writeTasks(TaskManager manager) 
	{
		// prompt the user to enter the file name
		System.out.print("Enter the file name: ");
		String filename = keyboard.nextLine();
		// Write tasks to file
		manager.writeTasksToFile(filename);		
	}


}
