package ch.pearcenet.tui.input;

import ch.pearcenet.tui.output.Output;

public class ArrayInput {

	//Prompts the user for an int array of a fixed length
	public static int[] getIntArray(int len) {

		int[] res = new int[len];

		do {
			
			//Prompt the user for each cell in the array
			for (int topI = 0; topI < len; topI++) {
				Output.clearScreen();
				for (int i = 0; i < len; i++) {
					System.out.print("[");
					if (i == topI) {
						System.out.print("#");
					} else if (res[i] != 0) {
						System.out.print(res[i]);
					} else {
						System.out.print(" ");
					}
					System.out.print("] ");
				}

				System.out.println("Enter the value of the selected cell.");
				res[topI] = Input.getInt();
			}
			
			//Output the final state of the array
			for (int i = 0; i < len; i++) {
				System.out.print("[");
				System.out.print(res[i]);
				System.out.print("] ");
			}
			
			//Confirm values with user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		
		return res;
	}
	
	//Prompts the user for an int array of any size
	public static int[] getIntArray() {
		System.out.println("How many values do you want to enter?");
		return getIntArray(Input.getInt());
	}
	
	//Prompts the user for a double array of a fixed size
	public static double[] getDoubleArray(int len) {
		double[] res = new double[len];
		
		//prompt the user for the value of each cell
		do {
			for (int topI = 0; topI < len; topI++) {
				Output.clearScreen();
				for (int i = 0; i < len; i++) {
					System.out.print("[");
					if (i == topI) {
						System.out.print("#");
					} else if (res[i] != 0.0D) {
						System.out.print(res[i]);
					} else {
						System.out.print(" ");
					}
					System.out.print("] ");
				}

				System.out.println("Enter the value of the selected cell.");
				res[topI] = Input.getDouble();
			}

			//output final state of the array
			for (int i = 0; i < len; i++) {
				System.out.print("[");
				System.out.print(res[i]);
				System.out.print("] ");
			}
			
			//confirm values with user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return res;
	}
	
	//Prompts the user for a double array of any size
	public static double[] getDoubleArray() {
		System.out.println("How many values do you want to enter?");
		return getDoubleArray(Input.getInt());
	}
	
	//prompts the user for a string array of a fixed size
	public static String[] getStringArray(int len) {
		String[] res = new String[len];
		
		//prompt the user for the value of each cell
		do {
			for (int topI = 0; topI < len; topI++) {
				Output.clearScreen();
				for (int i = 0; i < len; i++) {
					System.out.print("[");
					if (i == topI) {
						System.out.print("#");
					} else if (res[i] != "") {
						System.out.print(res[i]);
					} else {
						System.out.print(" ");
					}
					System.out.print("] ");
				}
				
				System.out.println("Enter the value of the selected cell.");
				res[topI] = Input.getString();
			}
			
			//output the final state of the array
			for (int i = 0; i < len; i++) {
				System.out.print("[");
				System.out.print(res[i]);
				System.out.print("] ");
			}
			
			//confirm final values with the user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return res;
	}
	
	//Prompts the user for a string array of any length
	public static String[] getStringArray() {
		System.out.println("How many values do you want to enter?");
		return getStringArray(Input.getInt());
	}
}
