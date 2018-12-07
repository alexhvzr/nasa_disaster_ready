package com.example.android.disaster_ready;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/* This class provides general file handling capability to other
 * members of the DisasterReady application, which relies on
 * reading/writing of plain text files for persistent storage
 * of emergency items to be interacted with, added, and ultimately
 * stored locally for continuity between user sessions.
 */
public final class FileHandler {
    private static final String ITEM_FILE = "ItemFile.txt"; //file to store user-entered item data in plain text format

    //prevent this class from being instantiated
    private FileHandler(){};

    /*
     * This method reads the contents of a locally-stored item file if it exists,
     * and adds the corresponding items to the ArrayList list for utilization
     * during application execution.
     */
    public static void readItems(Context context, List<Item> list, File file) throws IOException {

        /*
         * Attempt to read data from existing item
         * file and store the items in itemList
         */
        if (file.exists()) {
            Scanner input = new Scanner(file);

            /*
             * iterate through all entries in the file; these should
             * consist of items from prior application runs
             */
            while (input.hasNextLine()) {
                //tokenize current line of input using % delimiter
                String[] tokens = input.nextLine().split("-");
                /*
                 * if the current line of the file has the correct number of entries,
                 * create and store an item from the item fields stored in it
                 */
                if (tokens.length == 2) {
                    list.add(new Item(tokens[1], Integer.parseInt(tokens[2])));
                }
            }
        }
    }

    /*
     * This method allows the conversion of the asset file containing
     * default items to the items it specifies, and stores the resultant
     * item objects in the parameter list
     */
    public static void readDefault(InputStream input, List<Item> list) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String curLine = "";

        //read each line from stream buffer and add
        //the specified items to the list
        while( (curLine = reader.readLine()) != null) {
            String[] tokens = curLine.split("-");
            if(tokens.length == 2)
                list.add(new Item(tokens[0], Integer.parseInt(tokens[1])));
        }
    }

    /*
     * This method writes the contents of the updated
     * item list to local storage for future use
     */
    public static void writeItems(List<Item> list, File file) throws IOException {
        /*
         * Create a new file reference to the specified item list
         * location and write all items in list to the file for storage
         */
        PrintWriter output = new PrintWriter(file);
        for(Item i : list) {
            output.print(i.getDescription() + "-" + i.getQuantity());
            output.println();
        }
    }
}