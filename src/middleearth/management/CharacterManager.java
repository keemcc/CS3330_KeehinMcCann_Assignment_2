package middleearth.management;

import middleearth.characters.MiddleEarthCharacter;


/**
 * CharacterManager holds an array of MiddleEarthCharacters and contains methods to manipulate that array
 */
public class CharacterManager {
	/**
	 * Character array held
	 */
	private MiddleEarthCharacter[] characters;
	/**
	 * Number of characters in the array
	 */
	private int size;
	
	/**
	 * Creates a new character manager of size 0
	 */
	public CharacterManager() {
		size = 0;
	}
	
	/**
	 * Adds a character to the MiddleEarthCharacter array
	 * @param c character to be added
	 * @return true if successful
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		//If the size is 0 there is no array created yet
		if (size == 0) {
			System.out.println("Character array size was 0, resizing to 1.");
			size = 1;
			//Create array and assign the character to the only index of the array
			characters = new MiddleEarthCharacter[1];
			characters[0] = c;
			return true;
		}
		
		//If the size is equal to the array length, the array is full and must double in size
		if (size == characters.length) {
			System.out.println("Resizing array from " + size + " to " + (size*2));
			//Create a new array double the size of the old one
			MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[(characters.length) * 2];
			//Copy all characters from the old array to the new one
			for (int i = 0; i < size; i++) {
				newCharacters[i] = characters[i];
			}
			//Set the array to be the new one
			characters = newCharacters;
		}
		size++;
		//Insert new character at the end of the array
		characters[size-1] = c;
		return true;
	}
	
	/**
	 * Returns the character in the array with the passed name
	 * @param name name of the character to find
	 * @return the character if it is found, or null if it is not found
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		System.out.println("Searching for " + name);
		//Searches through all characters until it finds one with the passed name or the end of the array
		for (int i = 0; i < size; i++) {
			if (characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	/**
	 * Updates a character in the array
	 * @param character the character to be updated
	 * @param name new name of the character
	 * @param health new health of the character
	 * @param power new power of the character
	 * @return true if the character was found and successfully updated, false if not found or if it was unchanged
	 */
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power) {
		//If all values of the character are the same, there is nothing to be changed
		if ((character.getHealth() == health) && (character.getName().equals(name)) && (character.getPower() == power)) {
			return false;
		}
		//Search for the character and if it is found, set all values to be the new ones
		for (int i = 0; i < size; i++) {
			if (character == characters[i]) {
				characters[i].setName(name);
				characters[i].setHealth(health);
				characters[i].setPower(power);
				return true;
			}
		}
		//Character was not found, return false
		return false;
	}
	
	/**
	 * Deletes the passed character from the array, shifts all remaining elements to fill gap
	 * @param character character to be deleted
	 * @return true if successfully deleted, false if character was not found
	 */
	public boolean deleteCharactrer(MiddleEarthCharacter character) {
		int index = 0;
		boolean found = false;
		//Find the character and set their spot in the array to be null
		while (index < size) {
			if (characters[index] == character) {
				characters[index] = null;
				found = true;
				break;
			}
			index++;
		}
		//If the character was found, shift the rest of the elements to the left to fill the hole it left
		if (found) {
			while (index < size-1) {
				characters[index] = characters[index+1];
				index++;
			}
			characters[index] = null;
			size--;
			return true;
		}
		//Character was not found, return false
		return false;
	}
	
	/**
	 * Displays all the characters in the array by calling the displayInfo() method for each character
	 */
	public void displayAllCharacters() {
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
	
	/**
	 * Causes all characters to attack each other by iterating through the array with two loops and calls attack from one index to the other
	 */
	public void allAttack() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				characters[i].attack(characters[j]);
			}
		}
	}
}
