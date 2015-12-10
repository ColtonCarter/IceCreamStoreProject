package icecreamshop;

public class Cone {
	
	Cone(String type, String flavors, int numScoops, String coneType) {
		super();
		this.type = type;
		this.flavors = flavors;
		this.numScoops = numScoops;
		this.coneType = coneType;
	}
	
	Cone() {
		super();
		this.type = "Ice Cream";
		this.flavors = "Vanilla";
		this.numScoops = 0;
		this.coneType = "Waffle";
	}

	String type;
	
	String flavors;

	int numScoops;
	
	String coneType;
	
	static double scoopCost = .50;
	
	static double coneCost = .75;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlavors() {
		return flavors;
	}

	public void setFlavors(String flavors) {
		this.flavors = flavors;
	}

	public int getNumScoops() {
		return numScoops;
	}

	public void setNumScoops(int numScoops) {
		this.numScoops = numScoops;
	}

	public String getConeType() {
		return coneType;
	}

	public void setConeType(String coneType) {
		this.coneType = coneType;
	}

	
	
}
