/*
 * Written by Vei Paterson Tia
 */

public class GenLL<T> implements GenLLI<T> {
	// Internal class
	public class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink) 
		{
			data = aData;
			link = aLink;
		}
	}
	
	// Create pointer
	private ListNode head;
	private ListNode current;
	private ListNode previous;
		
	// Constructor
	public GenLL() 
	{
		head = current = previous = null;
	}
	
	// Create method for adding new item
	public void add(T aData) 
	{
		// Check if the aData is valid
		if(aData == null)
			return;
		if(contains(aData))
			return;
		//Create a new node
		ListNode newNode = new ListNode(aData, null);
			
		// If there were no nodes in the list
		if(head == null)
		{
			head = current= newNode;
			return;
		}
		// if the list is not empty
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode; // Add the new node at the end of the list
	}
	
	// remove a specific data
	public boolean remove(T aData) 
	{
		if(head == null) // List empty
			return false;
		// Otherwise
		ListNode temp = head;
		ListNode previous = null;
		
		// Traverse the list
		while(temp != null) 
		{
			if(temp.data.equals(aData)) 
			{
				if(previous == null) 
				{
					head = temp.link; 
				}
				else
				{
					previous.link = temp.link;
				}
				return true;
			}
			
			previous = temp;
			temp = temp.link;
		}
		
		return false; // If no found
	}
	
	// Check if a data exists in the list
	public boolean contains(T aData) 
	{
		ListNode temp = head;
		while(temp != null) 
		{
			// If found return true
			if(temp.data.equals(aData))
				return true;
			temp = temp.link;
		}
		
		return false; // if no found
	}
	
	// Check if list is empty
	public boolean isEmpty() 
	{
		return head == null;
	}
	
	// Clear the list
	public void clear() 
	{
		head = null;
		current = previous = null;
	}
	
	// get the size of the list
	public int size() 
	{
		int count = 0;
		ListNode temp = head;
		// Traverse list and count
		while(temp != null) 
		{
			count++;
			temp = temp.link;
		}
		
		return count;
	}
	
	// Create method gotoNext
	public void gotoNext() 
	{
		if(current == null)
			return;
		previous = current; // if current not null previous points on current 
		current = current.link; // and then current goes to the next node
	}
		
	// Create method getCurrent
	public T getCurrent() 
	{
		// Get current's data if it is not null
		if(current == null)
			return null; // 
		return current.data;
	}
	
	// Method for reseting the list (get the current to go to the head)
	public void reset() 
	{
		current = head;
		previous = null;
	}
	
	// Method to check if the list has an item
	public boolean hasMore() 
	{
		return current != null;
	}
}
