/*
 * Written by Vei Paterson Tia
 */
public class Task {
	// Declare instance variables
	private String action; // Explains the action
	private int priority; // Order in which tasks are arranged
	
	// Constructors
	public Task() 
	{
		this.action = "none";
		this.priority = 4;
	}
	
	public Task(String anAction, int aPriority) 
	{
		this.setAction(anAction);
		this.setPriority(aPriority);
	}
	
	// Accessors
	public String getAction() 
	{
		return this.action;
	}
	
	public int getPriority() 
	{
		return this.priority;
	}
	
	// Mutators
	public void setAction(String anAction) 
	{
		if(anAction != null)
			this.action = anAction;
		else
			this.action = "none";
	}
	
	public void setPriority(int aPriority) 
	{
		if(aPriority >= 0 && aPriority <= 4)
			this.priority = aPriority;
		else
			this.priority = 4;
	}
	
	// Method toString
	public String toString() 
	{
		return "Action: " + this.getAction() + "  Priority: " + this.getPriority();
	}
	
	// Method equals
	public boolean equals(Task aTask) 
	{
		return aTask != null &&
				this.action.equals(aTask.getAction()) &&
				this.priority == aTask.getPriority();
	}
}
