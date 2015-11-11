package application;

import java.util.ArrayList;
import java.util.List;

public class Order 
{
	private Customer customer;
	private List cones;
	
	
	public Order() {
		super();
		this.customer = customer;
		this.cones =  new ArrayList();
	}
	
	public Order(Customer customer, List cones) {
		super();
		this.customer = customer;
		this.cones = cones;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List getCones() {
		return cones;
	}

	public void setCones(List cones) {
		this.cones = cones;
	}
	
	
	

	
}
