package dsa.arrays.tests;

public class PrimeValueArray {



    public static void main(String [] args) {

        //find the prime number in the array

        int [] myIntArray = {2, 3, 8, 19, 22, 10, 13, 17, 131, 19, 23, 61, 29};

        primeIdetifierMethod(myIntArray);

    }

    public static void primeIdetifierMethod(int [] myArray){

        int currentValue = 0;
        for (int i = 0; i<myArray.length; i++) {
            boolean isPrime  = true;
            currentValue = myArray[i];

            if (currentValue <= 1) {
                isPrime = false;
            }

            for (int j = 2; j <= Math.sqrt(currentValue); j++) {

                if (currentValue % j == 0) {

                    isPrime = false;
                    break;
                }
            }


            if (isPrime) {

                System.out.println("The given number is a prime number " + currentValue);

            }

        }

    }









}
