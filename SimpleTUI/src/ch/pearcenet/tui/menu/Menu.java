package ch.pearcenet.tui.menu;

public class Menu {
	
	protected String title;
	protected String[] options;
	protected int numOptions;
	
	//Constructor
	public Menu (String title, String[] options) {
		this.title = title;
		this.options = options.clone();
		numOptions = options.length;
	}
	
	/*
	 * 	Functions
	 */
	
	public void print() {
		System.out.println("\n"+title+"\n");
		for (String opt: options) {
			System.out.println(opt);
		}
	}
	
	public String getOption(int index) {
		if (index <= numOptions && index > 0) {
			return options[index];
		}
		return "Warning: That index is out of range. (0-"+numOptions+")";
	}

}
