package ch.pearcenet.tui.input.menu;

import ch.pearcenet.tui.input.Input;

public class SimpleTextMenu extends Menu implements Offerable {
	
	public SimpleTextMenu(String title, String... options) {
		super(title, options);
	}
	
	//Outputs the TextMenu
	public void print() {
		super.print();
	}
	
	//Gets the result of the menu from the user
	public int getResult() {

		String sel;
		do {
			if (!Input.isOpened()) {
				Input.openScanner();
				System.out.println("Warning: Scanner was not initialized.");
				sel = Input.getString().toLowerCase();
				Input.closeScanner();
			} else {
				sel = Input.getString().toLowerCase();
			}
			for (int i = 0; i < options.length; i++) {
				if (options[i].toLowerCase().equals(sel)) {
					return i;
				}
			}
			System.out.println("Warning: Invalid option");
		} while (!"exit".equals(sel));
		return 0;
	}
}
