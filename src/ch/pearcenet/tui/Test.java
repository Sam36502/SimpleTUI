package ch.pearcenet.tui;

import ch.pearcenet.tui.input.Input;
import ch.pearcenet.tui.output.Output;
import ch.pearcenet.tui.table.Column;
import ch.pearcenet.tui.table.Table;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws Exception {

        String testfile = "testfile.txt";
        ArrayList<String> a = new ArrayList<>();
        a.add("Filthy");
        a.add("Ethan");
        a.add("Hila");

        ArrayList<String> b = new ArrayList<>();
        b.add("Frank");
        b.add("Klein");

        ArrayList<Integer> c = new ArrayList<>();
        c.add(420);
        c.add(69);
        c.add(42);

        ArrayList<Column> cols = new ArrayList<>();
        cols.add(new Column<String>("Firstname", a, Column.alignType.RIGHT));
        cols.add(new Column<String>("Lastname", b, Column.alignType.LEFT));
        cols.add(new Column<Integer>(" - IDK - ", c, Column.alignType.CENTER));

        Table t = new Table(cols);
        System.out.println("Test Data:");
        t.printTable();

        // File Test
        Output.saveTableToFile(testfile, t);
        System.out.println("Content: '" + Input.loadStringFromFile(testfile) + "'.");
        Table res = Input.loadCSVFile(testfile);

        System.out.println("Loaded Data:");
        res.printTable();

        new File(testfile).delete();

    }

}
