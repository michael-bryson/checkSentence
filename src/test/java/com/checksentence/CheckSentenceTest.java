/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checksentence;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static com.checksentence.CheckSentence.*;

/**
 *
 * @author bryson
 */
public class CheckSentenceTest
{
    
    @Test
    public void checkSentencesPF()
    {
        final List<char[]> listOfCharArrays = new ArrayList<>();
        listOfCharArrays.add("The quick brown fox said \"hello Mr lazy dog\".".toCharArray());
        listOfCharArrays.add("The quick brown fox said hello Mr lazy dog.".toCharArray());
        listOfCharArrays.add("One lazy dog is too few, 13 is too many.".toCharArray());
        listOfCharArrays.add("One lazy dog is too few, thirteen is too many.".toCharArray());
        listOfCharArrays.add("The quick brown fox said \"hello Mr. lazy dog\".".toCharArray());
        listOfCharArrays.add("the quick brown fox said \"hello Mr lazy dog\"".toCharArray());
        listOfCharArrays.add("\"The quick brown fox said \"hello Mr lazy dog.\"".toCharArray());
        listOfCharArrays.add("One lazy dog is too few, 12 is too many.".toCharArray());
        listOfCharArrays.stream().map((array) -> {
            final boolean sentance = checkSentence(array);
            if (sentance) {
                System.out.println("The sentence is correct \n" + String.valueOf(array));
            }
            return array;
        }).forEachOrdered((array) -> {
            final boolean sentance = checkSentence(array);
            if (sentance == false) {
                System.out.println("The sentence is incorrect \n" + String.valueOf(array));
            }
        });
    }
    
}
