package ch.pearcenet.tui;

public class Output {
	
	//Outputs an Array in the form of a sentence i.e. "1, 2, 3 and 4"
	public static void sentenceArray(Object[] arr) {
		System.out.print(arr[0]);
		for (int i=1; i<arr.length-1; i++) {
			System.out.print(", "+arr[i]);
		}
		System.out.print(" and "+arr[arr.length]);
	}
	//For non-object integers
	public static void sentenceArray(Double[] arr) {
		System.out.print(arr[0]);
		for (int i=1; i<arr.length-1; i++) {
			System.out.print(", "+arr[i]);
		}
		System.out.print(" and "+arr[arr.length]);
	}
	//For non-object Doubles
	public static void sentenceArray(int[] arr) {
		System.out.print(arr[0]);
		for (int i=1; i<arr.length-1; i++) {
			System.out.print(", "+arr[i]);
		}
		System.out.print(" and "+arr[arr.length-1]);
	}

}
