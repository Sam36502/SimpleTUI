package ch.pearcenet.tui.output;

import ch.pearcenet.tui.table.Column;
import ch.pearcenet.tui.table.Table;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * File Output Class
 * Makes saving data to Files easier
 *
 * @author Samuel Pearce <sam @ aepearce>
 * @version 2.2
 */
class FileOutput {

    /*
     * Basic Data saving methods
     */

    /**
     * Saves a string of text to a file
     * @param filename Filename to save to
     * @param content File contents to save
     * @throws IOException Thrown if the content is unable to be saved to the file
     */
    public static void saveContent(String filename, String content) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            PrintWriter out = new PrintWriter(fos);

            out.write(content);

            out.close();
            fos.close();
        } catch (IOException e) {
            throw new IOException("Failed to save content to '" + filename + "'.");
        }
    }

    /**
     * Saves an array of bytes to a file
     * @param filename The file to save the contents to
     * @param content The bytes to save to the file
     * @throws IOException Thrown if the content is unable to be saved to the file
     */
    public static void saveContent(String filename, byte[] content) throws IOException {
        StringBuilder str = new StringBuilder();
        for (byte b: content) {
            str.append(b);
        }
        saveContent(filename, str.toString());
    }

    /**
     * Saves an array of integers in a properties file
     * @param filename The filename to save to
     * @param content The integer array to save to the file
     * @throws IOException Thrown if the content is unable to be saved to the file
     */
    public static void saveArray(String filename, int[] content) throws IOException {
        HashMap<String, String> props = new HashMap<>();
        props.put("length", "" + content.length);
        for (int i=0; i<content.length; i++) {
            props.put("" + i, "" + content[i]);
        }
        saveProperties(filename, props);
    }

    /**
     * Saves an array of integers in a properties file
     * @param filename The filename to save to
     * @param content The integer array to save to the file
     * @throws IOException Thrown if the content is unable to be saved to the file
     */
    public static void saveArray(String filename, double[] content) throws IOException {
        HashMap<String, String> props = new HashMap<>();
        props.put("length", "" + content.length);
        for (int i=0; i<content.length; i++) {
            props.put("" + i, "" + content[i]);
        }
        saveProperties(filename, props);
    }

    /**
     * Saves an array of integers in a properties file
     * @param filename The filename to save to
     * @param content The integer array to save to the file
     * @throws IOException Thrown if the content is unable to be saved to the file
     */
    public static void saveArray(String filename, String[] content) throws IOException {
        HashMap<String, String> props = new HashMap<>();
        props.put("length", "" + content.length);
        for (int i=0; i<content.length; i++) {
            props.put("" + i, "" + content[i]);
        }
        saveProperties(filename, props);
    }

    /*
     * File Type Data saving methods
     */

    /**
     * Saves a hashmap in a properties file
     * @param filename The file
     * @param content The properties to save to a file
     * @throws IOException Thrown if the content cannot be saved to the file
     */
    public static void saveProperties(String filename, HashMap<String, String> content) throws IOException {
        StringBuilder str = new StringBuilder();
        str.append("# '" + filename + "' created " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        for (Map.Entry entry: content.entrySet()) {
            str.append("\r\n" + entry.getKey() + " = " + entry.getValue());
        }

        saveContent(filename, str.toString());
    }

    /**
     * Saves a table to a CSV file following
     * RFC-4180 Standard CSV format.
     * @param filename The file to save data to
     * @param content The Table to save data from
     * @throws IOException Thrown if the content cannot be saved to the file
     */
    public static void saveCSV(String filename, Table content) throws IOException {
        StringBuilder str = new StringBuilder();

        // Add the header row to the file
        for (Column<?> col: content.getCols()) {
            String head = col.getTitle();
            head.replace("\"", "\"\"");
            if (head.contains("\r\n")) head = "\"" + head + "\"";
            str.append(head + ",");
        }
        if (str.length() > 0) str.deleteCharAt(str.length() - 1);
        str.append("\r\n");

        // Add data rows
        boolean allRows = false;
        int index = 0;
        while (!allRows) {
            allRows = true;

            // Add all columns
            for (Column<?> col: content.getCols()) {
                Object obj = col.get(index);
                if (obj != null) allRows = false;
                String colStr = obj.toString();

                colStr.replace("\"", "\"\"");
                if (colStr.contains("\r\n")) colStr = "\"" + colStr + "\"";
                str.append(colStr + ",");
            }
            if (str.length() > 0) str.deleteCharAt(str.length() - 1);
            str.append("\r\n");
            index++;
        }

        // Save data to file
        saveContent(filename, str.toString());

    }

}
