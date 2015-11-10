package icecreamshop;

public class Customer {
	
    Customer(String firstName, String lastName, String faveFlavor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.faveFlavor = faveFlavor;
	}
    Customer() {
    	this.firstName = "defaultFirst";
		this.lastName = "defaultLast";
		this.faveFlavor = "defaultFlavor";
	}
	
	String firstName;
	String lastName;
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
	public String getFaveFlavor() {
		return faveFlavor;
	}
	public void setFaveFlavor(String faveFlavor) {
		this.faveFlavor = faveFlavor;
	}
	
}
