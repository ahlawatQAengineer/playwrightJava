package dsa.arrays.tests;

import java.util.ArrayList;
import java.util.HashMap;

public class printUniqueSetofChars {


    public static void main(String[] args){


        String inputString =  "This is a beautiful Day :  Friday";
        String lowercaseString  =  inputString.toLowerCase();
        String[] outputString  = returnAllnonRptChars(lowercaseString);

        for (String a : outputString ){
            System.out.print(a);
        }


    }




    public static String[] returnAllnonRptChars(String inputS){

        ArrayList<String> outputList = new ArrayList<String>();
        HashMap<Character , Integer> newHashMap =  new HashMap<Character, Integer>();
        char[] inputStringArray =  inputS.toCharArray();
        int length =  inputS.length();

       for(char c: inputStringArray){
           if (c != ' ') {
               newHashMap.put(c, newHashMap.getOrDefault(c, 0) + 1);

           }
       }

        for (char c : inputStringArray){
            Integer count = newHashMap.get(c);
            if(count != null && newHashMap.get(c) ==1){
                outputList.add(String.valueOf(c));
            }

        }


        String[] outputArray = outputList.toArray(new String[0]);
        return outputArray;
    }

















}
