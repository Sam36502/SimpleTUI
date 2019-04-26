package ch.pearcenet.tui;

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
