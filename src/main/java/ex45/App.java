package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */


/*
    Pseudocode
    1. Scan input into ArrayList for every line
    2. Use String.replaceAll("utilize", "use") to replace all "utilize" on each element in ArrayList
    3. Prompt for output file name
    4. Create output file
    5. Print ArrayList into output file
 */
public class App {
    private File fileInput;
    private File fileOutput;
    private ArrayList<String> lines;
    private Scanner sc;
    private Scanner consoleIn;
    private String fileOutputName;
    public static void main(String args[]){
        App app = new App();
        app.fileInput = new File("exercise45_input.txt");
        try {
            app.fileInput.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.lines = new ArrayList<>();
        app.sc = null;
        try {
            app.sc = new Scanner(app.fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (app.sc.hasNextLine()) {
            String input = app.sc.nextLine();
            app.lines.add(input);
        }
        Scanner consoleIn = new Scanner(System.in);
        System.out.print("Enter a output file name: ");
        String fileOutputName = consoleIn.nextLine();

        File fileOutput = new File(fileOutputName);
        try {
            fileOutput.createNewFile();
            FileWriter myWriter = new FileWriter(fileOutput);

            for (int i = 0; i < app.lines.size(); i++){
                myWriter.write(replaceWithUse(app.lines.get(i)) + "\n");
                System.out.println(replaceWithUse(app.lines.get(i)) + "\n");
            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String replaceWithUse(String str){
        return str.replaceAll("utilize", "use");

    }
}
