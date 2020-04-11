package ch.pearcenet.tui.output;

/**
 * Array Output Class
 * Provides many static methods to make displaying arrays more convenient
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.2
 */
class ArrayOutput {

	/*
	 * Non-Oxford-Comma Sentence Array Formatters
	 */

	/**
	 * Formats an array of Objects like a natural sentence.
	 * e.g.: {Obj1, Obj2, Obj3} -> "Obj1, Obj2 and Obj3"
	 *
	 * @param arr The array of Objects to format
	 * @return The formatted string
	 */
	public static String sentenceFormat(Object[] arr) {
		
		// Remove all null values from the array
		int len = 0;
		for (Object o: arr) if (o != null) len++;
		
		Object[] newarr = new Object[len];
		int ind=0;
		for (Object obj: arr) {
			if (obj != null) {
				newarr[ind++] = obj;
			}
		}
		arr = newarr;
		
		String out = "";
		if (arr.length < 1) {
			out = "";
		} else if (arr.length == 1) {
			out = arr[0].toString();
		} else if (arr.length == 2) {
			out = arr[0].toString() + " and " + arr[1].toString();
		} else {
			out = arr[0].toString();
			for (int i = 1; i < arr.length - 1; i++) {
				out = out + ", " + arr[i].toString();
			}
			out = out + " and " + arr[(arr.length - 1)].toString();
		}
		return out;
	}

	/**
	 * Formats an array of doubles like a natural sentence.
	 * e.g.: {1.1, 2.2, 3.3} -> "1.1, 2.2 and 3.3"
	 *
	 * @param arr The array of doubles to format
	 * @return The formatted string
	 */
	public static String sentenceFormat(double[] arr) {
		String out = null;
		if (arr.length < 1) {
			out = "";
		} else if (arr.length == 1) {
			out = "" + arr[0];
		} else if (arr.length == 2) {
			out = arr[0] + " and " + arr[1];
		} else {
			out = "" + arr[0];
			for (int i = 1; i < arr.length - 1; i++) {
				out = out + ", " + arr[i];
			}
			out = out + " and " + arr[(arr.length - 1)];
		}
		return out;
	}

	/**
	 * Formats an array of integers like a natural sentence.
	 * e.g.: {1, 2, 3, 4} -> "1, 2, 3 and 4"
	 *
	 * @param arr The array of integers to format
	 * @return The formatted string
	 */
	public static String sentenceFormat(int[] arr) {
		String out = null;
		if (arr.length < 1) {
			out = "";
		} else if (arr.length == 1) {
			out = "" + arr[0];
		} else if (arr.length == 2) {
			out = arr[0] + " and " + arr[1];
		} else {
			out = "" + arr[0];
			for (int i = 1; i < arr.length - 1; i++) {
				out = out + ", " + arr[i];
			}
			out = out + " and " + arr[(arr.length - 1)];
		}
		return out;
	}

	/*
	 * Oxford-Comma Sentence Array Formatters
	 */

	/**
	 * Formats an array of Objects like a natural sentence.
	 * This version includes the oxford comma
	 * e.g.: {Obj1, Obj2, Obj3} -> "Obj1, Obj2, and Obj3"
	 *
	 * @param arr The array of Objects to format
	 * @return The formatted string
	 */
	public static String oxfordSentenceFormat(Object[] arr) {

		// Remove all null values from the array
		int len = 0;
		for (Object o: arr) if (o != null) len++;

		Object[] newarr = new Object[len];
		int ind=0;
		for (Object obj: arr) {
			if (obj != null) {
				newarr[ind++] = obj;
			}
		}
		arr = newarr;

		String out = "";
		if (arr.length < 1) {
			out = "";
		} else if (arr.length == 1) {
			out = arr[0].toString();
		} else if (arr.length == 2) {
			out = arr[0].toString() + ", and " + arr[1].toString();
		} else {
			out = arr[0].toString();
			for (int i = 1; i < arr.length - 1; i++) {
				out = out + ", " + arr[i].toString();
			}
			out = out + ", and " + arr[(arr.length - 1)].toString();
		}
		return out;
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
		String out = null;
		if (arr.length < 1) {
			out = "";
		} else if (arr.length == 1) {
			out = "" + arr[0];
		} else if (arr.length == 2) {
			out = arr[0] + ", and " + arr[1];
		} else {
			out = "" + arr[0];
			for (int i = 1; i < arr.length - 1; i++) {
				out = out + ", " + arr[i];
			}
			out = out + ", and " + arr[(arr.length - 1)];
		}
		return out;
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
		String out = null;
		if (arr.length < 1) {
			out = "";
		} else if (arr.length == 1) {
			out = "" + arr[0];
		} else if (arr.length == 2) {
			out = arr[0] + ", and " + arr[1];
		} else {
			out = "" + arr[0];
			for (int i = 1; i < arr.length - 1; i++) {
				out = out + ", " + arr[i];
			}
			out = out + ", and " + arr[(arr.length - 1)];
		}
		return out;
	}

	/*
	 * Regular Array Output Formatters
	 */

	/**
	 * Formats an array of Objects in square brackets.
	 * e.g.: {Obj1, Obj2, Obj3} -> "[Obj1] [Obj2] [Obj3]"
	 *
	 * @param arr The array of Objects to format
	 * @return The formatted string
	 */
	public static String arrayOut(Object[] arr) {
		String out = "";
		Object[] arrayOfObject = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			Object curr = arrayOfObject[i];
			out = out + "[" + curr.toString() + "] ";
		}
		return out;
	}

	/**
	 * Formats an array of doubles in square brackets.
	 * e.g.: {1.1, 2.2, 3.3} -> "[1.1] [2.2] [3.3]"
	 *
	 * @param arr The array of doubles to format
	 * @return The formatted string
	 */
	public static String arrayOut(double[] arr) {
		String out = "";
		double[] arrayOfDouble = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			double curr = arrayOfDouble[i];
			out = out + "[" + curr + "] ";
		}
		return out;
	}

	/**
	 * Formats an array of integers in square brackets.
	 * e.g.: {1, 2, 3, 4} -> "[1] [2] [3] [4]"
	 *
	 * @param arr The array of integers to format
	 * @return The formatted string
	 */
	public static String arrayOut(int[] arr) {
		String out = "";
		int[] arrayOfInt = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			int curr = arrayOfInt[i];
			out = out + "[" + curr + "] ";
		}
		return out;
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
		String out = "";
		Object[] arrayOfObject = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			Object curr = arrayOfObject[i];
			out = out + open + curr.toString() + close + delimiter;
		}
		return out;
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
		String out = "";
		double[] arrayOfDouble = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			double curr = arrayOfDouble[i];
			out = out + open + curr + close + delimiter;
		}
		return out;
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
		String out = "";
		int[] arrayOfInt = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			int curr = arrayOfInt[i];
			out = out + open + curr + close + delimiter;
		}
		return out;
	}

}
