package icecreamshop;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

	public class Order {
		
		//create fields for employee information, corresponds to database information
	    private final StringProperty type = new SimpleStringProperty(this, "cone_type");
	    private final StringProperty flavor = new SimpleStringProperty(this, "cone_flavor");
	    private final StringProperty scoops = new SimpleStringProperty(this, "numScoops");
	    private final StringProperty status = new SimpleStringProperty(this, "status");
	    private final StringProperty total = new SimpleStringProperty(this, "total");
	    private final StringProperty num = new SimpleStringProperty(this, "order_num");

	    //property methods, getters and setters for fields
	    
	    public StringProperty TypeProperty() {
	        return type;
	    }
	    
	    public StringProperty FlavorProperty() {
	        return flavor;
	    }
	    
	    public StringProperty ScoopsProperty() {
	        return scoops;
	    }
	    
	    public StringProperty StatusProperty() {
	        return status;
	    }
	    
	    public StringProperty TotalProperty() {
	        return total;
	    }
	    
	    public StringProperty NumProperty() {
	        return num;
	    }
	    
	    public final void setNum(String num) {
	    	NumProperty().set(num);
		}
	    
	    public final String getNum() {
	        return NumProperty().get();
	    }
	    
	    public final String getType() {
	        return TypeProperty().get();
	    }
	    
	    public final void setType(String type) {
	        TypeProperty().set(type);
	    }
	    
	    public final String getFlavor() {
	    	return FlavorProperty().get();
		}
	    
	    public final void setFlavor(String flavor) {
	    	FlavorProperty().set(flavor);
		}
	    
		public final String getScoops() {
			return ScoopsProperty().get();
		}
		
		public final void setScoops(String scoops) {
			ScoopsProperty().set(scoops);
		}
		
		public final String getStatus() {
			return StatusProperty().get();
		}
		
		public final void setStatus(String status) {
			StatusProperty().set(status);
		}
		
		public final void setTotal(String total) {
			TotalProperty().set(total);
		}
		
		public final String getTotal() {
			return TotalProperty().get();
		}
		
		
		//no arg constructor
		public Order(){}

		//constructor with arguments for each field, sets them as field for new AU_emp object
	    public Order(String num, String type, String flavor, String scoops, String status, String total){
	    	setNum(num);
	    	setType(type);
	    	setFlavor(flavor);
	    	setScoops(scoops);
	    	setStatus(status);
	    	setTotal(total);
	    }

	}
