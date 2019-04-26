package ch.pearcenet.tui;

public class Output {
	
	/*
	 * 	SIMPLE BITMAP IMAGES
	 */
	
	//returns a 2D array as a Square of ASCII "pixels"
	public static String bitmap(int[][] image) {
		String out = "";
		
		for (int x=0; x<image.length; x++) {
			for (int y=0; y<image[x].length; y++) {
				if (image[x][y] == 1) {
					out += "#";
				} else {
					out += " ";
				}
			}
			out += "\n";
		}
		
		return out;
	}
	
	//returns a 2D array as a Square of user-defined pixels
	public static String bitmap(int[][] image, char pixel) {
		String out = "";
		
		for (int x=0; x<image.length; x++) {
			for (int y=0; y<image[x].length; y++) {
				if (image[x][y] == 1) {
					out += pixel;
				} else {
					out += " ";
				}
			}
			out += "\n";
		}
		
		return out;
	}
	
	//returns a 2D array as a Square, filling from a user-defined charset
		public static String bitmap(int[][] image, char[] charset) {
			String out = "";
			
			for (int x=0; x<image.length; x++) {
				for (int y=0; y<image[x].length; y++) {
					if (image[x][y] == 0) {
						out += " ";
					} else if (image[x][y] <= charset.length){
						out += charset[image[x][y]-1];
					} else {
						System.out.println("Error: Pixel index out of charset range");
					}
				}
				out += "\n";
			}
			
			return out;
		}
	
	//returns a 2D array as a Square of ASCII "pixels"
	public static String bitmap(boolean[][] image) {
		String out = "";
		
		for (int x=0; x<image.length; x++) {
			for (int y=0; y<image[x].length; y++) {
				if (image[x][y]) {
					out += "#";
				} else {
					out += " ";
				}
			}
			out += "\n";
		}
		
		return out;
	}
	
	//returns a 2D array as a Square of user-defined characters
	public static String bitmap(boolean[][] image, char pixel) {
		String out = "";
		
		for (int x=0; x<image.length; x++) {
			for (int y=0; y<image[x].length; y++) {
				if (image[x][y]) {
					out += pixel;
				} else {
					out += " ";
				}
			}
			out += "\n";
		}
		
		return out;
	}
	
	/*
	 * 	MATRICES (2D ARRAYS)
	 */
	
	//returns a 2D array as a Square of integers
	public static String printMatrix(Object[][] mat) {
		String out = "";
		int longest = 0;
		
		//Whoah that escalated quickly! This is just a one-liner to find the length of the longest value of mat
		for (Object[] x: mat) for (Object y: x) if (y.toString().length() > longest) longest = y.toString().length();
		
		for (int x=0; x<mat.length; x++) {
			for (int y=0; y<mat[x].length; y++) {
				for (int i=0; i<longest-mat[x][y].toString().length(); i++) out += " ";
				out += mat[x][y]+" ";
			}
			out += "\n";
		}
		
		return out;
	}
	
	//For non-object ints
	public static String printMatrix(int[][] mat) {
		String out = "";
		int longest = 0;
		
		//Whoah that escalated quickly! This is just a one-liner to find the length of the longest value of mat
		for (int[] x: mat) for (int y: x) if ((""+y).length() > longest) longest = (""+y).length();
		
		for (int x=0; x<mat.length; x++) {
			for (int y=0; y<mat[x].length; y++) {
				for (int i=0; i<longest-(""+mat[x][y]).length(); i++) out += " ";
				out += mat[x][y]+" ";
			}
			out += "\n";
		}
		
		return out;
	}
	
	//For non-object doubles
		public static String printMatrix(double[][] mat) {
			String out = "";
			int longest = 0;
			
			//Whoah that escalated quickly! This is just a one-liner to find the length of the longest value of mat
			for (double[] x: mat) for (double y: x) if ((""+y).length() > longest) longest = (""+y).length();
			
			for (int x=0; x<mat.length; x++) {
				for (int y=0; y<mat[x].length; y++) {
					for (int i=0; i<longest-(""+mat[x][y]).length(); i++) out += " ";
					out += mat[x][y]+" ";
				}
				out += "\n";
			}
			
			return out;
		}
	
	/*
	 * 	ARRAYS
	 */
	
	//returns an Array in the form of a sentence i.e. "1, 2, 3 and 4"
	public static String sentenceArray(Object[] arr) {
		String out = arr[0].toString();
		for (int i=1; i<arr.length-1; i++) {
			out += ", "+arr[i].toString();
		}
		out += " and "+arr[arr.length-1].toString();
		return out;
	}
	//For non-object integers
	public static String sentenceArray(double[] arr) {
		String out = "" + arr[0];
		for (int i=1; i<arr.length-1; i++) {
			out += ", "+arr[i];
		}
		out += " and "+arr[arr.length-1];
		return out;
	}
	//For non-object Doubles
	public static String sentenceArray(int[] arr) {
		String out = "" + arr[0];
		for (int i=1; i<arr.length-1; i++) {
			out += ", "+arr[i];
		}
		out += " and "+arr[arr.length-1];
		return out;
	}

}
