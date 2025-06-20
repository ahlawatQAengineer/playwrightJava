package dsa.strings.tests;

import java.util.HashMap;

public class HstandShstOccuringString {

    //Write code to print highest and secondHighest occurring string and char from a string;


    //Solution :   //iterate through value of keys entry,
    //store the value of key in highestValue
    //if key value> highestValue ---->
    //secondHighestValue = highestValue
    //key value = highestValue







    public static void main(String args[]){

        //Input
        String inputString  =  "Whys is Visakhapatnam so far?";
        highestNSecondHsgtChar(inputString);

    }


    public static void highestNSecondHsgtChar(String input){

        int highestValue = 0;
        int secondHighestValue = 0;
        String highestChar = "";
        String secondHighestChar = "";
        char[] newCharArray = input.toCharArray();
        HashMap<String, Integer> newHashMap = new HashMap<>();


        for (char x : newCharArray){
            newHashMap.put(String.valueOf(x), newHashMap.getOrDefault(String.valueOf(x),0)+1);
        }

        for(HashMap.Entry<String, Integer> entryValue : newHashMap.entrySet() ){

            int currentValue = entryValue.getValue();
            String currentKey = entryValue.getKey();


           if ( currentValue >highestValue && !currentKey.equals(" ")){
               secondHighestValue = highestValue;
               highestValue =currentValue;
               secondHighestChar = highestChar;
               highestChar = currentKey;

           } else if (currentValue<highestValue &&currentValue>secondHighestValue ) {
               secondHighestValue = currentValue;
               secondHighestChar = currentKey;

           }
        }


        System.out.println("My Highest occurring String until now is : " +highestChar + " And it was present " +highestValue + " times.");
        System.out.println("My Second Highest occurring String until now is : " +secondHighestChar + " And it was present " +secondHighestValue + " times.");


    }




}
