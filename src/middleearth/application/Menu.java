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

public class Menu {
	private Scanner scanner;
	private CharacterManager manager;
	public Menu(Scanner scanner) {
		this.scanner = scanner;
		this.manager = MiddleEarthCouncil.getInstance().getCharacterManager();
	}
	
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
	public int selectOption(int first, int last) {
		int tries = 3;
		while (tries >= 0) {
			int selection = scanner.nextInt();
			if (selection >= first && selection <= last) {
				return selection;
			}
			System.out.println("Sorry, your selection was invalid.");
			System.out.println(tries + " tries remaining.");
			tries--;
		}
		return -1;
	}
	public void userAddCharacter() {
		System.out.println("What would you like the name of the character to be?: ");
		String name = scanner.next();
		System.out.println("How much health will " + name + " have?: ");
		double health = scanner.nextDouble();
		System.out.println("How much power will " + name + " have?: ");
		double power = scanner.nextDouble();
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
		switch (scanner.nextInt()) {
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
			return;
		}
		manager.addCharacter(character);
	}
}
