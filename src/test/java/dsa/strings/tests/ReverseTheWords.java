package dsa.strings.tests;

import java.util.Arrays;

public class ReverseTheWords {

    //reverse the words of a sentence
    static String inputString  = "THis is very good Day";





    public static void main (String[] args){
        printTheFinalString();
    }




    public static String[] breakTheWordsOfSentence(String input){

        String [] myNewArray = input.split(" ");
        for (String abc : myNewArray){
            System.out.println("Printing the words found >-----> " +abc);
        }
        return myNewArray;
    }


    public static String  reverseTheWordsFound(String wordToBeReversed){

        String [] broKenWord = wordToBeReversed.split("");
        int len = broKenWord.length;
        for(int i =0; i<((broKenWord.length)/2);i++){
            String tempString  = broKenWord[i];
            broKenWord[i] = broKenWord[len-i-1];
            broKenWord[len-i-1] = tempString;

        }

        String reversedString = String.join("", broKenWord);  // Join all characters together
        System.out.println("The reversed word is <----< " + reversedString);
        return reversedString;

    }

    public static void printTheFinalString(){

        String[] finalArray =  breakTheWordsOfSentence(inputString);
        StringBuilder finalSentence = new StringBuilder();

        for(String xyz : finalArray){
           String finalReversedString =  reverseTheWordsFound(xyz);
            System.out.println(finalReversedString);
            finalSentence.append(finalReversedString).append(" ");  // Add the reversed word to the final sentence


        }

        System.out.println("The final reversed sentence is: " + finalSentence.toString().trim());

    }



}


//create two methods
//First one with breaking of all the words
//Second reverse the words that are given to it
//
// run for loop on the output String[] of array1
//
// output of the first methods--- like for every words that