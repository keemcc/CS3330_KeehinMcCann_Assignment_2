package middleearth.application;

import java.util.Scanner;

public class MiddleEarthApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu(scanner);
		program:
		while (true) {
			switch (menu.displayMainMenu()) {
			case 1:
				menu.userAddCharacter();
				break;
			case 2:
				menu.viewAllCharacters();
				break;
			case 3:
				menu.updateCharacter();
				break;
			case 4:
				menu.deleteCharacter();
				break;
			case 5:
				break;
			default:
				break program;
			}
		}
	}

}
