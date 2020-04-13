package ch.pearcenet.tui.output;

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
     * @throws IOException Thrown if the content cannot be saved
     */
    public static void saveProperties(String filename, HashMap<String, String> content) throws IOException {
        StringBuilder str = new StringBuilder();
        str.append("# '" + filename + "' created " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        for (Map.Entry entry: content.entrySet()) {
            str.append(System.lineSeparator() + entry.getKey() + " = " + entry.getValue());
        }

        saveContent(filename, str.toString());
    }

}
