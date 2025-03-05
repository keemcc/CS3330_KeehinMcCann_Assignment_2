package middleearth.characters;

public class Human extends MiddleEarthCharacter {
	public Human(String name, double health, double power) {
		super(name, health, power);
	}
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRace() {
		return "Human";
	}

}
