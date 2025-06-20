package dsa.arrays.tests;

public class NonRepeatingfirstChar {


public static void main(String[] args) {

    String inputString  =  "Wow what an awesome to start and end the week";
    String lowercaseString = inputString.toLowerCase();
    String newString  =  lowercaseString.replaceAll(" ", "");
    String outputString  =   nonRepeatingChar(newString);
    System.out.println("The first non repeating char is " + outputString);
}



    public static String nonRepeatingChar (String inPutS){

        char[] charArray = inPutS.toCharArray();

        String outPut = null;
        for (int i = 0; i<charArray.length;  i++) {

            char compareChar = charArray[i];
            int count  =  0;

            for (int j = 0; j < charArray.length; j++) {

                char currentChar = charArray[j];


                if (compareChar == currentChar && i != j) {
                    count++;
                }

            }
            if (count==0) {
                return String.valueOf(compareChar);
            }
        }





        return outPut;
    }






}
