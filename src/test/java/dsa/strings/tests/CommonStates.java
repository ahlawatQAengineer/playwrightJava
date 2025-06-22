package dsa.strings.tests;

import java.util.*;
import java.lang.*;
import java.io.*;

class CommonStates
{


    //We have two array lists with state names
    //list1 with states having mouuntains
    //list 2 states having beaches
    //find the states which have both beaches and mountains
    //now i have a HashMap which has all the states and their count
    //print all states with value > 1
    //iterate over entryset ---->
    //getValue -----> if getValue > 1
    //print getKey




    public static void main (String[] args) throws java.lang.Exception{

        ArrayList<String> beachStates = new ArrayList<>(Arrays.asList("Goa", "Maharastra", "TamilNadu", "Bengal","Kerala"));
        ArrayList<String> mountainStates = new ArrayList<>(Arrays.asList("Himachal", "JnK" , "Kerala", "Maharastra"));


        statesWithMountainsndBeaches(beachStates, mountainStates );



    }



    public static void statesWithMountainsndBeaches(ArrayList<String> input1, ArrayList<String> input2){
        HashMap<String , Integer> newHashMap = new HashMap<>();

        for (String beaches : input1){

            newHashMap.put(beaches, newHashMap.getOrDefault(beaches, 0) +1 );

        }


        for (String mountains :input2 ){

            newHashMap.put(mountains, newHashMap.getOrDefault(mountains, 0) +1);

        }



        for (HashMap.Entry<String, Integer> currentHashEntry : newHashMap.entrySet()){

            String  currentKey = currentHashEntry.getKey();
            Integer currentValue = currentHashEntry.getValue();

            if(currentValue> 1){

                System.out.println("The state of " +currentKey+ " is present in both beaches and mountains." );
                System.out.println("Lets plan a trip");
            }

        }

    }

}

