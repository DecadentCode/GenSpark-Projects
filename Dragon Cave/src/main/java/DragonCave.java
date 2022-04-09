import java.util.Scanner;

public class DragonCave {
    boolean success;
    void dragonCave(int choice) {
//        output results of choice
        System.out.println("You approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...");
        if (choice == 1){
            success = false;
            System.out.println("Gobbles you down in one bite!");
        }else if(choice == 2){
            success = true;
            System.out.println("Welcomes you to his home and some of his treasure!");
        }else{
            success = false;
            System.out.println("Gives you a stern talking to for not following\n" +
                    "the directions correctly, then he eats you!");
        }
    }
}
