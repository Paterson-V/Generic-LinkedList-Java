/*
 * Written by Vei Paterson Tia
 */
import java.util.Scanner;
import java.io.*;
public class TaskManager {
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	private GenLL<Task>[] organizedTasks;
	
	// Constructor
	public TaskManager() 
	{
		organizedTasks = new GenLL[5];
		// Populate the array of task
		for(int i = 0; i < organizedTasks.length; i++) 
		{
			organizedTasks[i] = new GenLL<Task>();
		}
	}
	
	// Add Task to the list
	public void addTask(Task aTask) 
	{
		// Check if task is valid
		if(aTask == null)
			return;
		// if task exists already, don't add it
		if(organizedTasks[aTask.getPriority()].contains(aTask)) 
		{
			System.out.println("This task exists already. Not added.");
			return;
		}
		organizedTasks[aTask.getPriority()].add(aTask);
		System.out.println("Task added: [Priority: " + aTask.getPriority() + "] " + aTask.getAction()); // Print the added task on the console
	}
	
	// RemoveTask from the list
	public void removeTask(Task aTask) 
	{
		if(aTask == null)
			return;
		int p = aTask.getPriority(); // always between [0-4]
		if(organizedTasks[p] != null) 
		{
			organizedTasks[p].remove(aTask);
			System.out.println("Task removed: " + aTask.getAction());
		}
		else 
		{
			System.out.println("Task not found.");
		}
	}
	
	// Print tasks to console
	public void printTasks() 
	{
		for(int i = 0; i < organizedTasks.length; i++) 
		{
			// Empty index won't be printed
			if(organizedTasks[i] == null)
				continue;
			organizedTasks[i].reset(); // The first node is current
			while(organizedTasks[i].hasMore()) 
			{
				Task aTask = organizedTasks[i].getCurrent();
				System.out.println("[Task] Priority: " + aTask.getPriority() + " Task: " + aTask.getAction());
				organizedTasks[i].gotoNext();
			}
		}
	}
	
	// Read Task From File
	public void readTaskFromFile(String aName) 
	{
		try(Scanner fileScanner = new Scanner(new File(aName));) 
		{
			// open the file
			//Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()) 
			{
				String fileLine = fileScanner.nextLine();
				
				if(fileLine.isEmpty())
					continue;
				
				String[] splitLines = fileLine.split(DELIM);
				// copy data from valid lines
				if(splitLines.length != BODY_FIELD_AMT) 
				{
					continue;
				}
				else
				{
					int priority = Integer.parseInt(splitLines[0].trim());
					String action = splitLines[1].trim();
					// Create a task
					Task aTask = new Task(action, priority);
					addTask(aTask);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Write Tasks to file
	public void writeTasksToFile(String aName) 
	{
		try(PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));)
		{
			// Create a file
			//PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			
			for(int i = 0; i < organizedTasks.length; i++) 
			{
				if(organizedTasks[i] == null)
					continue;
				
				organizedTasks[i].reset(); // Get the the first node to be current
				while(organizedTasks[i].hasMore()) 
				{
					Task aTask = organizedTasks[i].getCurrent();
					fileWriter.println(aTask.getPriority() + DELIM + aTask.getAction());
					organizedTasks[i].gotoNext();
				}
			}
			//fileWriter.close();
			System.out.println("Task saved to " + aName);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
