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
		return null;
	}
	
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		return false;
	}
	
	public boolean deleteCharactrer(MiddleEarthCharacter character) {
		return false;
	}
	
	public void displayAllCharacters() {
		//Displays all characters
	}
}
