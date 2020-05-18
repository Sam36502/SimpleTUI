package ch.pearcenet.tui.output;

import ch.pearcenet.tui.exceptions.BufferSizeException;

/**
 * Screen Class
 * Allows the user to display text and shapes on a simple ASCII screen.
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.1
 */
public class Screen {

	/**
	 * The width of the screen in characters
	 */
	private int width;

	/**
	 * The width of the screen in characters
	 */
	private int height;

	/**
	 * The character buffer stores the image information before it is displayed
	 */
	private char[][] buffer;

	/**
	 * The maximum width of a buffer; Any size above this becomes noticeably slow to display
	 */
	private static final int MAX_WIDTH = 255;

	/**
	 * The maximum width of a buffer; Any size above this becomes noticeably slow to display
	 */
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

	/**
	 * Assigns a region of the buffer to a matrix
	 * of characters starting at the top left
	 * of the buffer.
	 *
	 * @param buf The matrix to assign to the buffer.
	 */
	public void setBuffer(char[][] buf) {
		for (int y = 0; y < buf.length; y++) {
			for (int x = 0; x < buf[0].length; x++) {
				buffer[y][x] = buf[y][x];
			}
		}
	}

	/**
	 * Sets the entire buffer to ' ' characters.
	 */
	public void clearBuffer() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				buffer[y][x] = 32;
			}
		}
	}

	/**
	 * Sets a single character in the buffer.
	 *
	 * @param x The x coordinate of the character to set
	 * @param y The y coordinate of the character to set
	 * @param ch The character to set pixel of the buffer to
	 */
	public void setPixel(int x, int y, char ch) {
		buffer[y][x] = ch;
	}

	/**
	 * Writes a string to the buffer starting from
	 * a given position. If the string goes over
	 * the edge, it is simply cut off.
	 *
	 * @param x The x coordinate of the first character of the string to write
	 * @param y The y coordinate of the first character of the string to write
	 * @param str The string to be written into the buffer
	 */
	public void writeString(int x, int y, String str) {
		if (str.length() + x > width) {
			str = str.substring(0, width - x);
		}

		for (int i = 0; i < str.length(); i++) {
			setPixel(x + i, y, str.charAt(i));
		}
	}

	/**
	 * Writes a string to the buffer vertically
	 * starting from a given position. If the
	 * string goes over the edge, it is simply
	 * cut off.
	 *
	 * @param x The x coordinate of the first character of the string to write
	 * @param y The y coordinate of the first character of the string to write
	 * @param str The string to be written into the buffer
	 */
	public void writeVerticalString(int x, int y, String str) {
		if (str.length() + y > height) {
			str = str.substring(0, height - y);
		}

		for (int i = 0; i < str.length(); i++) {
			setPixel(x, y + i, str.charAt(i));
		}
	}

	/**
	 * Displays the current buffer. (By default with a border)
	 */
	public void printScreen() {
		printScreen(true);
	}

	/**
	 * Displays the current buffer.
	 *
	 * @param hasBorder Whether or not to add a border around the display
	 */
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
