package ch.pearcenet.tui.output.table;

public class Table {
	
	private Column<?>[] columns;
	private int longest = 0;

	public Table(Column<?>[] columns) {
		this.columns = ((Column[]) columns.clone());

		for (Column<?> curr : columns) {
			if (curr.length > longest) {
				longest = curr.length;
			}
		}
	}

	//Prints out the table with an ascii char border
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
}
