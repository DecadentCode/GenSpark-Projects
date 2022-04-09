import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        declarations
        Scanner input = new Scanner(System.in);
        int choice;

//        output introduction
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");

//        input player choice
        try{
            choice = input.nextInt();
        }catch (Exception error){
            System.out.println("Input error: "+error);
            choice = 3;
        }
        DragonCave game = new DragonCave();
        game.dragonCave(choice);
    }
}
