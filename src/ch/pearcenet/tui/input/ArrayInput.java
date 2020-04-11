package ch.pearcenet.tui.input;

import ch.pearcenet.tui.output.Output;

import java.util.ArrayList;

/**
 * Array Input Class
 * Makes getting an array of values from the user more convenient
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.2
 */
class ArrayInput {

	/**
	 * Prompts the user for an integer array with a predefined
	 * length. The user is asked to confirm their choice and
	 * may re-enter all the values if they don't confirm their choice.
	 *
	 * @param len Length of the array to prompt the user for.
	 * @return The integer array entered by the user.
	 */
	public static ArrayList<Integer> getIntArray(int len) {
		ArrayList<Integer> res = new ArrayList<>(len);

		do {
			
			//Prompt the user for each cell in the array
			for (int topI = 0; topI < len; topI++) {
				Output.clearScreen();
				for (int i = 0; i < len; i++) {
					System.out.print("[");
					if (i == topI) {
						System.out.print("#");
					} else if (res.get(i) != 0) {
						System.out.print(res.get(i));
					} else {
						System.out.print(" ");
					}
					System.out.print("] ");
				}

				System.out.println("Enter the value of the selected cell.");
				res.add(Input.getInt());
			}
			
			//Output the final state of the array
			for (int i = 0; i < len; i++) {
				System.out.print("[");
				System.out.print(res.get(i));
				System.out.print("] ");
			}
			
			//Confirm values with user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		
		return res;
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
		ArrayList<Integer> res = new ArrayList<>();

		boolean isDone = false;
		while (!isDone) {
			System.out.println("Enter the next value:");
			res.add(Input.getInt());

			System.out.println(Output.arrayOut(res.toArray()));
			System.out.println("Is this all the data you wish to enter?");
			isDone = Input.getBool();
		}

		return res;
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
		ArrayList<Double> res = new ArrayList<>(len);
		
		//prompt the user for the value of each cell
		do {
			for (int topI = 0; topI < len; topI++) {
				Output.clearScreen();
				for (int i = 0; i < len; i++) {
					System.out.print("[");
					if (i == topI) {
						System.out.print("#");
					} else if (res.get(i) != 0.0D) {
						System.out.print(res.get(i));
					} else {
						System.out.print(" ");
					}
					System.out.print("] ");
				}

				System.out.println("Enter the value of the selected cell.");
				res.add(Input.getDouble());
			}

			//output final state of the array
			for (int i = 0; i < len; i++) {
				System.out.print("[");
				System.out.print(res.get(i));
				System.out.print("] ");
			}
			
			//confirm values with user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return res;
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
		ArrayList<Double> res = new ArrayList<>();

		boolean isDone = false;
		while (!isDone) {
			System.out.println("Enter the next value:");
			res.add(Input.getDouble());

			System.out.println(Output.arrayOut(res.toArray()));
			System.out.println("Is this all the data you wish to enter?");
			isDone = Input.getBool();
		}

		return res;
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
		ArrayList<String> res = new ArrayList<>(len);
		
		//prompt the user for the value of each cell
		do {
			for (int topI = 0; topI < len; topI++) {
				Output.clearScreen();
				for (int i = 0; i < len; i++) {
					System.out.print("[");
					if (i == topI) {
						System.out.print("#");
					} else if (res.get(i) != "") {
						System.out.print(res.get(i));
					} else {
						System.out.print(" ");
					}
					System.out.print("] ");
				}
				
				System.out.println("Enter the value of the selected cell.");
				res.add(Input.getString());
			}
			
			//output the final state of the array
			for (int i = 0; i < len; i++) {
				System.out.print("[");
				System.out.print(res.get(i));
				System.out.print("] ");
			}
			
			//confirm final values with the user
			System.out.println("Is this correct?");
		} while (!Input.getBool());
		return res;
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
		ArrayList<String> res = new ArrayList<>();

		boolean isDone = false;
		while (!isDone) {
			System.out.println("Enter the next value:");
			res.add(Input.getString());

			System.out.println(Output.arrayOut(res.toArray()));
			System.out.println("Is this all the data you wish to enter?");
			isDone = Input.getBool();
		}

		return res;
	}
}
