package ch.pearcenet.tui.menu;

import ch.pearcenet.tui.Input;

public class NumberMenu extends Menu implements Offerable{

	public NumberMenu(String title, String[] options) {
		super(title, options);
		for (int i=0; i<super.numOptions; i++) {
			this.options[i] = (i+1)+". "+this.options[i];
		}
	}

	@Override
	public void print() {
		super.print();
	}

	@Override
	public int getResult() {
		int result;
		System.out.print("\n");
		if (!Input.isOpened()) {
			Input.openScanner();
			System.err.println("Warning: Scanner was not initialized properly!");
			result = Input.getInt(1, super.numOptions);
			Input.closeScanner();
		} else {
			result = Input.getInt(1, super.numOptions);
		}
		return result-1;
	}

}
