package icecreamshop;

public interface Queue 
{
	void enqueue(Object item); 
	// this function adds item to the rear of the queue
	
	Object dequeue(); 
	// Returns front item from the queue and returns it
	
	Object peek(); 
	//returns front item from the queue without popping it 
	
	int size(); 
	// Returns number of items currently in the queue
	
	boolean isEmpty(); 
	// returns whether the queue is empty or not
	
	
	
}
