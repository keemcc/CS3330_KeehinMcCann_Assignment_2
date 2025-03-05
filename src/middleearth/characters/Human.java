package middleearth.characters;

public class Human extends MiddleEarthCharacter {
	public Human(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if ((target.getRace() == "Orc") || (target.getRace() == "Human")) {
			return false;
		}
		double attackDamage = this.getPower();
		if (target.getRace() == "Wizard") {
			attackDamage = attackDamage * 1.5;
		}
		double targetHealth = target.getHealth();
		targetHealth = targetHealth - attackDamage;
		target.setHealth(targetHealth);
		return true;
	}

	@Override
	public String getRace() {
		return "Human";
	}

}
