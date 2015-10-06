package icecreamshop;

import java.util.PriorityQueue;
import java.util.Stack;

/**will need to add implementation for the Stack and priority qeueue as we need them.
 * Right now we can't access the queue or stack outside of this class. If we want another class to peek 
 * pop or have any other ability these objects have we will have to create methods in this class.
 **/

public class POS 
{
	private Stack completedOrders;
	private PriorityQueue currentOrders; // this
	
	public POS(Stack completedCustomers, PriorityQueue currentCustomers) {
		super();
		this.completedOrders = completedCustomers;
		this.currentOrders = currentCustomers;
	}
	
	public POS(){
		
		super();
		this.completedOrders = new Stack(); 
		this.currentOrders = new PriorityQueue();
	}

	public Stack getCompletedOrders() {
		return completedOrders;
	}

	public void setCompletedOrders(Stack completedOrders) {
		this.completedOrders = completedOrders;
	}

	public PriorityQueue getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(PriorityQueue currentOrders) {
		this.currentOrders = currentOrders;
	}

			
};
	
	

