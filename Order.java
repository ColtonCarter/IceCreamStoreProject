package icecreamshop;

import java.util.ArrayList;
import java.util.List;

public class Order 
{
	private int orderID;
	private String type;
	private String flavor;
	private int custID;
	private String scoops;
	private String status;
	
	
	public Order(int orderID, String type, int custID, String flavor, String scoops, String status) {
		super();
		this.orderID = orderID;
		this.type = type;
		this.custID = custID;
		this.flavor = flavor;
		this.scoops = scoops;
		this.status = status;
	}
	
	public Order() {
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getScoops() {
		return scoops;
	}

	public void setScoops(String scoops) {
		this.scoops = scoops;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
