package ch.pearcenet.tui.output;

/**
 * Output Class
 * Provides many static methods for formatting output
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.1
 */
public class Output {

	/*
	 * Basic Output Formatting Methods
	 */

	/**
	 * Takes a string and returns the string with '-'
	 * characters as an underline, with optional overflow
	 * either side of the string.
	 *
	 * @param str The string to underline
	 * @param overflow The number of extra underlines to add either side of the string
	 * @return The formatted string including a trailing newline
	 */
	public static String underline(String str, int overflow) {
		return " ".repeat(overflow) + str + "\n" + "-".repeat(2*overflow + str.length()) + "\n";
	}

	/**
	 * Takes a string and returns the string left-
	 * padded to a certain length.
	 *
	 * @param text The string to format
	 * @param len The fixed length to pad the string to
	 * @return The string padded with spaces to align the text to the right
	 */
	public static String leftAlign(String text, int len) {
		if (text.length() >= len) {
			return text;
		}
		String res = "";
		for (int i = 0; i < len - text.length(); i++) {
			res = res + " ";
		}
		return text + res;
	}

	/**
	 * Takes a string and returns the string right-
	 * padded to a certain length.
	 *
	 * @param text The string to format
	 * @param len The fixed length to pad the string to
	 * @return The string padded with spaces to align the text to the left
	 */
	public static String rightAlign(String text, int len) {
		if (text.length() >= len) {
			return text;
		}
		String res = "";
		for (int i = 0; i < len - text.length(); i++) {
			res = res + " ";
		}
		return res + text;
	}

	/**
	 * Takes a string and returns the string left-
	 * and right-padded to a certain length.
	 *
	 * @param text The string to format
	 * @param len The fixed length to pad the string to
	 * @return The string padded with spaces to align the text to the centre
	 */
	public static String centerAlign(String text, int len) {
		if (text.length() >= len) {
			return text;
		}
		String res = "";
		int left = (len - text.length()) / 2;
		int right;

		if ((len - text.length()) % 2 == 0) {
			right = left;
		} else {
			right = left + 1;
		}

		for (int i = 0; i < left; i++) {
			res = res + " ";
		}
		res = res + text;
		for (int i = 0; i < right; i++) {
			res = res + " ";
		}
		return res;
	}

