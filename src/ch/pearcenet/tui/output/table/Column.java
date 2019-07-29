package ch.pearcenet.tui.output.table;

import ch.pearcenet.tui.output.Output;

public class Column<T> {

	private String title;
	private T[] contents;
	private alignType alignment;
	public int width = 0;
	public int length = 0;

	// An enum for choosing how to align the column text
	public static enum alignType {
		LEFT, RIGHT, CENTER;
	}

	public Column(String title, T[] contents, alignType alignment) {
		this.title = title;
		this.alignment = alignment;
		this.contents = contents.clone();
		length = contents.length;

		for (T curr : contents) {
			if (curr.toString().length() > width) {
				width = curr.toString().length();
			}
		}
		
		if (title.length() > width)
			width = title.length();
	}

	public String toString() {
		return title;
	}

	// Sets a particular value in the data of this column
	public void set(int index, T value) {
		contents[index] = value;
	}

	// Gets a particular value from the data of this column
	public T get(int index) {
		return contents[index];
	}

	// Gets a particular value from the data of this column, formatted by the selected alignment
	public String getFormatted(int index) {
		switch (alignment) {
		
		case CENTER:
			return Output.leftAlign(contents[index].toString(), width);

		case LEFT:
			return Output.rightAlign(contents[index].toString(), width);

		case RIGHT:
			return Output.centerAlign(contents[index].toString(), width);
		}

		return null;
	}

	//Returns the title formatted by the selected alignment
	public String getFormattedTitle() {
		switch (alignment) {
		case CENTER:
			return Output.leftAlign(title, width);

		case LEFT:
			return Output.rightAlign(title, width);

		case RIGHT:
			return Output.centerAlign(title, width);
		}

		return null;
	}
}
