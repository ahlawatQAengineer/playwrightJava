package dsa.strings.tests;

import java.sql.Array;
import java.util.*;

import static java.util.Arrays.asList;

public class VowelSelection {

    //   String-Based Questions:
    //    Remove all vowels from a string:
    //    Given a string, remove all vowels ('a', 'e', 'i', 'o', 'u') from it and return the modified string.
    //     In this i want to know which vowels are missing in this sentence


public static void main(String[] args){

    String  inputString = "The quck brown Fox Jumped over the lazy Dog";




}


public void getAllUniqueAlphabets(String input){

    HashSet<String> myAlphabetSet = new HashSet<>();
    String [] myInputArray = input.split("");
    ArrayList<String> myArrayList = new ArrayList<>(Arrays.asList(myInputArray));
    ArrayList<String> myArrayList2 = new ArrayList<>(); // Initialize as an empty ArrayList
    boolean[] booleanVowels = new boolean[5];
    char [] myVowels= {'a','e','i','o','u'};


       for (String abc :myInputArray ){

           myAlphabetSet.add(abc);
           System.out.println("The following letter has been appended to the list : " +abc);
       }

       for(String xyz :myAlphabetSet ){





           if(myAlphabetSet.contains("a")){
               System.out.println("Vowel a has been found this many times");
               booleanVowels[0] =true;
           };
           if(myAlphabetSet.contains("e")){
               booleanVowels[1]=true;
           }
           if(myAlphabetSet.contains("i")){
               booleanVowels[2]=true;
           }
           if(myAlphabetSet.contains("o")){
               booleanVowels[3]=true;
           }

           if(myAlphabetSet.contains("u")){
               booleanVowels[4]=true;
           }


       }



    Collections.addAll(myArrayList2, myInputArray);

    // Add all elements from the array to the ArrayList
    for(int k =0; k<5; k++){
        System.out.println("Value in ArrayList2 is " + myArrayList2.get(k) );
    }




}























}





