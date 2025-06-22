package dsa.strings.tests;

public class ConvertFirstLetterToUpperCase {






     public static void main(String[] args){
         String inputString  = "where is the love ? bro! where is the love? ye! i see no love. ye ye, where is the love?";

        String [] wordsBreaker =  convertSentenceToWords(inputString);

         formatInputString(wordsBreaker);
     }



     public static String[] convertSentenceToWords(String input){
         String[] myNewArray = input.trim().split("\\s+");
        return myNewArray;

     }

     public static void formatInputString(String [] borkenDownSentence){

         for(String abc: borkenDownSentence){
           String lowercaseword =   abc.toLowerCase();
           StringBuilder modifiedWod =  new StringBuilder();
           boolean isFirstChar = true;

           for (char a : lowercaseword.toCharArray() ){

               if (isFirstChar){
                   modifiedWod.append(Character.toUpperCase(a));
                   isFirstChar = false;
               }else{
                   modifiedWod.append(a);
               }
           }

             System.out.println(modifiedWod.toString()); // Print the modified word


         }




     }





}




//split the sentence to words
//store them?
//method to get a word and return with capital and format
//fetch first elelmtn-  convet tom upperczase, send back in same arraylist -  return the arraylist as string----

