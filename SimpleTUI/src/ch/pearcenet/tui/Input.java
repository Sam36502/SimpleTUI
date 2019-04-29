package ch.pearcenet.tui;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	
	private static Scanner input;
	private static String prompt = " -> ";
	private static boolean isOpen = false;
	
	//Sets the input prompt
	public static void setPrompt(String p) {
		prompt = p;
	}
	
	/*
	 * 	Scanner Control
	 */
	
	//Initializes the input scanner
	public static void openScanner() {
		input = new Scanner(System.in);
		isOpen = true;
	}
	
	//Closes the input scanner
	public static void closeScanner() {
		if (input != null) {
			input.close();
		}
		isOpen = false;
	}
	
	//Returns whether input is open or not
	public static boolean isOpened() {
		return isOpen;
	}
	
	/*
	 * 	String Input
	 */
	
	//Gets a string from input
	public static String getString() {
		System.out.print(prompt);
		return input.nextLine();
	}
	
	/*
	 * 	Boolean Input
	 */
	
	public static boolean getBool() {
		System.out.print("(y/n)");
		
		String in;
		boolean isValid = false;
		boolean result = false;
		
		do {
			in = Input.getString().toLowerCase();
			if ("y".equals(in) || "yes".equals(in)) {
				result = true;
				isValid = true;
			} else if ("n".equals(in) || "no".equals(in)) {
				result = false;
				isValid = true;
			} else {
				System.out.println("Warning: Only y/n allowed.");
			}
		} while (!isValid);
		return result;
	}
	
	/*
	 * 	Filename Input
	 */
	
	//Gets a file from user
	public static File getFile() {
		boolean isValid = false;
		File res;
		do {
			res = new File(Input.getString());
			if (res.exists()) {
				isValid = true;
			} else {
				System.out.println("Warning: That file doesn't exist.");
			}
		} while (!isValid);
		return res;
	}
	
	/*
	*
	*	INTEGER INPUT FUNCTIONS
	*
	*/
	
	//Gets an Integer from input
	public static int getInt() {
		String str;
		int tmp = 0;
		boolean isValid = false;
		
		//keep reading input until the input is a number
		do {
			System.out.print(prompt);
			str = input.nextLine();
			try {
				tmp = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: only whole numbers are allowed.");
				continue;
			}
			isValid = true;
		} while (!isValid);
		
		return tmp;
	}
	
	//Gets an integer from input within a certain range
	public static int getInt(int min, int max) {
		String str;
		int tmp = 0;
		boolean isValid = false;
		
		//keep reading input until the input is a number and within range
		do {
			System.out.print(prompt);
			str = input.nextLine();
			try {
				tmp = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: only whole numbers are allowed.");
				continue;
			}
			
			//Check if value is within range
			if (tmp >= min && tmp <= max) {
				isValid = true;
			} else {
				System.out.println("Warning: only whole numbers between "+min+" and "+max+" are allowed.");
			}
		} while (!isValid);
		
		return tmp;
	}
	
	//Gets an integer from input within a certain set of numbers
	public static int getInt(ArrayList<Integer> range) {
		String str;
		int tmp = 0;
		boolean isValid = false;
		
		//keep reading input until the input is a number and within range
		do {
			System.out.print(prompt);
			str = input.nextLine();
			try {
				tmp = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: only whole numbers are allowed.");
				continue;
			}
			
			//Check if value is within range
			if (range.contains(tmp)) {
				isValid = true;
			} else {
				System.out.print("Warning: only the numbers ");
				Output.sentenceArray(range.toArray());
				System.out.println(" are allowed");
			}
		} while (!isValid);
		
		return tmp;
	}
	
	//Reads an array of integers from user with a pre-set size
	public static int[] getIntArray(int len) {
		int[] res = new int[len];
		
		do {
			System.out.println(" ");
			for (int i=0; i<len; i++) {
				System.out.println("["+(i+1)+"]");
				res[i] = Input.getInt();
			}
			
			for (int i=0; i<len; i++) {
				System.out.print("["+res[i]+"] ");
			}
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return res;
	}
	
	//Reads an array of integers from user
	public static int[] getIntArray() {
		int len;
		
		do {
			System.out.println("How many values do you want to enter?");
			len = Input.getInt();
			
			for (int i=0; i<len; i++) {
				System.out.print("["+(i+1)+"] ");
			}
			
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		
		
		int[] res = new int[len];
		
		do {
			System.out.println(" ");
			for (int i=0; i<len; i++) {
				System.out.println("["+(i+1)+"]");
				res[i] = Input.getInt();
			}
			
			for (int i=0; i<len; i++) {
				System.out.print("["+res[i]+"] ");
			}
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return res;
	}
	
	//Gets a matrix of integers from the user
	public static int[][] getMatrix(int width, int height) {
		int[][] result = new int[height][width];
		
		do {
			for (int i=1; i<=width*height; i++) {
				if (i % width == 0) {
					System.out.println("["+i+"]");
				} else {
					System.out.print("["+i+"] ");
				}
			}
			
			for (int y=0; y<height; y++) {
				for (int x=0; x<width; x++) {
					System.out.println("["+(x*y+1)+"]");
					result[y][x] = Input.getInt();
				}
			}
			
			for (int y=0; y<height; y++) {
				for (int x=0; x<width; x++) {
					System.out.print("["+result[y][x]+"]");
				}
				System.out.println(" ");
			}
			
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		
		return result;
	}
	
	/*
	*
	*	DOUBLE INPUT FUNCTIONS
	*
	*/
	
	//Gets a double from input
	public static double getDouble() {
		String str;
		double tmp = 0.0;
		boolean isValid = false;
		
		//keep reading input until the input is a number
		do {
			System.out.print(prompt);
			str = input.nextLine();
			try {
				tmp = Double.parseDouble(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: only numbers are allowed.");
				continue;
			}
			isValid = true;
		} while (!isValid);
		
		return tmp;
	}
	
	//Gets an double from input within a certain range
	public static Double getDouble(double min, double max) {
		String str;
		double tmp = 0;
		boolean isValid = false;
		
		//keep reading input until the input is a number and within range
		do {
			System.out.print(prompt);
			str = input.nextLine();
			try {
				tmp = Double.parseDouble(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: only whole numbers are allowed.");
				continue;
			}
			
			//Check if value is within range
			if (tmp >= min && tmp <= max) {
				isValid = true;
			} else {
				System.out.println("Warning: only whole numbers between "+min+" and "+max+" are allowed.");
			}
		} while (!isValid);
		
		return tmp;
	}
	
	//Gets a double from input within a certain set of numbers
	public static double getDouble(ArrayList<Double> range) {
		String str;
		double tmp = 0;
		boolean isValid = false;
		
		//keep reading input until the input is a number and within range
		do {
			System.out.print(prompt);
			str = input.nextLine();
			try {
				tmp = Double.parseDouble(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: only numbers are allowed.");
				continue;
			}
			
			//Check if value is within range
			if (range.contains(tmp)) {
				isValid = true;
			} else {
				System.out.print("Warning: only the numbers ");
				Output.sentenceArray(range.toArray());
				System.out.println(" are allowed");
			}
		} while (!isValid);
		
		return tmp;
	}

}
