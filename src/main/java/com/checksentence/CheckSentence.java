/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checksentence;

/**
 *
 * @author bryson
 */
public class CheckSentence
{

    // Method to check a given sentence for given rules
    public static boolean checkSentence(char str[])
    {
        // Calculate the length of the string.
        final int len = str.length;

        // Check that the first character lies in [A-Z].
        // Otherwise return false.
        if (str[0] < 'A' || str[0] > 'Z') {
            return false;
        }

        //If the last character is not a full stop(.) no
        //need to check further.
        if (str[len - 1] != '.') {
            return false;
        }
        
        // Maintain 2 states. Previous and current state based
        // on which vertex state you are. Initialise both with
        // 0 = start state.
        int prev_state = 0, curr_state = 0, quote_count = 0;
        //Loop to go over the string.
        for(int index = 1; index < len ; index++) {
            curr_state = 0;
            // Set states according to the input characters in the
            // string and the rules defined in the description.
            if (str[index] == '\"') {
                quote_count++;
            }
            else if (index != (len - 1) && str[index] == '.') {
                return false;
            } // If current character is a space. Set current state as 1.
            else if (str[index] == ' ') {
                curr_state = 1;
            } // If current character is [a-z]. Set current state as 2.
            else if (str[index] >= 'a' && str[index] <= 'z') {
                curr_state = 2;
            }

            // Validates all current state with previous state for the 
            // rules in the description of the problem.
            if (prev_state == curr_state && curr_state != 2) {
                return false;
            }

            if (prev_state == 2 && curr_state == 0) {
                return false;
            }

            index++;

            // Set previous state as current state before going over
            // to the next character.
            prev_state = curr_state;
        }
        
        if (quote_count % 2 == 0) {
            return true;
        }
        else
            return false;
    }

}
