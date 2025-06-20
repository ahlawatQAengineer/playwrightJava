package dsa.arrays.tests;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElementsOfArray {


    public static void main (String [] args){

        int[] inputarray1 = {1, 2, 3,3, 5, 6, 8, 0};
        int[] inputarray2 = {2,4,6,7,8,10};
        ArrayList<Integer> outputArray = new ArrayList<>();
        outputArray = getDuplicateElement(inputarray1, inputarray2);

        for (int numb : outputArray ){
            System.out.println("Following element has been repeated in one or more arrays : " + numb);
        }

    }



    public static ArrayList<Integer> getDuplicateElement(int[] array1, int[] array2){

        HashMap<Integer,Integer> duplicateElement = new HashMap<>();
        ArrayList<Integer> finalarryList = new ArrayList<>();

        for(int i : array1){
            duplicateElement.put(i,duplicateElement.getOrDefault(i,0)+1);
        }


        for (int j : array2){
            duplicateElement.put(j,duplicateElement.getOrDefault(j,0)+1);
        }


        for(HashMap.Entry<Integer, Integer> entry : duplicateElement.entrySet()){

           int  value = entry.getValue();
           if(value >1){

               finalarryList.add(entry.getKey());

           }

        }


        return finalarryList;


    }




}
