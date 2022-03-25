import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        declarations
        Scanner input = new Scanner(System.in);
        String name;
        int rng;
        int guess;
        int guesses;
        String replay;

//        retrieve player name
        System.out.println("Hello! What is your name?");
        try {
            name = input.nextLine();
        }catch (Exception nameError){
            System.out.println("Input error: "+nameError+"\n" +
                    "Something went wrong, so your name shall be Alex");
            name = "Alex";
        }

//        the guessing game
        do{
            guesses = 0; //resets the number of attempts
            guess = 0; //resets the player's guess
            rng = (int)Math.floor(Math.random()*(20-19+1)+19); //generates a new random number
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            for (int i = 0; i < 6 && guess != rng; i++) {
                guesses++;
                System.out.println("Take a guess.");
                try {
                    guess = input.nextInt();
                    if (guess > rng) {
                        System.out.println("Your guess is too high.");
                    } else if(guess < rng){
                        System.out.println("Your guess is too low.");
                    }
                }catch (Exception guessError){
                    System.out.println("Input error: "+guessError+"\n" +
                            "Something went wrong with your guess.");
                    guess=0;
                }
                input.nextLine(); // resets the input from the previous nextInt()
            }

//            output results
//            changes message based on number of attempts
            if(guesses==1){
                System.out.println("Good job, " + name + "! You guessed my number on the first try!");
            }else if(guess==rng){
                System.out.println("Good job, " + name + "! You guessed my number in " + guesses + " guesses!");
            }else{
                System.out.println("So sorry, " + name + ", but you failed 6 times...");
            }

//            would the player like to play again?
            System.out.println("Would you like to play again? (y or n)");
            try {
                replay = input.nextLine();
            }catch (Exception replayError){
                System.out.println("Input Error: "+replayError+"\n" +
                        "Something went wrong, ending game.\n" +
                        "End of Line.");
                replay="n";
            }
        }while(replay.contains("y"));

//        ending statement
        System.out.println("Thanks for playing, "+name+"!\n" +
                "End of line.");
    }
}
