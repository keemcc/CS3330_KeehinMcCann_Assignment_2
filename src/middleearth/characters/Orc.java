package middleearth.characters;

public class Orc extends MiddleEarthCharacter {
	public Orc(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() == "Elf") || (target.getRace() == "Orc")) {
			return false;
		}
		double attackDamage = this.getPower();
		if (target.getRace() == "Human") {
			attackDamage = attackDamage * 1.5;
		}
		double targetHealth = target.getHealth();
		targetHealth = targetHealth - attackDamage;
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Orc";
	}
	
}
