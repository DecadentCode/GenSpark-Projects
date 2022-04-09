import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    Scanner input = new Scanner(System.in);
    String word = pickWord();
    String guesses = "";

    void hangman() {
        int maxGuesses=5;

        System.out.println(("H A N G M A N"));
        for (int i = 0; i < maxGuesses; i++){
            System.out.println("Guess a letter:");
            if (word.contains(userGuess())){
                System.out.println("Good job!");
                i--;
            }else{
                System.out.println("Incorrect!");
            }
            printGallows(i);
            if(letterTracker(guesses)){
                System.out.println("Yes! The word is \"" +word+ "\"! Congratulations!");
                break;
            }
        }

    }

    String pickWord(){
        Random randomNum = new Random();
        List<String> dictionary = new ArrayList<>();
        String myWord;

        try {
            Scanner dictionarySrc = new Scanner(new File("C:\\Users\\alame\\IdeaProjects\\GenSpark\\hangman-words.txt"));

            while(dictionarySrc.hasNext()){
                dictionary.add(dictionarySrc.next());
            }

        }catch(Exception error){
            System.out.println("There was an error finding the word list: " + error);
            myWord = "error";
        }
        myWord = dictionary.get(randomNum.nextInt(dictionary.size()));
        return myWord;
    }

    String userGuess(){
        String letter = "";
        try {
            letter = input.nextLine();
        }catch (Exception error){
            System.out.println("Input error: " + error);
        }
        if (letter.length() != 1 ){
            System.out.println("Error! Try guessing one letter at a time!");
        }else if(guesses.contains(letter)){
            System.out.println("Error! Try guessing unique letters!");
            letter = "1";
        }
        else{
            guesses += letter;
        }
        return letter;
    }

    void printGallows(int fails){
        String gallows = switch(fails) {
            case -1 -> """
                    |---------|
                    |
                    |
                    |
                    |
                    |
                    |============|
                    """;
            case 0 -> """
                    |---------|
                    |    O
                    |
                    |
                    |
                    |
                    |============|
                    """;
            case 1 -> """
                    |---------|
                    |    O
                    |    |
                    |    |
                    |
                    |
                    |============|
                    """;
            case 2 -> """
                    |---------|
                    |    O
                    | +--|--+
                    |    |
                    |
                    |
                    |============|
                    """;
            case 3 -> """
                    |---------|
                    |    O
                    | +--|--+
                    |    |
                    |   /
                    |
                    |============|
                    """;
            case 4 -> """
                    |---------|
                    |    O
                    | +--|--+
                    |    |
                    |   / \\
                    |
                    |============|
                    
                    YOU LOSE! YOU GET NOTHING! GOOD DAY SIR AND/OR MADAM!
                    The correct word was \"""" + word + "\"";
            default -> "error";
        };
        System.out.println(gallows);
    }

    boolean letterTracker(String guesses){
        boolean success = true;
        System.out.print("Incorrect guesses: ");
        for (int i = 0; i < guesses.length(); i++){
            if(word.indexOf(guesses.charAt(i))==-1){
                System.out.print(guesses.charAt(i));
            }
        }
        System.out.println();
        System.out.print("Correct guesses: ");
        for (int i = 0; i < word.length(); i++){
            if(guesses.indexOf(word.charAt(i))==-1){
                System.out.print("_");
                success = false;
            }else{
                System.out.print(word.charAt(i));
            }
        }
        System.out.println();
        return success;
    }

}
