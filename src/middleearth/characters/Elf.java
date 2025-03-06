package middleearth.characters;

/**
 * Elf is a type of MiddleEarthCharacter that has specific attack advantages and disadvantages
 */
public class Elf extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor to create object with set values for name, health and power
	 * @param name name of the character
	 * @param health character's health
	 * @param power character's power
	 */
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	 * Implementation of the attack method with the Elf's specific advantages and disadvantages
	 * Prints attack, whether it was effective or not, and how much health was lost, if any.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		System.out.println(this.getName() + " attacks " + target.getName() + "!");
		//The Elf will do no damage to these races
		if ((target.getRace() == "Dwarf") || (target.getRace() == "Elf")) {
			System.out.println("Attack was not effective.");
			return false;
		}
		double attackDamage = this.getPower();
		//The Elf will do 1.5 times damage to this race
		if (target.getRace() == "Orc") {
			attackDamage = attackDamage * 1.5;
			System.out.println("Attack was super effective!");
		}
		double targetHealth = target.getHealth();
		System.out.println("Attack hit " + target.getName() + " for " + attackDamage + " damage, bringing their health from " + targetHealth + " to " + (targetHealth-attackDamage) + ".");
		targetHealth = targetHealth - attackDamage;
		//Set target's health to be their new health after the attack
		target.setHealth(targetHealth);
		return true;
	}

	/**
	 * Implementation of the getRace method to return "Elf"
	 */
	@Override
	public String getRace() {
		return "Elf";
	}

}