	/**
	 * 'Clears' the terminal by displaying 100 Carriage return characters.
	 */
	public static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println((char) 13);
		}
	}

	/*
	 * Array Output Formatting Methods
	 */

	/**
	 * Formats an array of Objects like a natural sentence.
	 * e.g.: {Obj1, Obj2, Obj3} -> "Obj1, Obj2 and Obj3"
	 *
	 * @param arr The array of Objects to format
	 * @return The formatted string
	 */
	public static String sentenceFormat(Object[] arr) {
		return ArrayOutput.sentenceFormat(arr);
	}
	/**
	 * Formats an array of doubles like a natural sentence.
	 * e.g.: {1.1, 2.2, 3.3} -> "1.1, 2.2 and 3.3"
	 *
	 * @param arr The array of doubles to format
	 * @return The formatted string
	 */
	public static String sentenceFormat(double[] arr) {
		return ArrayOutput.sentenceFormat(arr);
	}
	/**
	 * Formats an array of integers like a natural sentence.
	 * e.g.: {1, 2, 3, 4} -> "1, 2, 3 and 4"
	 *
	 * @param arr The array of integers to format
	 * @return The formatted string
	 */
	public static String sentenceFormat(int[] arr) {
		return ArrayOutput.sentenceFormat(arr);
	}
	/**
	 * Formats an array of Objects like a natural sentence.
	 * This version includes the oxford comma
	 * e.g.: {Obj1, Obj2, Obj3} -> "Obj1, Obj2, and Obj3"
	 *
	 * @param arr The array of Objects to format
	 * @return The formatted string
	 */
	public static String oxfordSentenceFormat(Object[] arr) {
		return ArrayOutput.oxfordSentenceFormat(arr);
	}
	/**
	 * Formats an array of doubles like a natural sentence.
	 * This version includes the oxford comma.
	 * e.g.: {1.1, 2.2, 3.3} -> "1.1, 2.2, and 3.3"
	 *
	 * @param arr The array of doubles to format
	 * @return The formatted string
	 */
	public static String oxfordSentenceFormat(double[] arr) {
		return ArrayOutput.oxfordSentenceFormat(arr);
	}
	/**
	 * Formats an array of integers like a natural sentence.
	 * This version includes the oxford comma.
	 * e.g.: {1, 2, 3, 4} -> "1, 2, 3, and 4"
	 *
	 * @param arr The array of integers to format
	 * @return The formatted string
	 */
	public static String oxfordSentenceFormat(int[] arr) {
		return ArrayOutput.oxfordSentenceFormat(arr);
	}
	/**
	 * Formats an array of Objects in square brackets.
	 * e.g.: {Obj1, Obj2, Obj3} -> "[Obj1] [Obj2] [Obj3]"
	 *
	 * @param arr The array of Objects to format
	 * @return The formatted string
	 */
	public static String arrayOut(Object[] arr) {
		return ArrayOutput.arrayOut(arr);
	}
	/**
	 * Formats an array of doubles in square brackets.
	 * e.g.: {1.1, 2.2, 3.3} -> "[1.1] [2.2] [3.3]"
	 *
	 * @param arr The array of doubles to format
	 * @return The formatted string
	 */
	public static String arrayOut(double[] arr) {
		return ArrayOutput.arrayOut(arr);
	}
	/**
	 * Formats an array of integers in square brackets.
	 * e.g.: {1, 2, 3, 4} -> "[1] [2] [3] [4]"
	 *
	 * @param arr The array of integers to format
	 * @return The formatted string
	 */
	public static String arrayOut(int[] arr) {
		return ArrayOutput.arrayOut(arr);
	}
	/**
	 * Formats an array of Objects with a custom style.
	 *
	 * @param arr The array of Objects to format
	 * @param open The string to put before each element
	 * @param close The string to put after each element
	 * @param delimiter The string to put in between each element
	 * @return The formatted string
	 */
	public static String customArray(Object[] arr, String open, String close, String delimiter) {
		return ArrayOutput.customArray(arr, open, close, delimiter);
	}
	/**
	 * Formats an array of doubles with a custom style.
	 *
	 * @param arr The array of doubles to format
	 * @param open The string to put before each element
	 * @param close The string to put after each element
	 * @param delimiter The string to put in between each element
	 * @return The formatted string
	 */
	public static String customArray(double[] arr, String open, String close, String delimiter) {
		return ArrayOutput.customArray(arr, open, close, delimiter);
	}
	/**
	 * Formats an array of integers with a custom style.
	 *
	 * @param arr The array of integers to format
	 * @param open The string to put before each element
	 * @param close The string to put after each element
	 * @param delimiter The string to put in between each element
	 * @return The formatted string
	 */
	public static String customArray(int[] arr, String open, String close, String delimiter) {
		return ArrayOutput.customArray(arr, open, close, delimiter);
	}

	/*
	 * Matrix Output Formatting Methods
	 */

	/**
	 * Takes a bitmap matrix and displays an image
	 * where every 1 is a '#' and every other
	 * number is a ' '.
	 *
	 * @param image An integer matrix in the shape of an image to be displayed
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(int[][] image) {
		return MatrixOutput.bitmap(image);
	}
	/**
	 * Takes a bitmap matrix and displays an image
	 * where every 1 is the pixel char and every other
	 * number is a ' '.
	 *
	 * @param image An integer matrix in the shape of an image to be displayed
	 * @param pixel The character to display every time a 1 is seen in the matrix
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(int[][] image, char pixel) {
		return MatrixOutput.bitmap(image, pixel);
	}
	/**
	 * Takes a integer matrix and displays an image
	 * where every integer maps to a charset. If the
	 * integer is outside of the charset, a ' ' char
	 * is put in it's place.
	 *
	 * @param image An integer matrix in the shape of an image to be displayed
	 * @param charset A character array that maps to the integers in the matrix to make an image
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(int[][] image, char[] charset) {
		return MatrixOutput.bitmap(image, charset);
	}
	/**
	 * Takes a bitmap matrix and displays an image
	 * where every true is a '#' and every false is a ' '.
	 *
	 * @param image A boolean matrix in the shape of an image to be displayed
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(boolean[][] image) {
		return MatrixOutput.bitmap(image);
	}
	/**
	 * Takes a bitmap matrix and displays an image
	 * where every true is the pixel char and every false is a ' '.
	 *
	 * @param image A boolean matrix in the shape of an image to be displayed
	 * @param pixel The character to display every time a true is seen in the matrix
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(boolean[][] image, char pixel) {
		return MatrixOutput.bitmap(image, pixel);
	}
	/**
	 * Displays a matrix of Objects so long as they
	 * have a toString method. The matrix is also
	 * automatically formatted so that each column is the
	 * same width.
	 *
	 * @param mat The matrix of Objects to display
	 * @return A formatted string of the objects toString representations
	 */
	public static String printMatrix(Object[][] mat) {
		return MatrixOutput.printMatrix(mat);
	}
	/**
	 * Displays a matrix of integers. The matrix is
	 * also automatically formatted so that each column
	 * is the same width.
	 *
	 * @param mat The matrix of integers to display
	 * @return A formatted string of the objects toString representations
	 */
	public static String printMatrix(int[][] mat) {
		return MatrixOutput.printMatrix(mat);
	}
	/**
	 * Displays a matrix of doubles. The matrix is
	 * also automatically formatted so that each column
	 * is the same width.
	 *
	 * @param mat The matrix of doubles to display
	 * @return A formatted string of the objects toString representations
	 */
	public static String printMatrix(double[][] mat) {
		return MatrixOutput.printMatrix(mat);
	}

}
