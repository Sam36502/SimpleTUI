package ch.pearcenet.tui.output;

/**
 * Output Class
 * Provides many static methods for formatting output
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.1
 */
public class Output {

	/**
	 * Takes a string and returns the string with '-'
	 * characters as an underline, with optional overflow
	 * either side of the string.
	 *
	 * @param str The string to underline
	 * @param overflow The number of extra underlines to add either side of the string
	 * @return The formatted string including a trailing newline
	 */
	public static String underline (String str, int overflow) {
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

	/**
	 * Takes a bitmap matrix and displays an image
	 * where every 1 is a '#' and every other
	 * number is a ' '.
	 *
	 * @param image An integer matrix in the shape of an image to be displayed
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(int[][] image) {
		return bitmap(image, '#');
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
		String out = "";

		for (int x = 0; x < image.length; x++) {
			for (int y = 0; y < image[x].length; y++) {
				if (image[x][y] == 1) {
					out = out + pixel;
				} else {
					out = out + " ";
				}
			}
			out = out + "\n";
		}

		return out;
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
		String out = "";

		for (int x = 0; x < image.length; x++) {
			for (int y = 0; y < image[x].length; y++) {
				if (image[x][y] == 0) {
					out = out + " ";
				} else if (image[x][y] <= charset.length) {
					out = out + charset[(image[x][y] - 1)];
				}
			}
			out = out + "\n";
		}

		return out;
	}

	/**
	 * Takes a bitmap matrix and displays an image
	 * where every true is a '#' and every false is a ' '.
	 *
	 * @param image A boolean matrix in the shape of an image to be displayed
	 * @return The image formatted as a string to be displayed
	 */
	public static String bitmap(boolean[][] image) {
		return bitmap(image, '#');
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
		String out = "";

		for (int x = 0; x < image.length; x++) {
			for (int y = 0; y < image[x].length; y++) {
				if (image[x][y]) {
					out = out + pixel;
				} else {
					out = out + " ";
				}
			}
			out = out + "\n";
		}

		return out;
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
		String out = "";
		int longest = 0;

		Object[][] arrayOfObject = mat;
		int j = mat.length;
		for (int i = 0; i < j; i++) {
			Object[] x = arrayOfObject[i];
			for (Object y : x)
				if (y.toString().length() > longest)
					longest = y.toString().length();
		}
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				for (int i = 0; i < longest - mat[x][y].toString().length(); i++)
					out = out + " ";
				out = out + mat[x][y] + " ";
			}
			out = out + "\n";
		}

		return out;
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
		String out = "";
		int longest = 0;

		int[][] arrayOfInt = mat;
		int j = mat.length;
		for (int i = 0; i < j; i++) {
			int[] x = arrayOfInt[i];
			for (int y : x)
				if ((y + "").length() > longest)
					longest = (y + "").length();
		}
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				for (int i = 0; i < longest - (mat[x][y] + "").length(); i++)
					out = out + " ";
				out = out + mat[x][y] + " ";
			}
			out = out + "\n";
		}

		return out;
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
		String out = "";
		int longest = 0;

		double[][] arrayOfDouble = mat;
		int j = mat.length;
		for (int i = 0; i < j; i++) {
			double[] x = arrayOfDouble[i];
			for (double y : x)
				if ((y + "").length() > longest)
					longest = (y + "").length();
		}
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++) {
				for (int i = 0; i < longest - (mat[x][y] + "").length(); i++)
					out = out + " ";
				out = out + mat[x][y] + " ";
			}
			out = out + "\n";
		}

		return out;
	}

}
