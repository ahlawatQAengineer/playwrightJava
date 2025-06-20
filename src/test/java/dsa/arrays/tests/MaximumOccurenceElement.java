package dsa.arrays.tests;

import java.util.HashMap;

public class MaximumOccurenceElement {


    public static void main(String[] args) {
        String[] inputArray = {"Banana", "Apple", "Mango", "Lithci", "Mango", "Nisha", "Aria", "Mango", "Banana", "Max"};
        String outPutElement;

        outPutElement = maxOccuringElement(inputArray);
        System.out.println(outPutElement);

    }


    public static String maxOccuringElement(String[] input) {

        int maxValue  = 0;
        int currentOccurence  = 0;
        String maxOccuringString = null;
        HashMap<String , Integer> newHashMap = new HashMap<>();


        if (input == null || input.length == 0) {
            return null;
        }

        for(String abc : input ){
            newHashMap.put(abc, newHashMap.getOrDefault(abc,0) +1);

        }
        for (HashMap.Entry<String, Integer> entry : newHashMap.entrySet()){

            if(entry.getValue() >maxValue ){

                maxValue = entry.getValue();
                maxOccuringString = entry.getKey();

            }
        }






    return maxOccuringString;
    }


}





