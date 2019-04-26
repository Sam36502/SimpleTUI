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
				sel = Input.getString();
				Input.closeScanner();
			} else {
				sel = Input.getString();
			}
			for (int i=0; i<options.length; i++) {
				if (options[i].equals(sel)) {
					return i;
				}
			}
		} while (!"exit".equals(sel));
		return 0;
	}

}
