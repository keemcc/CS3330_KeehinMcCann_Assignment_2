package middleearth.characters;

public class Wizard extends MiddleEarthCharacter{
	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() == "Human") || (target.getRace() == "Wizard")) {
			return false;
		}
		double attackDamage = this.getPower();
		if (target.getRace() == "Dwarf") {
			attackDamage = attackDamage * 1.5;
		}
		double targetHealth = target.getHealth();
		targetHealth = targetHealth - attackDamage;
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Wizard";
	}
}
