package icecreamshop;

import java.util.NoSuchElementException;

public class BoundedQueue implements Queue
{
	private Object[] array; 
	private int size = 0; 
	private int head = 0; 
	private int tail = 0; 
	
	public BoundedQueue( int capacity)
	{
		array = new Object[capacity]; 
	}
	
	public void enqueue(Object item)
	{
		if (size == array.length)
		{
			throw new IllegalStateException("Cannot add to full queue");
		}
		array[tail] = item; 
		tail = (tail + 1) % array.length; 
		size++;
	}
	
	public Object dequeue()
	{
		if(size == 0)
		{
			throw new NoSuchElementException("Cannot remove from empty queue"); 
		}
		Object item = array[head];
		array[head] = null; 
		head = (head + 1) % array.length; 
		size--; 
		return item;
	}
	public Object peek()
	{
		if (size ==0)
		{
			throw new NoSuchElementException("Cannot peek from empty queue"); 
		}
		return array[size - 1]; 
	}
	public boolean isEmpty()
	{
		return size == 0; 
	}
	public int size()
	{
		return size; 
	}
}
