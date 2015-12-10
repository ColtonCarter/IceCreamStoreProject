package icecreamshop;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
	//create fields for employee information, corresponds to database information
    private final StringProperty fname = new SimpleStringProperty(this, "firstname");
    private final StringProperty lname = new SimpleStringProperty(this, "lastname");
    private final StringProperty custID = new SimpleStringProperty(this, "customerID");
    private final StringProperty flavor = new SimpleStringProperty(this, "faveFlavor");
    

    //property methods, getters and setters for fields
    
    public StringProperty FnameProperty() {
        return fname;
    }
    
    public StringProperty FlavorProperty() {
        return flavor;
    }
    
    public StringProperty LnameProperty() {
        return lname;
    }
    
    public StringProperty CustIDProperty() {
        return custID;
    }
    
   
    
    public final void setLName(String lname) {
    	LnameProperty().set(lname);
	}
    
    public final String getLname() {
        return LnameProperty().get();
    }
    
    public final String getFname() {
        return FnameProperty().get();
    }
    
    public final void setFName(String fname) {
        FnameProperty().set(fname);
    }
    
    public final String getFlavor() {
    	return FlavorProperty().get();
	}
    
    public final void setFlavor(String flavor) {
    	FlavorProperty().set(flavor);
	}
    
	public final String getCustID() {
		return CustIDProperty().get();
	}
	
	public final void setCustID(String id) {
		CustIDProperty().set(id);
	}
	
	
	
	//no arg constructor
	public Customer(){}

	//constructor with arguments for each field, sets them as field for new AU_emp object
    public Customer(String fname, String lname, String custID, String flavor){
    	setFName(fname);
    	setLName(lname);
    	setFlavor(flavor);
    	setCustID(custID);
    }
	
}
