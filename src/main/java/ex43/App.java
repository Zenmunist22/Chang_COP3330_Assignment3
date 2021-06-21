package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */

/*
    Pseudocode
    1. Receive Input
    2. Initialize website directory in this order {/name/,index.html,/js/,/css/}
        - Make sure it is referencing working directory using "."
    3. Print directory created relative to "."

 */
public class App {
    private Scanner sc;
    private String name;
    private String author;
    private String folderJava;
    private String folderCSS;
    private File indexHTML;
    private FileWriter myWriter;
    public static void main(String args[]){
        App app = new App();
        app.sc = new Scanner(System.in);
        System.out.print("Site name: ");
        app.name = app.sc.nextLine();
        System.out.print("Author: ");
        app.author = app.sc.nextLine();
        System.out.print("Do you want a folder for javascript?: ");
        app.folderJava = app.sc.nextLine();
        System.out.print("Do you want a folder for CSS?: ");
        app.folderCSS = app.sc.nextLine();

        // Create ./website/name dir
        createDir("./website/" + app.name);
        System.out.printf("%s", "./website/" + app.name);

        // Create index.html & insert author/title tags
        try {
            app.indexHTML = new File("./website/" + app.name + "/index.html");
            app.indexHTML.createNewFile();

            app.myWriter = new FileWriter(app.indexHTML);
            String titleTag = String.format("<title>%s</title>",app.name);
            String authorMetaTag = String.format("<meta name=\"author\" content=\"%s\">", app.author);
            app.myWriter.write("<html>\n\t<head>\n\t\t" + titleTag + "\n\t\t" + authorMetaTag + "\n\t</head>\n\t<body>\n\n\t</body>\n</html>");

            app.myWriter.close();


            System.out.printf("\n%s", "./website/" + app.name + "/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create javascript dir
        if (app.folderJava.equalsIgnoreCase("Y")){
            createDir("./website/" + app.name + "/js/");
            System.out.printf("\n%s", "./website/" + app.name + "/js/");
        }
        // Create css dir
        if (app.folderCSS.equalsIgnoreCase("Y")){
            createDir("./website/" + app.name + "/css/");
            System.out.printf("\n%s", "./website/" + app.name + "/css/");
        }
        app.sc.close();



    }
    // Testing purposes
    public static boolean createDir(String dir){
        return new File(dir).mkdirs();
    }
}
