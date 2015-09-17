package icecreamshop;

public class Cone {
	
	Cone(String[] type, String[] flavors, int[] numScoops, String[] coneType) {
		super();
		this.type = type;
		this.flavors = flavors;
		this.numScoops = numScoops;
		this.coneType = coneType;
	}

	String[] type = { "Yogurt", "Ice Cream" };
	
	String[] flavors = { "Vanilla", "Chocolate", "Strawberry", "Cookie Dough", 
			"Rocky Road", "Butter Pecan", "Coffee", "Random" };

	int[] numScoops = { 1, 2, 3 };
	
	String[] coneType = { "Waffle", "Cake", "Sugar", "Random" };
	
	static double scoopCost = .50;
	
	static double coneCost = .75;

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String[] getFlavors() {
		return flavors;
	}

	public void setFlavors(String[] flavors) {
		this.flavors = flavors;
	}

	public int[] getNumScoops() {
		return numScoops;
	}

	public void setNumScoops(int[] numScoops) {
		this.numScoops = numScoops;
	}

	public String[] getConeType() {
		return coneType;
	}

	public void setConeType(String[] coneType) {
		this.coneType = coneType;
	}

	public static double getScoopCost() {
		return scoopCost;
	}

	public static void setScoopCost(double scoopCost) {
		Cone.scoopCost = scoopCost;
	}

	public static double getConeCost() {
		return coneCost;
	}

	public static void setConeCost(double coneCost) {
		Cone.coneCost = coneCost;
	}
	
}
