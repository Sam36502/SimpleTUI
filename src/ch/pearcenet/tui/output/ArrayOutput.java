package ch.pearcenet.tui.output;

public class ArrayOutput {
	
	//Prints out an array of objects like a sentence i.e "obj1, obj2, obj3 and obj4"
	public static String sentenceArray(Object[] arr) {
		
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
	
	//Prints out an array of doubles like a sentence i.e "3.141, 1.41, 1.61 and 2.7182"
	public static String sentenceArray(double[] arr) {
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

	//Prints out an array of ints like a sentence i.e "1, 2, 3 and 4"
	public static String sentenceArray(int[] arr) {
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

	//Prints out an array of Objects in boxes i.e. "[obj1] [obj2] [obj3] [obj4]"
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
	
	//Prints out an array of doubles in boxes i.e. "[3.141] [1.41] [1.61] [2.7182]"
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
	
	//Prints out an array of ints in boxes i.e. "[1] [2] [3] [4]"
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
	
	//Prints out an array of strings in boxes i.e. "[str1] [str2] [str3] [str4]"
	public static String arrayOut(String[] arr) {
		String out = "";
		String[] arrayOfString = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			String curr = arrayOfString[i];
			out = out + "[" + curr + "] ";
		}
		return out;
	}
	
	//Prints out an object array with custom opener, closer and delimiter
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
	
	//Prints out an double array with custom opener, closer and delimiter
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
	
	//Prints out an int array with custom opener, closer and delimiter
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
	
	//Prints out an String array with custom opener, closer and delimiter
	public static String customArray(String[] arr, String open, String close, String delimiter) {
		String out = "";
		String[] arrayOfString = arr;
		int j = arr.length;
		for (int i = 0; i < j; i++) {
			String curr = arrayOfString[i];
			out = out + open + curr + close + delimiter;
		}
		return out;
	}
}
