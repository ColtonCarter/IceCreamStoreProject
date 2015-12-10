package icecreamshop;

import java.util.LinkedList; 

public class simpleQueue implements Queue
{
	private LinkedList<Object> data = new LinkedList<Object>(); 
	
	public void enqueue(Object item)
	{
		data.addLast(item);
	}
	public Object dequeue()
	{
		return data.removeFirst();
	}
	public Object peek()
	{
		return data.size();
	}
	public int size()
	{
		return data.size();
	}
	public boolean isEmpty()
	{
		return data.isEmpty();
	}
}
