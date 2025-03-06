package middleearth.application;

import java.util.Scanner;

import middleearth.characters.Dwarf;
import middleearth.characters.Elf;
import middleearth.characters.Human;
import middleearth.characters.MiddleEarthCharacter;
import middleearth.characters.Orc;
import middleearth.characters.Wizard;
import middleearth.management.CharacterManager;
import middleearth.management.MiddleEarthCouncil;

/**
 * This class contains the logic for the menu system as well as the methods the menu supports
 */
public class Menu {
	/**
	 * Scanner will be assigned upon creation to receive user input
	 */
	private Scanner scanner;
	/**
	 * The CharacterManager that will each method will perform its operation using
	 */
	private CharacterManager manager;
	/**
	 * Menu Constructor:
	 * Creates a new menu object
	 * @param scanner the scanner object that will be used to receive user input
	 */
	public Menu(Scanner scanner) {
		this.scanner = scanner;
		//Assign the manager to be the singleton instance of a character manager
		this.manager = MiddleEarthCouncil.getInstance().getCharacterManager();
	}
	
	/**
	 * Displays the main menu, with options for what the user would like to do
	 * User will input a number to select an option
	 * @return returns the integer of the operation the user selects, or -1 if the user doesn't properly select a number
	 */
	public int displayMainMenu() {
		System.out.println("What would you like to do?");
		System.out.println("----------------------------");
		System.out.println("1. Add a new character.");
		System.out.println("2. View all characters.");
		System.out.println("3. Update a character.");
		System.out.println("4. Delete a character.");
		System.out.println("5. Execute all characters' attack actions");
		System.out.println("6. Exit.");
		System.out.println();
		System.out.print("Enter a number to select: ");
		return this.selectOption(1, 6);
	}
	/**
	 * Allows the user to attempt to select a valid number selection 3 times before abandoning and giving user a default selection
	 * Will return the number selected, or -1 if failed
	 * @param first the first integer available for selection
	 * @param last the last integer available for selection
	 * @return Returns integer the user selected, or -1 if the user doesn't properly select an integer
	 */
	public int selectOption(int first, int last) {
		//Number of tries the user has until abandoning
		int tries = 3;
		while (tries >= 0) {
			//If the user enters a valid integer, this will execute
			if (scanner.hasNextInt()) {
				int selection = scanner.nextInt();
				//If the integer is within the parameter specified range, it will be returned
				if (selection >= first && selection <= last) {
					return selection;
				}				
			} else {
				//Is executed when user did not enter a valid integer. Throws away invalid input
				scanner.next();
			}
			System.out.println("Sorry, your selection was invalid.");
			System.out.println(tries + " tries remaining.");
			tries--;
		}
		//Error value
		return -1;
	}
	
	/**
	 * Allows the user to add their own character using user input.
	 */
	public void userAddCharacter() {
		System.out.println("What would you like the name of the character to be?: ");
		String name = scanner.next();
		double health, power;
		//Continue to retry if input given is invalid
		while (true) {
			System.out.println("How much health will " + name + " have?: ");
			//Executes when the user enters a double
			if (scanner.hasNextDouble()) {
				health = scanner.nextDouble();
				//Checks to make sure the inputed double is a valid health number (not negative or 0)
				if (validateUserInput(health)) {
					//If it is valid, breaks loop and continues through character creation
					break;
				}
			} else {
				//User did not input a double, input is invalid
				System.out.println("Invalid input type detected.");
				//Throw away invalid input
				scanner.next();
			}
		}
		//Continue to retry if input given is invalid
		while (true) {
			System.out.println("How much power will " + name + " have?: ");
			//Executes when the user enters a double
			if (scanner.hasNextDouble()) {
				power = scanner.nextDouble();
				//Checks to make sure the inputed double is a valid power number (not negative or 0)
				if (validateUserInput(power)) {
					//If it is valid, breaks loop and continues through character creation
					break;
				}
			} else {
				//User did not input a double, input is invalid
				System.out.println("Invalid input type detected.");
				//Throw away invalid input
				scanner.next();
			}
		}
		System.out.println("What type of character would you like to create?");
		System.out.println("-------------------------------------------------");
		System.out.println("1. Elf");
		System.out.println("2. Orc");
		System.out.println("3. Wizard");
		System.out.println("4. Dwarf");
		System.out.println("5. Human");
		System.out.println();
		System.out.println("Enter a selection:");
		MiddleEarthCharacter character;
		//Depending on number returned by the user's selection, assign character to be new object of chosen type
		switch (selectOption(1, 5)) {
		case -1:
			//Happens when user did not enter a valid input after 3 tries, creates a human
			System.out.println("You didn't select properly, so you create a Human!");
			character = new Human(name, health, power);
			break;
		case 1:
			character = new Elf(name, health, power);
			break;
		case 2:
			character = new Orc(name, health, power);
			break;
		case 3:
			character = new Wizard(name, health, power);
			break;
		case 4:
			character = new Dwarf(name, health, power);
			break;
		case 5:
			character = new Human(name, health, power);
			break;
		default:
			//Should not occur, however, I may be wrong
			System.out.println("You broke the program, so you create a Human!");
			character = new Human(name, health, power);
			break;
		}
		System.out.println("You created " + character.getName());
		//Add to manager
		manager.addCharacter(character);
	}
	
