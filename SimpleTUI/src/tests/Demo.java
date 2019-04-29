package tests;

import ch.pearcenet.tui.Input;
import ch.pearcenet.tui.Output;
import ch.pearcenet.tui.menu.*;

public class Demo {

	public static void main(String[] args) {
		Input.openScanner();
		
		int[][] matrix = Input.getMatrix(5, 5);
		Output.println(Output.printMatrix(matrix));
		
		Input.closeScanner();
	}

}
