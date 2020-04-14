package ch.pearcenet.tui.input;

import ch.pearcenet.tui.exceptions.ArraySyntaxException;
import ch.pearcenet.tui.exceptions.CsvSyntaxException;
import ch.pearcenet.tui.table.Column;
import ch.pearcenet.tui.table.Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * File Input Class
 * Provides methods to load data from files
 *
 * @author Samuel Pearce <sam @ aepearce.com>
 * @version 2.2
 */
class FileInput {

    /*
     * Basic File input methods
     */

    /**
     * Loads a String from a file and returns it.
     * Uses CRLF as line separator.
     * @param filename The file to load from
     * @return A String with the file contents
     * @throws IOException Thrown if the file couldn't be loaded
     */
    public static String loadString(String filename) throws IOException {
        StringBuilder str = new StringBuilder();

        FileInputStream fis = new FileInputStream(filename);
        Scanner in = new Scanner(fis);

        if (in.hasNextLine()) str.append(in.nextLine());
        while (in.hasNextLine()) str.append("\r\n" + in.nextLine());

        in.close();
        fis.close();

        return str.toString();
    }

    /**
     * Loads an array of integers from a file.
     * @param filename The file to load the data from
     * @return The array of integers loaded from the file
     * @throws IOException Thrown if the data couldn't be loaded
     */
    public static int[] loadIntArray(String filename) throws Exception {
        HashMap<String, String> map = loadProperties(filename);
        if (!map.containsKey("length")) throw new ArraySyntaxException("File doesn't contain 'length' property.");
        int len = Integer.parseInt(map.get("length"));
        int[] arr = new int[len];

        for (int i=0; i<len; i++) arr[i] = Integer.parseInt(map.get("" + i));

        return arr;
    }

    /**
     * Loads an array of doubles from a file.
     * @param filename The file to load the data from
     * @return The array of doubles loaded from the file
     * @throws IOException Thrown if the data couldn't be loaded
     */
    public static double[] loadDoubleArray(String filename) throws Exception {
        HashMap<String, String> map = loadProperties(filename);
        int len = Integer.parseInt(map.get("length"));
        double[] arr = new double[len];

        for (int i=0; i<len; i++) arr[i] = Double.parseDouble(map.get("" + i));

        return arr;
    }

    /**
     * Loads an array of Strings from a file.
     * @param filename The file to load the data from
     * @return The array of Strings loaded from the file
     * @throws IOException Thrown if the data couldn't be loaded
     */
    public static String[] loadStringArray(String filename) throws Exception {
        HashMap<String, String> map = loadProperties(filename);
        int len = Integer.parseInt(map.get("length"));
        String[] arr = new String[len];

        for (int i=0; i<len; i++) arr[i] = map.get("" + i);

        return arr;
    }

    /*
     * File Type Data loading methods
     */

    /**
     * Loads a HashMap from a properties file.
     * Line comments are denoted by a '#'.
     * Keys and values are separated by an '='.
     * There may be any number of spaces between the
     * equals sign and either key or value.
     * @param filename The file to load the data from
     * @return A HashMap of the keys and values
     * @throws IOException Thrown if the data couldn't be loaded
     */
    public static HashMap<String, String> loadProperties(String filename) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        String content = loadString(filename);

        for (String line: content.split("\r\n")) {
            int comIndex = line.indexOf("#");
            if (comIndex != -1) {
                if (comIndex == 0) continue;
                line = line.substring(0, comIndex - 1);
            }

            int equIndex = line.indexOf("=");
            if (equIndex == -1) continue;

            String key = line.substring(0, equIndex).trim();
            String value = line.substring(equIndex + 1).trim();
            map.put(key, value);
        }

        return map;
    }

    /**
     * Loads a Table from a CSV file.
     * The CSV follows RFC-4180 format.
     * @param filename The file to load the data from
     * @return The Table of loaded data
     * @throws IOException Thrown if the data couldn't be loaded
     */
    public static Table loadCSV(String filename) throws IOException {
        String content = loadString(filename);

        ArrayList<Column> colList = new ArrayList<>();

        // Create Columns
        String header = content;
        int headIndex = content.indexOf("\r\n");
        if (headIndex != -1) {
            header = header.substring(0, headIndex - 1);
            content = content.substring(headIndex);
        }
        for (String col: header.split(","))
            colList.add(new Column<String>().setTitle(col));

        // Add data
        int index = 0;
        for (String line: content.split("\r\n")) {
            String[] cells = line.split(",");
            if (cells.length < colList.size())
                throw new CsvSyntaxException("Syntax error in CSV format for '" + filename + "'. Format should match RFC-4180.");

            for (int i=0; i<colList.size(); i++) {
                String cell = cells[i];
                cell.replace("\"\"", "<ESCQUOTE>");
                cell.replace("\"", "");
                cell.replace("<ESCQUOUTE>", "\"");
                colList.get(i).set(index, cell);
            }
        }

        Table tbl = new Table(colList);

        return tbl;
    }

}
