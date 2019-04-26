package ch.pearcenet.tui.menu;

public class Menu {
	
	protected String title;
	protected String[] options;
	protected int numOptions;
	
	/*
	 * 	Constructors
	 */
	
	public Menu (String title, String[] options) {
		this.title = title;
		this.options = options;
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

}
