package middleearth.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	public MiddleEarthCharacter() {
		name = "Default";
		health = -1;
		power = -1;
	}
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	public abstract boolean attack(MiddleEarthCharacter target);
	public abstract String getRace();
	
	public void displayInfo() {
		System.out.println(name + " is a " + getRace() + " with " + health + " health and " + power + " power.");
	}
	public double getPower() {
		return power;
	}
	public String getName() {
		return name;
	}
	public double getHealth() {
		return health;
	}
	public boolean setPower(double power) {
		this.power = power;
		return true;
	}
	public boolean setName(String name) {
		this.name = name;
		return true;
	}
	public boolean setHealth(double health) {
		this.health = health;
		return true;
	}
}
