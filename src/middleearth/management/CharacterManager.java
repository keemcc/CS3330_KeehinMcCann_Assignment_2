package middleearth.management;

import middleearth.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	public CharacterManager() {
		size = 0;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		//System.out.println("Size of array is " + size);
		if (characters != null) {
			System.out.println("Length of array is " + characters.length);
		}
		if (size == 0) {
			size = 1;
			characters = new MiddleEarthCharacter[1];
			characters[0] = c;
			return true;
		}
		
		if (size == characters.length) {
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[(characters.length) * 2];
			for (int i = 0; i < size; i++) {
				newCharacters[i] = characters[i];
			}
			characters = newCharacters;
		}
		size++;
		characters[size-1] = c;
		return true;
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		for (int i = 0; i < size; i++) {
			if (characters[i].getName() == name) {
				return characters[i];
			}
		}
		return null;
	}
	
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		if ((character.getHealth() == health) && (character.getName() == name) && (character.getPower() == power)) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (character == characters[i]) {
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteCharactrer(MiddleEarthCharacter character) {
		return false;
	}
	
	public void displayAllCharacters() {
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
}
