package ch.pearcenet.tui.output;

import ch.pearcenet.tui.exceptions.BufferSizeException;

public class Screen {
	
	private int width;
	private int height;
	private char[][] buffer;
	private static final int MAX_WIDTH = 255;
	private static final int MAX_HEIGHT = 255;

	public Screen(int width, int height) throws BufferSizeException {
		this.width = width;
		this.height = height;
		
		if ((width > 0) && (width < MAX_WIDTH) && (height > 0) && (height < MAX_HEIGHT)) {
			buffer = new char[height][width];
		} else {
			throw new BufferSizeException();
		}
	}
	
	//Assigns a region of the buffer to a set of values, starting from top left
	public void setBuffer(char[][] buf) {
		for (int y = 0; y < buf.length; y++) {
			for (int x = 0; x < buf[0].length; x++) {
				buffer[y][x] = buf[y][x];
			}
		}
	}
	
	//Sets the whole buffer to empty (whitespaces)
	public void clearBuffer() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				buffer[y][x] = 32;
			}
		}
	}
	
	//Sets a single pixel on the screen
	public void setPixel(int x, int y, char ch) {
		buffer[y][x] = ch;
	}
	
	//Writes a string of text from a position from left to right
	//as long as it has room
	public void writeString(int x, int y, String str) {
		if (str.length() + x > width) {
			str = str.substring(0, width - x);
		}

		for (int i = 0; i < str.length(); i++) {
			setPixel(x + i, y, str.charAt(i));
		}
	}
	
	//Writes a string of text from a position from top to bottom
	//as long as it has room
	public void writeVerticalString(int x, int y, String str) {
		if (str.length() + y > height) {
			str = str.substring(0, height - y);
		}

		for (int i = 0; i < str.length(); i++) {
			setPixel(x, y + i, str.charAt(i));
		}
	}
	
	//Displays the screen, by default with a border
	public void printScreen() {
		printScreen(true);
	}

	//Displays the screen with the option of showing the border or not
	public void printScreen(boolean hasBorder) {
		if (hasBorder) {
			System.out.print("+");
			for (int i = 0; i < width; i++)
				System.out.print("-");
			System.out.println("+");
		}

		for (int y = 0; y < height; y++) {
			if (hasBorder)
				System.out.print("|");
			for (int x = 0; x < width; x++) {
				System.out.print(buffer[y][x]);
			}
			if (hasBorder) {
				System.out.println("|");
			} else {
				System.out.println(" ");
			}
		}

		if (hasBorder) {
			System.out.print("+");
			for (int i = 0; i < width; i++)
				System.out.print("-");
			System.out.println("+");
		}
	}
}
