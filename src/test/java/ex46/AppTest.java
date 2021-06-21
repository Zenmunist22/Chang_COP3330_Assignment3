package ex46;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Tommy Chang
 */


public class AppTest extends TestCase {

    public void testWordsOccurrencesFormatted() {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> wordsOccurrences = new ArrayList<>();

        words.add("badger");
        words.add("mushroom");
        words.add("snake");
        wordsOccurrences.add(7);
        wordsOccurrences.add(2);
        wordsOccurrences.add(1);

        Assertions.assertEquals("badger:   *******\n" +
                "mushroom: **\n" +
                "snake:    *", App.wordsOccurrencesFormatted(words, wordsOccurrences));

    }
}