package kz.aitu.oop.practice.practice5;

public abstract class Stones {
	protected String name;
	protected double weight;
	protected int cost;

	public Stones(String n, double w, int c) 
	{
		this.setName(n);
		this.setWeight(w);
		this.setCost(c);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
		
	public String toString() {
		return "This is a stone";
	}
}
