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
	
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	
	public void displayInfo() {
		System.out.println("Character name = " + name);
		System.out.println("Character health = " + health);
		System.out.println("Character power = " + power);
	}
}
