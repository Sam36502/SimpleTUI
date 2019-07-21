package ch.pearcenet.tui.output;

public class Output {

	// Returns a string left aligned with spaces
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

	// Returns a string right aligned with spaces
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

	// Returns a string center aligned with spaces
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

	// clears the screen and moves the cursor back to (1,1)
	public static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println((char) 13);
		}
	}

	// Returns a string format image from a simple integer bitmap
	public static String bitmap(int[][] image) {
		return bitmap(image, '#');
	}

	// Returns a string format image from a simple integer bitmap with a custom
	// pixel char
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

	// Returns a string format image from a simple integer bitmap with a
	// customizeable charset
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

	// Returns a string format image from a simple boolean-binary bitmap
	public static String bitmap(boolean[][] image) {
		return bitmap(image, '#');
	}

	// Returns a string format image from a simple boolean-binary bitmap with custom
	// pixel char
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

	// Returns a string format image from a simple boolean-binary bitmap with
	// customizable charset
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

	// Prints out an integer matrix
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

	// Prints out a double matrix
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
