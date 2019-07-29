package ch.pearcenet.tui.input.menu;

import ch.pearcenet.tui.input.Input;

public class NumberMenu extends Menu implements Offerable {
	
	public NumberMenu(String title, String... options) {
		super(title, options);
	}
	
	//Prints out the number menu
	public void print() {
		System.out.println(title + "\n");
		for (int i = 0; i < numOptions; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}
	}
	
	//Gets the result of the menu from the user
	public int getResult() {

		System.out.print("\n");
		int result;
		if (!Input.isOpened()) {
			Input.openScanner();
			System.out.println("Warning: Input scanner was not initialized.");
			result = Input.getInt(1, numOptions);
			Input.closeScanner();
		} else {
			result = Input.getInt(1, numOptions);
		}

		return result;
	}
}
