package ch.pearcenet.tui.menu;

import ch.pearcenet.tui.Input;

public class CustomMenu extends Menu implements Offerable {
	
	private String[] optSelectors;

	public CustomMenu(String title, String[] options, String[] optTitles, String[] optSelectors) {
		super(title, options);
		this.optSelectors = optSelectors;
		
		if (optTitles.length != options.length || optSelectors.length != options.length) {
			System.out.println("Warning: option there are too many or too few option titles/selectors."
					+ "Cannot map titles to options");
			return;
		}
		
		for (int i=0; i<this.options.length; i++) {
			this.options[i] = optTitles[i]+" "+this.options[i];
		}
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
					if (optSelectors[i].equals(sel)) {
						return i;
					}
				}
				System.out.println("Warning: Invalid option. Please select an option from the list");
			} while (!"exit".equals(sel));
		return 0;
	}

}
