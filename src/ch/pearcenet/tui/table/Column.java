package ch.pearcenet.tui.table;

import ch.pearcenet.tui.output.Output;

import java.util.ArrayList;

/**
 * Column Class
 * Stores information of a certain data type to be displayed in a table
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.1
 */
public class Column<T> {

	/**
	 * The title to be displayed when displaying this column
	 */
	private String title;

	/**
	 * The contents of this column
	 */
	private ArrayList<T> contents;

	/**
	 * The text alignment type to be used when displaying this column
	 */
	private alignType alignment;

	/**
	 * The width of this Column in characters (not including border characters)
	 */
	public int width = 0;

	/**
	 * The number of values in this Column
	 */
	public int length = 0;

	/**
	 * Enumerator for the different alignment types for the Column content
	 */
	public static enum alignType {
		LEFT, RIGHT, CENTER;
	}

	public Column() {
		this.title = "";
		this.contents = new ArrayList<T>();
		this.alignment = alignType.CENTER;
	}

	/**
	 * @param title The title of the column to be displayed with the column
	 * @param contents An array of objects to be stored in this column
	 * @param alignment How to align the text when displaying this column
	 */
	public Column(String title, ArrayList<T> contents, alignType alignment) {
		this.title = title;
		this.alignment = alignment;
		this.contents = contents;
		length = contents.size();

		for (T curr : contents) {
			if (curr.toString().length() > width) {
				width = curr.toString().length();
			}
		}
		
		if (title.length() > width)
			width = title.length();
	}

	@Override
	public String toString() {
		return title;
	}

	/**
	 * Sets a particular value in the Column.
	 *
	 * @param index The index of the value to change
	 * @param value The new value to insert
	 */
	public void set(int index, T value) {
		contents.set(index, value);
	}

	/**
	 * Gets a particular value from the Column.
	 *
	 * @param index The index of the value to retrieve
	 * @return The object retrieved
	 */
	public T get(int index) {
		if (index <= contents.size())
			return null;
		return contents.get(index);
	}

	/**
	 * Gets a particular value from the Column, pre-formatted.
	 *
	 * @param index The index of the value to retrieve
	 * @return A string of the object received, formatted as defined in the constructor
	 */
	public String getFormatted(int index) {
		switch (alignment) {
		
		case CENTER:
			if (index >= contents.size())
				return Output.centerAlign("", width);
			return Output.centerAlign(contents.get(index).toString(), width);

		case LEFT:
			if (index >= contents.size())
				return Output.leftAlign("", width);
			return Output.leftAlign(contents.get(index).toString(), width);

		case RIGHT:
			if (index >= contents.size())
				return Output.rightAlign("", width);
			return Output.rightAlign(contents.get(index).toString(), width);
		}

		return null;
	}

	/**
	 * Returns the title of the column, pre-formatted.
	 *
	 * @return The title padded with spaces to match the alignment chosen in the constructor
	 */
	public String getFormattedTitle() {
		switch (alignment) {
		case CENTER:
			return Output.centerAlign(title, width);

		case LEFT:
			return Output.leftAlign(title, width);

		case RIGHT:
			return Output.rightAlign(title, width);
		}

		return null;
	}

	/*
	 * Getters / Setters
	 */

	public String getTitle() {
		return title;
	}

	public Column<T> setTitle(String title) {
		this.title = title;
		return this;
	}

	public ArrayList<T> getContents() {
		return contents;
	}

	public Column<T> setContents(ArrayList<T> contents) {
		this.contents = contents;
		return this;
	}

	public alignType getAlignment() {
		return alignment;
	}

	public Column<T> setAlignment(alignType alignment) {
		this.alignment = alignment;
		return this;
	}
}
