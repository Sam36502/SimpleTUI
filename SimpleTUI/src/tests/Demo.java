package tests;

import ch.pearcenet.tui.Input;
import ch.pearcenet.tui.Output;

public class Demo {

	public static void main(String[] args) {
		
		boolean[][] img = {
			{true, false, false, true},
			{false, false, false, false},
			{true, false, false, true},
			{true, true, true, true}
		};
		
		char[] charset = {'*', '#'};
		int[][] img2 = {
			{1, 0, 0, 1},
			{0, 2, 2, 0},
			{1, 0, 0, 1},
			{0, 1, 1, 0},
		};
		
		System.out.println(Output.bitmap(img2, charset));

	}

}
