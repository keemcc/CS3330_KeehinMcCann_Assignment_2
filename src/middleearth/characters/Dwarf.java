package middleearth.characters;

public class Dwarf extends MiddleEarthCharacter {
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() == "Wizard") || (target.getRace() == "Dwarf")) {
			return false;
		}
		double attackDamage = this.getPower();
		if (target.getRace() == "Elf") {
			attackDamage = attackDamage * 1.5;
		}
		double targetHealth = target.getHealth();
		targetHealth = targetHealth - attackDamage;
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Dwarf";
	}

}
