package ch.pearcenet.tui.input;

import ch.pearcenet.tui.output.Output;

/**
 * Matrix Input Class
 * Makes receiving a 2D array from users more convenient
 *
 * @author Samuel Pearce <sam @ aepearce.com></sam>
 * @version 2.1
 */
class MatrixInput {
	
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
		
		int[][] result = new int[height][width];
		int widest = 1;
		
		//prompt the user for the value of each cell
		do {
			for (int topY = 0; topY < height; topY++) {
				for (int topX = 0; topX < width; topX++) {

					Output.clearScreen();
					for (int y = 0; y < height; y++) {
						for (int x = 0; x < width; x++) {
							System.out.print("[");
							if ((x == topX) && (y == topY)) {
								for (int z = 0; z < widest; z++)
									System.out.print("#");
							} else if (result[y][x] == 0) {
								for (int z = 0; z < widest; z++)
									System.out.print(" ");
							} else {
								for (int z = 0; z < widest - (result[y][x] + "").length(); z++)
									System.out.print(" ");
								System.out.print(result[y][x]);
							}

							System.out.print("] ");
						}
						System.out.println(" ");
					}

					System.out.println("Enter the value for the selected cell:");
					result[topY][topX] = Input.getInt();
					if ((result[topY][topX] + "").length() > widest) {
						widest = (result[topY][topX] + "").length();
					}
				}
			}
			
			//Display final state of the matrix
			Output.clearScreen();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					System.out.print("[");

					for (int z = 0; z < widest - (result[y][x] + "").length(); z++)
						System.out.print(" ");
					System.out.print(result[y][x]);
					System.out.print("] ");
				}
				System.out.println(" ");
			}
			
			//Confirm matrix contents with user
			System.out.println("Is this correct?");
		} while (!Input.getBool());

		return result;
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

		double[][] result = new double[height][width];
		int widest = 1;
		
		//prompt the user for the value of each cell
		do {
			for (int topY = 0; topY < height; topY++) {
				for (int topX = 0; topX < width; topX++) {

					Output.clearScreen();
					for (int y = 0; y < height; y++) {
						for (int x = 0; x < width; x++) {
							System.out.print("[");
							if ((x == topX) && (y == topY)) {
								for (int z = 0; z < widest; z++)
									System.out.print("#");
							} else if (result[y][x] == 0.0D) {
								for (int z = 0; z < widest; z++)
									System.out.print(" ");
							} else {
								for (int z = 0; z < widest - (result[y][x] + "").length(); z++)
									System.out.print(" ");
								System.out.print(result[y][x]);
							}

							System.out.print("] ");
						}
						System.out.println(" ");
					}

					System.out.println("Enter the value of this cell:");
					result[topY][topX] = Input.getDouble();
					if ((result[topY][topX] + "").length() > widest) {
						widest = (result[topY][topX] + "").length();
					}
				}
			}
			
			//output final state of the matrix
			Output.clearScreen();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					System.out.print("[");

					for (int z = 0; z < widest - (result[y][x] + "").length(); z++)
						System.out.print(" ");
					System.out.print(result[y][x]);
					System.out.print("] ");
				}
				System.out.println(" ");
			}
			
			//confirm matrix contents with user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return result;
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
		
		String[][] result = new String[height][width];
		int widest = 1;
		
		//prompt user for the value of each cell
		do {
			for (int topY = 0; topY < height; topY++) {
				for (int topX = 0; topX < width; topX++) {

					Output.clearScreen();
					for (int y = 0; y < height; y++) {
						for (int x = 0; x < width; x++) {
							System.out.print("[");
							if ((x == topX) && (y == topY)) {
								for (int z = 0; z < widest; z++)
									System.out.print("#");
							} else if (result[y][x] == null) {
								for (int z = 0; z < widest; z++)
									System.out.print(" ");
							} else {
								for (int z = 0; z < widest - result[y][x].length(); z++)
									System.out.print(" ");
								System.out.print(result[y][x]);
							}

							System.out.print("] ");
						}
						System.out.println(" ");
					}

					System.out.println("Enter the value of this cell:");
					result[topY][topX] = Input.getString();
					if (result[topY][topX].length() > widest) {
						widest = result[topY][topX].length();
					}
				}
			}
			
			//output final state of the matrix
			Output.clearScreen();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					System.out.print("[");

					for (int z = 0; z < widest - result[y][x].length(); z++)
						System.out.print(" ");
					System.out.print(result[y][x]);
					System.out.print("] ");
				}
				System.out.println(" ");
			}
			
			//confirm matrix contents with the user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return result;
	}
}
