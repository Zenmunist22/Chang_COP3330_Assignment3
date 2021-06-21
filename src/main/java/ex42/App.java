package ex42;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

/*
    Pseudocode

    Need to store all names into array to use Arrays.sort(arr[]);
    Three issues:
        - Size of array needed is undefined
        - Scan input file in one pass
        - Parse data for output

    1. Scan input file data
        - Grab data on each line
    2. Split name into array using helper function String.split(",");
    3. Store result inside a ArrayList<String[]> to split(",")
        - Creates String arr[3] = {last,first,salary}
    4. Print result ArrayList to output file using String.format("%-10s") to achieve equal spacing

 */
public class App {

    private File fileInput;
    private File fileOutput;
    private FileWriter fileWriter;
    private Scanner sc;
    private ArrayList<String[]> data;

    public static void main(String args[]){
        App app = new App();
        try{
            app.fileInput = new File("exercise42_input.txt");
            app.fileOutput = new File("exercise42_output.txt");

            app.fileInput.createNewFile();
            app.fileOutput.createNewFile();


            app.data = new ArrayList<String[]>();
            app.sc = new Scanner(app.fileInput);
            while (app.sc.hasNextLine()) {
                String input = app.sc.nextLine();
                app.data.add(splitNames(input));
            }


            app.fileWriter = new FileWriter(app.fileOutput);
            app.fileWriter.write(String.format("%-10s%-10s%-10s","Last","First","Salary"));
            app.fileWriter.write(String.format("\n--------------------------"));
            // Print data to output.txt
            for (int i = 0; i < app.data.size(); i++){
                app.fileWriter.write(String.format("\n%-10s%-10s%-10s", app.data.get(i)[0], app.data.get(i)[1], app.data.get(i)[2]));
            }

            app.fileWriter.close();
            app.sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static String[] splitNames(String names){
        return names.split(",");
    }
}
