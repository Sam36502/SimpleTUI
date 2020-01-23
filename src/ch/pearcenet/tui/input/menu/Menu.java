package ch.pearcenet.tui.input.menu;

import ch.pearcenet.tui.output.Output;

/**
 * Menu Class
 * Acts as the superclass that the other menu
 */
public class Menu {

	public static enum MenuType {
		NUMBER,
		STRING,
		LETTER
	}

	private String title;
	private String[] options;
	private MenuType type;

	public Menu(String title, String[] options, MenuType type) {
		this.title = title;
		this.options = options;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getOptions() {
		return options;
	}

	public MenuType getType() {
		return type;
	}

	public void setType(MenuType type) {
		this.type = type;
	}

	/**
	 *
	 */
	public void prompt() {
		System.out.println(Output.underline(title, 1));
		for (String opt: options) {
			switch (type) {
				case LETTER:

			}
		}
	}
}
