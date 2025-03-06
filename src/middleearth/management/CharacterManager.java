package middleearth.management;

import middleearth.characters.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	public CharacterManager() {
		size = 0;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if (size == 0) {
			System.out.println("Character array size was 0, resizing to 1.");
			size = 1;
			characters = new MiddleEarthCharacter[1];
			characters[0] = c;
			return true;
		}
		
		if (size == characters.length) {
			System.out.println("Resizing array from " + size + " to " + (size*2));
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
		System.out.println("Searching for " + name);
		for (int i = 0; i < size; i++) {
			if (characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		if ((character.getHealth() == health) && (character.getName().equals(name)) && (character.getPower() == power)) {
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
		int index = 0;
		boolean found = false;
		while (index < size) {
			if (characters[index] == character) {
				characters[index] = null;
				found = true;
				break;
			}
			index++;
		}
		if (found) {
			while (index < size-1) {
				characters[index] = characters[index+1];
				index++;
			}
			characters[index] = null;
			size--;
			return true;
		}
		return false;
	}
	
	public void displayAllCharacters() {
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
	
	public void allAttack() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				characters[i].attack(characters[j]);
			}
		}
	}
}
