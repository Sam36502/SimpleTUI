package ch.pearcenet.tui.input;

import ch.pearcenet.tui.output.ArrayOutput;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Input {

	private static Scanner input;
	private static String prompt = " -> ";
	private static boolean isOpen = false;
	
	//Set what to use when prompting the user for input
	public static void setPrompt(String p) {
		prompt = p;
	}
	
	//Opens the scanner for getting input
	public static void openScanner() {
		input = new Scanner(System.in);
		isOpen = true;
	}
	
	//Closes the scanner if it's open
	public static void closeScanner() {
		if (input != null) {
			input.close();
		}
		isOpen = false;
	}
	
	//Checks whether the scanner has been closed
	public static boolean isOpened() {
		return isOpen;
	}
	
	//Prompts the user for a string and returns it
	public static String getString() {
		System.out.print(prompt);
		String read = input.nextLine();
		return read;
	}
	
	//Prompts the user to answer with yes or no and returns a boolean
	public static boolean getBool() {

		System.out.print("(y/n)");

		boolean isValid = false;
		boolean result = false;
		String in;
		
		do {
			in = getString().toLowerCase();
			if ("y".equals(in) || "yes".equals(in)) {
				result = true;
				isValid = true;
			} else if ("n".equals(in) || "no".equals(in)) {
				result = false;
				isValid = true;
			} else {
				System.out.println("Warning: Only yes or no answers are allowed.");
			}
		} while (!isValid);

		return result;
	}
	
	//Prompts a user for the name of a file and returns the file object
	public static File getFile() {
		boolean isValid = false;
		File res;
		do {
			res = new File(getString());
			if (res.exists()) {
				isValid = true;
			} else {
				System.out.println("Warning: That file doesn't exist.");
			}
		} while (!isValid);
		return res;
	}
	
	//Gets a number from the user and handles most possible errors that could occur
	public static int getInt() {

		BigInteger tmp = null;
		int tmp2 = 0;
		
		boolean isValid = false;

		do {
			System.out.print(prompt);
			String str = input.nextLine();
			
			//Try to convert the string to an integer
			try {
				tmp = new BigInteger(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: Only whole numbers are allowed.");
				continue;
			}
			
			//Try to convert to a regular sized integer
			try {
				tmp2 = Integer.parseInt(tmp.toString());
			} catch (NumberFormatException e) {
				
				//If the num is smaller than an int
				if (tmp.toString().charAt(0) == '-') {
					System.out.println("Warning: That number is too small.");
					System.out.println(" (min. -2147483648)");
					
				//If the num is bigger than an int
				} else {
					System.out.println("Warning: That number is too big.");
					System.out.println(" (max. 2147483647)");
				}
			}

			isValid = true;
		} while (!isValid);
		return tmp2;
	}
	
	//gets an integer from withing a range
	public static int getInt(int min, int max) {
		int tmp = 0;
		boolean isValid = false;

		do {
			tmp = getInt();

			if ((tmp >= min) && (tmp <= max)) {
				isValid = true;
			} else {
				System.out.println("Warning: Only whole numbers between "+min+" and "+max+" are allowed.");
			}
		} while (!isValid);
		return tmp;
	}
	
	//gets an integer from a specific set of numbers
	public static int getInt(int... range) {
		int tmp = 0;
		boolean isValid = false;

		do {
			tmp = getInt();

			if (contains(range, tmp)) {
				isValid = true;
			} else {
				System.out.println("Warning: Only the numbers " + ArrayOutput.sentenceArray(range) + " are allowed.");
			}
		} while (!isValid);
		return tmp;
	}	
	
	//gets a double of any size and handles most error that could occur
	public static double getDouble() {

		double tmp = 0.0D;
		boolean isValid = false;

		do {
			System.out.print(prompt);
			String str = input.nextLine();
			try {
				tmp = Double.parseDouble(str);
			} catch (NumberFormatException e) {
				System.out.println("Warning: Only numbers are allowed.");
				continue;
			}
			isValid = true;
		} while (!isValid);
		return tmp;
	}
	
	//gets a double from within a specific range
	public static Double getDouble(double min, double max) {
		double tmp = 0.0D;
		boolean isValid = false;

		do {
			tmp = getDouble();

			if ((tmp >= min) && (tmp <= max)) {
				isValid = true;
			} else {
				System.out.println("Warning: Only numbers between "+min+" and "+max+" are allowed.");
			}
		} while (!isValid);
		return Double.valueOf(tmp);
	}
	
	//gets a double from a set of specific values
	public static double getDouble(double... range) {
		double tmp = 0.0D;
		boolean isValid = false;

		do {
			tmp = getDouble();

			if (contains(range, tmp)) {
				isValid = true;
			} else {
				System.out.println("Warning: only the numbers " + ArrayOutput.sentenceArray(range) + " are allowed.");
			}
		} while (!isValid);
		return tmp;
	}

	//Simple hidden method to see if an int array contains a certain value
	private static boolean contains(int[] arr, int val) {
		int[] arrayOfInt = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			int curr = arrayOfInt[i];
			if (val == curr) {
				return true;
			}
		}
		return false;
	}
	
	//Simple hidden method to see if a double array contains a certain value
	private static boolean contains(double[] arr, double val) {
		double[] arrayOfDouble = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			double curr = arrayOfDouble[i];
			if (val == curr) {
				return true;
			}
		}
		return false;
	}
}
