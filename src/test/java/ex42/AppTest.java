package ex42;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */


public class AppTest extends TestCase {

    public void testSplitNames() {
        String str = "Ling,Mai";
        Assertions.assertEquals("Ling", App.splitNames(str)[0]);
    }
}