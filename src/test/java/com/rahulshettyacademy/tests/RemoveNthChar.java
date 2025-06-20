package com.rahulshettyacademy.tests;

import org.testng.annotations.Test;

public class RemoveNthChar {

String inputString  = "aabxccdyddeztst1";


public String  removeExtraChar(String myInput){

    StringBuilder  result  =  new StringBuilder();

    for (int i =0; i<myInput.length(); i++){
        if((i+1)%4 !=0){
            result.append(myInput.charAt(i));
        }

    }

    return result.toString();

}


@Test(enabled = true, priority =1 , description = "This is to check DSA logic 1")
    public void printtheOutput(){

    String resultString = removeExtraChar(inputString);

    System.out.println("The output string is " +resultString);

}



}


//Take a string as input
//for that string initiate a function to remove the chars
//send the input string as parameter to the fucntion
//define a new string using StringBuilder()
//iterate for all the placed of the input string
//write the logic of removal or append using string builder
//user keywords like append(); or remove if the string is declared before logic definition
//return the function with the new StringBuilder,
// make sure ti return the string builder back toString as ouput
//print the result in another/main function