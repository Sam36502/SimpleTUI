package ch.pearcenet.tui.menu;

import ch.pearcenet.tui.Input;

public class TextMenu extends Menu implements Offerable {

	public TextMenu(String title, String[] options) {
		super(title, options);
	}

	@Override
	public void print() {
		super.print();
	}

	@Override
	public int getResult() {
		String sel;
			do {
				if (!Input.isOpened()) {
					Input.openScanner();
					System.err.println("Warning: Scanner was not initialized properly.");
					sel = Input.getString().toLowerCase();
					Input.closeScanner();
				} else {
					sel = Input.getString().toLowerCase();
				}
				for (int i=0; i<options.length; i++) {
					if (options[i].toLowerCase().split(" ")[0].equals(sel) || options[i].toLowerCase().equals(sel)) {
						return i;
					}
				}
				System.out.println("Warning: Invalid option. Please select the first word of an option from the list");
			} while (!"exit".equals(sel));
		return -1;
	}

}
