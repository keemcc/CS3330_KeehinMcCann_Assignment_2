package middleearth.characters;

/**
 * This is the abstract class of a MiddleEarthCharacter
 * It contains some fields that all characters will have, along with the methods all characters will have
 * It also has some methods already implemented that will be consistent across all characters
 */
public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	/**
	 * Default constructor
	 * Sets fields to default values
	 */
	public MiddleEarthCharacter() {
		name = "Default";
		health = -1;
		power = -1;
	}
	/**
	 * Parameterized constructor
	 * Sets all fields with passed values
	 * @param name name of the character
	 * @param health character's health
	 * @param power character's power
	 */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
	 * Abstract attack method, target will be attacked by MiddleEarthCharacter and lose health
	 * @param target character to be attacked
	 * @return returns true if attack is successful and false if not
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	/**
	 * getRace method, will return the race of the character
	 * @return race of the character
	 */
	public abstract String getRace();
	
	/**
	 * Displays all information about a character
	 */
	public void displayInfo() {
		System.out.println(name + " is a " + getRace() + " with " + health + " health and " + power + " power.");
	}
	
	/**
	 * Returns the power of the character
	 * @return power value
	 */
	public double getPower() {
		return power;
	}
	
	/**
	 * Returns the name of the character
	 * @return name of the character
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the health of the character
	 * @return character's health
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Sets the character's power to the passed value
	 * @param power power value to be set to
	 * @return returns true after completed
	 */
	public boolean setPower(double power) {
		this.power = power;
		return true;
	}
	/**
	 * Sets the character's name to the passed value
	 * @param name name value to be set to
	 * @return returns true after completed
	 */
	public boolean setName(String name) {
		this.name = name;
		return true;
	}
	/**
	 * Sets the character's health to the passed value
	 * @param health health value to be set to
	 * @return returns true after completed
	 */
	public boolean setHealth(double health) {
		this.health = health;
		return true;
	}
}
