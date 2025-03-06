package middleearth.characters;

public class Dwarf extends MiddleEarthCharacter {
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		System.out.println(this.getName() + " attacks " + target.getName() + "!");
		if ((target.getRace() == "Wizard") || (target.getRace() == "Dwarf")) {
			System.out.println("Attack was not effective.");
			return false;
		}
		double attackDamage = this.getPower();
		if (target.getRace() == "Elf") {
			attackDamage = attackDamage * 1.5;
			System.out.println("Attack was super effective!");
		}
		double targetHealth = target.getHealth();
		System.out.println("Attack hit " + target.getName() + " for " + attackDamage + " damage, bringing their health from " + targetHealth + " to " + (targetHealth-attackDamage) + ".");
		targetHealth = targetHealth - attackDamage;
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Dwarf";
	}

}