	/**
	 * Validates user input double
	 * @param input the double the user input
	 * @return true if it is valid, false if it is invalid
	 */
	public boolean validateUserInput(double input) {
		//Health and power should not be less than or equal to 0
		if (input <= 0) {
			System.out.println("Input cannot be less than or equal to 0!");
			return false;
		}
		return true;
	}
	
	/**
	 * Validates user input int
	 * @param input the int the user input
	 * @return true if it is valid, false if it isn't
	 */
	public boolean validateUserInput(int input) {
		//Health and power should not be less than or equal to 0
		if (input <= 0) {
			System.out.println("Input cannot be less than or equal to 0!");
			return false;
		}
		return true;
	}
	
	/**
	 * Calls the displayAllCharacters() method of the manager to display all characters in the system
	 */
	public void viewAllCharacters() {
		System.out.println();
		System.out.println("Characters currently contained:");
		manager.displayAllCharacters();
	}
	
	/**
	 * Allows user to update a character by finding it with its name and reentering values for it
	 */
	public void updateCharacter() {
		System.out.println("Please enter the name of the character you would like to update:");
		MiddleEarthCharacter character = manager.getCharacter(scanner.next());
		//If character is null, that means it was not found
		while (character == null) {
			System.out.println("The character was not found.");
			System.out.println("1. Retry");
			System.out.println("2. Exit");
			//Give user option to retry, or exit if they give up.
			if (selectOption(1, 2) != 1) {
				return;
			}
			character = manager.getCharacter(scanner.next());
		}
		System.out.println("What will the new name be?: ");
		String name = scanner.next();
		int health, power;
		//Retry if input is invalid
		while (true) {
			System.out.println("What will the new health be?: ");
			// Executes when it is an integer
			if (scanner.hasNextInt()) {
				health = scanner.nextInt();
				//Validate that it is > 0
				if (validateUserInput(health)) {
					break;
				}
			} else {
				//Happens when it is not an integer
				System.out.println("Invalid input type detected.");
				//Throw away bad input
				scanner.next();
			}
		}
		//Retry if input is invalid
		while (true) {
			System.out.println("What will the new power be?: ");
			// Executes when it is an integer
			if (scanner.hasNextInt()) {
				power = scanner.nextInt();
				//Validate that it is > 0
				if (validateUserInput(power)) {
					break;
				}
			} else {
				//Happens when it is not an integer
				System.out.println("Invalid input type detected.");
				//Throw away bad input
				scanner.next();
			}
		}
		//Call the updateCharacter method with the user input values
		//If it is true, that means the character was updated
		if (manager.updateCharacter(character, name, health, power)) {
			System.out.println(name + " was successfully updated.");
		} else {
			//Update was called but the user input the exact information already stored by the character
			System.out.println("You didn't make any changes!");
		}
		return;
	}
	
	/**
	 * User deletes a character by entering the name of the character to delete
	 */
	public void deleteCharacter() {
		System.out.println("Please enter the name of the character you would like to delete:");
		MiddleEarthCharacter character = manager.getCharacter(scanner.next());
		//If character is null then the character was not found
		//Give user option to retry or exit
		while (character == null) {
			System.out.println("The character was not found.");
			System.out.println("1. Retry");
			System.out.println("2. Exit");
			if (selectOption(1, 2) != 1) {
				return;
			}
			character = manager.getCharacter(scanner.next());
		}
		//If deleteCharacter evaluates to true, this means that it was successfully deleted
		if (manager.deleteCharactrer(character)) {
			System.out.println(character.getName() + " was deleted.");
		} else {
			//Should not occur, as the character had to be found to get to this point in the method. Right?
			System.out.println(character.getName() + " wasn't deleted. (not found?)");
		}
	}
	
	/**
	 * Calls the allAttack method of the manager to let all characters attack each other
	 */
	public void allAttack() {
		manager.allAttack();
	}
}
