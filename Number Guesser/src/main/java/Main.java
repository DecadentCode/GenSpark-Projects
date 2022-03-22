import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
//        declarations
        Scanner input = new Scanner(System.in);
        int rng;
        int guess;
        int counter;
        boolean correct=false;
        String replay="y";

//        retrieve player name
        System.out.println("Hello! What is your name?");
        String name = input.nextLine();

//        the guessing game
        while(replay.contains("y")){
            rng = (int)Math.floor(Math.random()*(20-1)+1);
            guess = 0;
            counter = 0;
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            for (int i = 0; i < 6 && !correct; i++) {
                counter++;
                System.out.println("Take a guess.");
                guess = input.nextInt();
                if (guess > rng) {
                    System.out.println("Your guess is too high.");
                } else if (guess < rng) {
                    System.out.println("Your guess is too low.");
                } else {
                    correct = true;
                }
            }

//        output game results
            if (correct) {
                System.out.println("Good job, " + name + "! You guessed my number in " + counter + " guesses!");
            }else{
                System.out.println("So sorry, " + name + ", but you failed 6 times...");
            }
            correct = false;
            System.out.println("Would you like to play again? (y or n)");
            input.nextLine(); // resets the input from the previous nextInt()
            replay = input.nextLine();
        };
    }
}
