package dsa.arrays.tests;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {


public static void main (String[] args){

    int[] inputArray1 = {1, 3, 5, 7, 8};
    int[] inputArray2 = {2, 4, 6, 8, 10, 10};
    Set<Integer> outputSet = new HashSet<>();
    outputSet = arryaUninonMethod(inputArray1,inputArray2 );


    for (int numb : outputSet){
        System.out.println("The output array has : " + numb);

    }

}


public static Set<Integer> arryaUninonMethod(int[] array1, int[] array2){

    Set<Integer> finalset = new HashSet<>();

    for(int i :array1) {
        finalset.add(i);
    }

    for (int j: array2){
        finalset.add(j);
    }


    return finalset;

}



}
