package icecreamshop;

public class Customer {
	
    Customer(String firstName, String lastName, int customerID, String faveFlavor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerID = customerID;
		this.faveFlavor = faveFlavor;
	}
	
	String firstName;
	String lastName;
	int customerID;
	String faveFlavor;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getFaveFlavor() {
		return faveFlavor;
	}
	public void setFaveFlavor(String faveFlavor) {
		this.faveFlavor = faveFlavor;
	}
	
}
