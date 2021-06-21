package ex41;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */

public class AppTest extends TestCase {

    @Test
    public void testSplitNames() {
        String str = "Ling, Mai" + "  " + "Johnson, Jim";
        Assertions.assertEquals(true, App.splitNames(str)[0].equals("Ling, Mai") && App.splitNames(str)[1].equals("Johnson, Jim"));

    }
}