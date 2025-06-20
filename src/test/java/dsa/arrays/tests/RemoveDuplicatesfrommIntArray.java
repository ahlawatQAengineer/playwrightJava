package dsa.arrays.tests;
import java.util.TreeSet;


import java.util.*;

public class RemoveDuplicatesfrommIntArray {


   public static void main (String[] args){
       int[] inputArray = {1, 2, 3, 44, 2, 5, 6, 7, 4, 3,0,1};
       Set<Integer> outputRawArray =  getnonRepeatedArray(inputArray);

       for(int a : outputRawArray){
           System.out.println("The elements in the array are : " + a );
       }

   }


   public static Set<Integer>  getnonRepeatedArray(int[] iarray){

       Set<Integer> newHashSet =  new TreeSet<>();
       for (int num : iarray ){
           newHashSet.add(num);
       }
        return newHashSet;

   }



}
