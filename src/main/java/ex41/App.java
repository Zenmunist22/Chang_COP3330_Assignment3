package ex41;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

/*
    Pseudocode
    Need to store all names into array to use Arrays.sort(arr[]);
    Two issues:
        - Size of array needed is undefined
        - Scan input file in one pass

    1. Scan input file
        - Grab name on each line and append with double space "  "
            - Store inside a variable to split
    2. Split name into array using helper function String.split("  ");
        - Use the "  " as a unique string pattern identifier
    3. Arrays.sort()
    4. Print result array to output file

 */
public class App {

    private File fileInput;
    private File fileOutput;
    private FileWriter fileWriter;
    private Scanner sc;
    private String names;
    private String namesArr[];

    public static void main(String[] args) {
        App app = new App();
        try {
            app.fileInput = new File("exercise41_input.txt");
            app.fileOutput = new File("exercise41_output.txt");

            app.fileInput.createNewFile();
            app.fileOutput.createNewFile();


            int x= 0;
            app.names = "";
            app.sc = new Scanner(app.fileInput);
            while (app.sc.hasNextLine()) {
                String data = app.sc.nextLine();
                app.names += data + "  ";
                x++;
            }

            app.namesArr = splitNames(app.names);
            Arrays.sort(app.namesArr);

            app.fileWriter = new FileWriter(app.fileOutput);
            for (int i = 0; i < x; i++){
                if (i != 0){

                    app.fileWriter.write("\n" + app.namesArr[i]);
                }
                else{
                    app.fileWriter.write("Total of " + x + " names");
                    app.fileWriter.write("\n-----------------\n");
                    app.fileWriter.write(app.namesArr[i]);
                }

            }


            app.fileWriter.close();
            app.sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String[] splitNames(String names){
        return names.split("  ");
    }

}
