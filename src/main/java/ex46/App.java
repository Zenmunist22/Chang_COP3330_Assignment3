package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */



/*
    Pseudocode

    1. use Scanner.next() to scan token seperated by " "
    2. Init List words<String> & wordsOccurrences<Integer> (Parallel ArrayLists)
        - Insert new word if not exist previously into words
            - Insert one for every new word into wordsOccurrences
    3. Add 1 for each word occurrence
        - words.get(i) and wordsOccurrences.get(i) will correspond as they are parallel arrayLists
    4. Sort the wordOccurrences and move the respective words.get(i) as well
    5. Print results
 */

public class App {
    private File fileInput;
    private ArrayList<String> words;
    private ArrayList<Integer> wordsOccurrences;
    private Scanner sc;
    public static void main(String args[]){
        App app = new App();
        app.fileInput = new File("exercise46_input.txt");

        try {
            app.fileInput.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.words = new ArrayList<String>();
        app.wordsOccurrences = new ArrayList<Integer>();
        Scanner sc = null;


        try {
            sc = new Scanner(app.fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String input = sc.next();
            if (app.words.contains(input)){
                app.wordsOccurrences.set(app.words.indexOf(input),app.wordsOccurrences.get(app.words.indexOf(input)) + 1);
            }
            else{
                app.words.add(input);
                app.wordsOccurrences.add(1);
            }
        }


        int n = app.wordsOccurrences.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (app.wordsOccurrences.get(j) < app.wordsOccurrences.get(j+1))
                {
                    // swap arr[j+1] and arr[j]
                    int temp = app.wordsOccurrences.get(j);
                    String tempStr = app.words.get(j);

                    app.wordsOccurrences.set(j, app.wordsOccurrences.get(j+1));
                    app.wordsOccurrences.set(j+1, temp);
                    app.words.set(j, app.words.get(j+1));
                    app.words.set(j+1, tempStr);
                }


        System.out.printf("%s", wordsOccurrencesFormatted(app.words, app.wordsOccurrences));
        sc.close();
    }

    public static String wordsOccurrencesFormatted(ArrayList<String> words, ArrayList<Integer> wordsOccurrences){
        String res = "";
        for (int i = 0; i < words.size(); i++){
            if (i != 0){
                res += "\n";
            }
            res += String.format("%-10s",words.get(i) + ":");
            for (int j = 0; j < wordsOccurrences.get(i); j++) {
                res += "*";
            }
        }

        return res;
    }

}
