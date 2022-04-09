import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            Hangman game = new Hangman();
            game.hangman();
            System.out.println("Would you like to play again? yes or no?");
            if(input.nextLine().contains("n")){
                break;
            }
        }

    }
}
