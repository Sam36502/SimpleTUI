package ch.pearcenet.tui.input.menu;

public class Menu {
	
	protected String title;
	protected String[] options;
	protected int numOptions;

	public Menu(String title, String[] options) {
		this.title = title;
		this.options = ((String[]) options.clone());
		numOptions = options.length;
	}
	
	//Sets the title of this Menu
	public void setTitle(String title) {
		this.title = title;
	}
	
	//Outputs this menu
	public void print() {
		System.out.println("\n" + title + "\n");
		for (String opt: options) {
			System.out.println(opt);
		}
	}
	
	//Gets an option
	public String getOption(int index) {
		if ((index < numOptions) && (index > -1)) {
			return options[index];
		}
		return "Error: Invalid index. (0-" + numOptions + ")";
	}
}
