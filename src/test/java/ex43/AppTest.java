package ex43;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.io.File;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */

public class AppTest extends TestCase {

    public void testCreateDir() {
        if (App.createDir("test") == false){
            File x = new File("test");
            x.delete();
        }
        Assertions.assertEquals(true, App.createDir("test"));
    }
}