package dsa.strings.tests;

// Interface to split the sentence into words
interface WordSplitter {
    String[] breakTheWordsOfSentence(String input);
}

// Interface to reverse a word
interface WordReverser {
    String reverseTheWordsFound(String wordToBeReversed);
}

// Concrete class that implements WordSplitter
class SentenceWordSplitter implements WordSplitter {
    @Override
    public String[] breakTheWordsOfSentence(String input) {
        String[] myNewArray = input.split(" ");  // Split the input string by spaces into words
        return myNewArray;
    }
}

// Concrete class that implements WordReverser
class SimpleWordReverser implements WordReverser {
    @Override
    public String reverseTheWordsFound(String wordToBeReversed) {
        String[] broKenWord = wordToBeReversed.split("");  // Split the word into individual characters
        int len = broKenWord.length;

        // Reverse the characters in the array using the swapping technique
        for (int i = 0; i < len / 2; i++) {
            String tempString = broKenWord[i];
            broKenWord[i] = broKenWord[len - i - 1];
            broKenWord[len - i - 1] = tempString;
        }

        // Join the character array back into a string and return
        String reversedString = String.join("", broKenWord);
        return reversedString;
    }
}

// Main class to process the string
public class ReverseTheStringWithInterface {

    // The input sentence
    static String inputString = "THis is very good Day";

    public static void main(String[] args) {
        printTheFinalString();
    }

    // Method to print the final reversed string
    public static void printTheFinalString() {
        // Using the WordSplitter interface to split the sentence
        WordSplitter wordSplitter = new SentenceWordSplitter();
        String[] finalArray = wordSplitter.breakTheWordsOfSentence(inputString);

        // Using the WordReverser interface to reverse the words
        WordReverser wordReverser = new SimpleWordReverser();
        StringBuilder finalSentence = new StringBuilder();

        // Reverse each word and build the final sentence
        for (String xyz : finalArray) {
            String finalReversedString = wordReverser.reverseTheWordsFound(xyz);
            finalSentence.append(finalReversedString).append(" ");  // Add the reversed word to the final sentence
        }

        // Print the final sentence with reversed words
        System.out.println("The final reversed sentence is: " + finalSentence.toString().trim());
    }
}
