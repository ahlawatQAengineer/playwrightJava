package dsa.strings.tests;

import java.util.Arrays;
import java.util.Objects;

public class ReplaceCharinString {



    public static void main (String[] args){


        String originalString = "tomorrow";
        String stringToReplace = "$";

        replaceString(originalString,stringToReplace);

        //write a code to replace a string from a given string

    }


    public static void replaceString(String inputS, String replaceWith){

       int count  =  0;
        String inputLowercase  =  inputS.toLowerCase();
       String [] myCharArray = inputLowercase.split("");


        for(int i= 0; i<myCharArray.length; i++){

            String currentValue = myCharArray[i];

            if (Objects.equals(currentValue, "o")){

                System.out.println("Found an O at the postion " + (count+1));
                count ++;


                if (count == 2 ){

                    myCharArray[i] = replaceWith;


                }




            }



        }

        System.out.println(Arrays.toString(myCharArray));





    }




}
