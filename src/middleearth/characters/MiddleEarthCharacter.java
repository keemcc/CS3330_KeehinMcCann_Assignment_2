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
	
	abstract boolean attack(MiddleEarthCharacter target);
	abstract String getRace();
	
	public void displayInfo() {
		System.out.println("Character name = " + name);
		System.out.println("Character health = " + health);
		System.out.println("Character power = " + power);
	}
}
