package middleearth.characters;

public class Elf extends MiddleEarthCharacter{
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() == "Dwarf") || (target.getRace() == "Elf")) {
			return false;
		}
		double attackDamage = this.getPower();
		if (target.getRace() == "Orc") {
			attackDamage = attackDamage * 1.5;
		}
		double targetHealth = target.getHealth();
		targetHealth = targetHealth - attackDamage;
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Elf";
	}

}
