package middleearth.characters;

public class Elf extends MiddleEarthCharacter{
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}
	@Override
	boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	String getRace() {
		return "Elf";
	}

}
