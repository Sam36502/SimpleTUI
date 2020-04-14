package ch.pearcenet.tui.input;

import ch.pearcenet.tui.exceptions.CsvSyntaxException;
import ch.pearcenet.tui.output.Output;
import ch.pearcenet.tui.table.Column;
import ch.pearcenet.tui.table.Table;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Input Class
 * Handles user input and checks for errors.
 *
 * @author Samuel Pearce <sam @ aepearce.com></sam>
 * @version 2.1
 */
public class Input {

	/**
	 * Globally reused input scanner
	 */
	private static Scanner input;

	/**
	 * Default prompt message. This can be changed with 'setPrompt()'.
	 */
	private static String prompt = " -> ";

	/**
	 * Stores whether the global Scanner is currently open.
	 */
	private static boolean isOpen = false;

	/*
	 * Basic Input Methods
	 */

	/**
	 * Changes the prompt that's displayed whenever the input methods are called.
	 *
	 * @param promptString What to set the new prompt String to
	 */
	public static void setPrompt(String promptString) {
		prompt = promptString;
	}

	/**
	 * Opens the global input Scanner.
	 */
	public static void openScanner() {
		input = new Scanner(System.in);
		isOpen = true;
	}

	/**
	 * Closes the global input Scanner, if it's open.
	 */
	public static void closeScanner() {
		if (input != null) {
			input.close();
		}
		isOpen = false;
	}

	/**
	 * Checks whether the global input Scanner is open
	 *
	 * @return Whether the global input Scanner is open or not
	 */
	public static boolean isOpened() {
		return isOpen;
	}

	/**
	 * Prompts the user for a String.
	 *
	 * @return The String input by the user
	 */
	public static String getString() {
		System.out.print(prompt);
		return input.nextLine();
	}

