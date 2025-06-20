package dsa.arrays.tests;

public class ReverseArrayElement {




    public  static void main (String [] args){
        String [] inputArrayList = {"Arunachal" , "Assam", "Bengal" , "Bihar", "Chattisgarh", "Haryana", "Rajasthan" , "Sikkim", "Tripura", "TamilNadu"};
        String [] outputArray = new String[10];
        outputArray = reverseTheArray(inputArrayList);

        for(String abc : outputArray){
            System.out.println(abc);
        }


    }

public static String[] reverseTheArray(String[] input){

        int l = input.length;
        String tempString = null;

        for(int i = 0;  i<(input.length)/2;){
          tempString = input[i];
          input[i] = input[l-i-1];
          input[l-i-1] = tempString;

           i++;
        }

    return input;


}





}
