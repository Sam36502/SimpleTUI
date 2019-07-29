package ch.pearcenet.tui.input.menu;

import ch.pearcenet.tui.input.Input;

public class TextMenu extends Menu implements Offerable {
	
	public TextMenu(String title, String... options) {
		super(title, options);
	}
	
	//Prints out the TextMenu
	public void print() {
		super.print();
	}
	
	//Gets the result of the menu from the user
	public int getResult() {
		String sel;
		do {
			if (!Input.isOpened()) {
				Input.openScanner();
				System.out.println("Warning: The scanner was not initialized.");
				sel = Input.getString().toLowerCase();
				Input.closeScanner();
			} else {
				sel = Input.getString().toLowerCase();
			}
			for (int i = 0; i < options.length; i++) {
				if ((options[i].toLowerCase().split(" ")[0].equals(sel)) || (options[i].toLowerCase().equals(sel))) {
					return i;
				}
			}
			System.out.println("Warning: Invalid option.");
		} while (!"exit".equals(sel));
		return -1;
	}
}
