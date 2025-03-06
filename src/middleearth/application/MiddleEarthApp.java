package middleearth.application;

import java.util.Scanner;

public class MiddleEarthApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu(scanner);
		System.out.println("Welcome to Middle-Earth Madness!");
		System.out.println();
		program:
		while (true) {
			switch (menu.displayMainMenu()) {
			case 1:
				menu.userAddCharacter();
				System.out.println();
				break;
			case 2:
				menu.viewAllCharacters();
				System.out.println();
				break;
			case 3:
				menu.updateCharacter();
				System.out.println();
				break;
			case 4:
				menu.deleteCharacter();
				System.out.println();
				break;
			case 5:
				menu.allAttack();
				System.out.println();
				break;
			default:
				break program;
			}
		}
	}

}