	/**
	 * Prompts the user with "yes/no" options. If the user enters
	 * anything other than "yes", "y", "no", or "n" they are told
	 * that the input is invalid.
	 *
	 * @return A boolean if the user's answer was yes
	 */
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
				isValid = true;
			} else {
				System.out.println("Warning: Only yes or no answers are allowed.");
			}
		} while (!isValid);

		return result;
	}

	/**
	 * Prompts the user for a filename. If the file doesn't exist,
	 * the user is told that it couldn't be found and they are
	 * prompted again.
	 *
	 * @return A File object referencing the given file if it exists
	 */
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

	/**
	 * Prompts the user for any integer within the signed integer limit.
	 * Handles the integer being out of range for a signed integer by
	 * prompting the user again and telling them why the input wasn't
	 * accepted.
	 *
	 * @return The integer given by the user
	 */
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

	/**
	 * Prompts the user for an integer in a range. If the user enters
	 * a number less than the minimum value or greater than the maximum,
	 * they are informed that this value is invalid and prompted again.
	 *
	 * @param min Minimum value allowed to be entered
	 * @param max Maximum value allowed to be entered
	 * @return The integer given by the user
	 */
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

	/**
	 * Prompts the user for an integer in a given range. If the user enters
	 * a number not in the array, they are informed that their selection
	 * is invalid and prompted again.
	 *
	 * @param range An array of integers that may be entered
	 * @return The integer given by the user
	 */
	public static int getInt(int... range) {
		int tmp = 0;
		boolean isValid = false;

		do {
			tmp = getInt();

			if (contains(range, tmp)) {
				isValid = true;
			} else {
				System.out.println("Warning: Only the numbers " + Output.oxfordSentenceFormat(range) + " are allowed.");
			}
		} while (!isValid);
		return tmp;
	}

	/**
	 * Prompts the user for a double precision floating point number.
	 * If the number entered is outside of the range of double precision
	 * numbers, the user is informed why their input was not accepted
	 * and they are prompted for input again
	 *
	 * @return The double entered by the user
	 */
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

	/**
	 * Prompts the user for a double precision floating point number
	 * within the given range. If the number entered is less than the
	 * minimum value allowed or greater than the maximum value allowed,
	 * the user is informed why their input failed and prompted again.
	 *
	 * @param min Minimum allowed value
	 * @param max Maximum allowed value
	 * @return The double entered by the user
	 */
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
		return tmp;
	}

	/**
	 * Prompts the user for a double precision floating point number
	 * out of a range of possible choices. If the user enters a
	 * number not in the array of given values, they are informed why
	 * the input wasn't accepted and prompted for a number again.
	 *
	 * @param range An array of allowed input values
	 * @return The double entered by the user
	 */
	public static double getDouble(double... range) {
		double tmp = 0.0D;
		boolean isValid = false;

		do {
			tmp = getDouble();

			if (contains(range, tmp)) {
				isValid = true;
			} else {
				System.out.println("Warning: only the numbers " + Output.oxfordSentenceFormat(range) + " are allowed.");
			}
		} while (!isValid);
		return tmp;
	}

	//Simple hidden method to see if an int array contains a certain value
	private static boolean contains(int[] arr, int val) {
		for (int curr : arr) {
			if (val == curr) {
				return true;
			}
		}
		return false;
	}
	
	//Simple hidden method to see if a double array contains a certain value
	private static boolean contains(double[] arr, double val) {
		for (double curr : arr) {
			if (val == curr) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Array Input Methods
	 */

	/**
	 * Prompts the user for an integer array with a predefined
	 * length. The user is asked to confirm their choice and
	 * may re-enter all the values if they don't confirm their choice.
	 *
	 * @param len Length of the array to prompt the user for.
	 * @return The integer array entered by the user.
	 */
	public static ArrayList<Integer> getIntArray(int len) {
		return ArrayInput.getIntArray(len);
	}
	/**
	 * Prompts the user for an integer array size and then prompts
	 * them for that many integers. The user will be asked to confirm
	 * the array's contents. If the user does not agree with the array's
	 * contents, they can re-enter all elements of the array again.
	 *
	 * @return The integer array entered by the user.
	 */
	public static ArrayList<Integer> getIntArray() {
		return ArrayInput.getIntArray();
	}
	/**
	 * Prompts the user for a double array with a predefined
	 * length. The user is asked to confirm their choice and
	 * may re-enter all the values if they don't confirm their choice.
	 *
	 * @param len Length of the array to prompt the user for.
	 * @return The double array entered by the user.
	 */
	public static ArrayList<Double> getDoubleArray(int len) {
		return ArrayInput.getDoubleArray(len);
	}
	/**
	 * Prompts the user for an double array size and then prompts
	 * them for that many doubles. The user will be asked to confirm
	 * the array's contents. If the user does not agree with the array's
	 * contents, they can re-enter all elements of the array again.
	 *
	 * @return The integer array entered by the user.
	 */
	public static ArrayList<Double> getDoubleArray() {
		return ArrayInput.getDoubleArray();
	}
	/**
	 * Prompts the user for a String array with a predefined
	 * length. The user is asked to confirm their choice and
	 * may re-enter all the values if they don't confirm their choice.
	 *
	 * @param len Length of the array to prompt the user for.
	 * @return The String array entered by the user.
	 */
	public static ArrayList<String> getStringArray(int len) {
		return ArrayInput.getStringArray(len);
	}
	/**
	 * Prompts the user for a String array size and then prompts
	 * them for that many Strings. The user will be asked to confirm
	 * the array's contents. If the user does not agree with the array's
	 * contents, they can re-enter all elements of the array again.
	 *
	 * @return The String array entered by the user.
	 */
	public static ArrayList<String> getStringArray() {
		return ArrayInput.getStringArray();
	}

	/*
	 * Matrix Input Methods
	 */

	/**
	 * Prompts the user to enter a matrix of integers.
	 * Displays the current state of the matrix in a grid.
	 * The screen is also cleared after every cell prompt.
	 *
	 * @param width The width of the desired return matrix
	 * @param height The height of the desired return matrix
	 * @return A 2D array of the size given filled by the user's input
	 */
	public static int[][] getIntMatrix(int width, int height) {
		return MatrixInput.getIntMatrix(width, height);
	}
	/**
	 * Prompts the user to enter a matrix of double precision floating point numbers.
	 * Displays the current state of the matrix in a grid.
	 * The screen is also cleared after every cell prompt.
	 *
	 * @param width The width of the desired return matrix
	 * @param height The height of the desired return matrix
	 * @return A 2D array of the size given filled by the user's input
	 */
	public static double[][] getDoubleMatrix(int width, int height) {
		return MatrixInput.getDoubleMatrix(width, height);
	}
	/**
	 * Prompts the user to enter a matrix of strings.
	 * Displays the current state of the matrix in a grid.
	 * The screen is also cleared after every cell prompt.
	 *
	 * @param width The width of the desired return matrix
	 * @param height The height of the desired return matrix
	 * @return A 2D array of the size given filled by the user's input
	 */
	public static String[][] getStringMatrix(int width, int height) {
		return MatrixInput.getStringMatrix(width, height);
	}
	/**
	 * Loads a String from a file and returns it.
	 * Uses CRLF as line separator.
	 * @param filename The file to load from
	 * @return A String with the file contents
	 * @throws IOException Thrown if the file couldn't be loaded
	 */
	public static String loadStringFromFile(String filename) throws IOException {
		return FileInput.loadString(filename);
	}
	/**
	 * Loads an array of integers from a file.
	 * @param filename The file to load the data from
	 * @return The array of integers loaded from the file
	 * @throws IOException Thrown if the data couldn't be loaded
	 */
	public static int[] loadIntArrayFromFile(String filename) throws Exception {
		return FileInput.loadIntArray(filename);
	}
	/**
	 * Loads an array of doubles from a file.
	 * @param filename The file to load the data from
	 * @return The array of doubles loaded from the file
	 * @throws IOException Thrown if the data couldn't be loaded
	 */
	public static double[] loadDoubleArrayFromFile(String filename) throws Exception {
		return FileInput.loadDoubleArray(filename);
	}
	/**
	 * Loads an array of Strings from a file.
	 * @param filename The file to load the data from
	 * @return The array of Strings loaded from the file
	 * @throws IOException Thrown if the data couldn't be loaded
	 */
	public static String[] loadStringArrayFromFile(String filename) throws Exception {
		return FileInput.loadStringArray(filename);
	}
	/**
	 * Loads a HashMap from a properties file.
	 * Line comments are denoted by a '#'.
	 * Keys and values are separated by an '='.
	 * There may be any number of spaces between the
	 * equals sign and either key or value.
	 * @param filename The file to load the data from
	 * @return A HashMap of the keys and values
	 * @throws IOException Thrown if the data couldn't be loaded
	 */
	public static HashMap<String, String> loadPropertiesFile(String filename) throws IOException {
		return FileInput.loadProperties(filename);
	}
	/**
	 * Loads a Table from a CSV file.
	 * The CSV follows RFC-4180 format.
	 * @param filename The file to load the data from
	 * @return The Table of loaded data
	 * @throws IOException Thrown if the data couldn't be loaded
	 */
	public static Table loadCSVFile(String filename) throws IOException {
		return FileInput.loadCSV(filename);
	}

}
