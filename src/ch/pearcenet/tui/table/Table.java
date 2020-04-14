package ch.pearcenet.tui.table;

import java.util.ArrayList;

/**
 * Table Class
 * Formats and displays a group of Columns together
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.1
 */
public class Table {

	/**
	 * The Columns to display in this Table
	 */
	private ArrayList<Column> columns;

	/**
	 * The length of the longest Column, to format the rest by
	 */
	private int longest = 0;

	/**
	 * @param columns The Columns to use in this Table
	 */
	public Table(ArrayList<Column> columns) {
		this.columns = columns;

		for (Column<?> curr : columns) {
			if (curr.length > longest) {
				longest = curr.length;
			}
		}
	}

	/**
	 * Displays the Table with all the Columns
	 * lined up with one another and formatted
	 * as chosen for each column. The whole
	 * table is also surrounded by an ASCII-art border.
	 */
	public void printTable() {
		
		//Top Border
		for (Column<?> c: columns) {
			System.out.print("+");
			for (int i=0; i<c.width; i++) {
				System.out.print("-");
			}
		}
		System.out.println("+");
		
		//Titles
		for (Column<?> c: columns) {
			System.out.print("|");
			System.out.print(c.getFormattedTitle());
		}
		System.out.println("|");
		
		//Header Border
		for (Column<?> c: columns) {
			System.out.print("+");
			for (int i=0; i<c.width; i++) {
				System.out.print("-");
			}
		}
		System.out.println("+");
		
		//Table contents
		for (int row=0; row<longest; row++) {
			for (Column<?> c: columns) {
				System.out.print("|");
				System.out.print(c.getFormatted(row));
			}
			System.out.println("|");
		}
		
		//Bottom Border
		for (Column<?> c: columns) {
			System.out.print("+");
			for (int i=0; i<c.width; i++) {
				System.out.print("-");
			}
		}
		System.out.println("+");
		
	}

	/**
	 * Gets the list of columns in this table
	 * @return Column array
	 */
	public ArrayList<Column> getCols() {
		return this.columns;
	}
}
