package src;

// Importing Libraries 
import java.util.Random;

/**
 * Player 2 Data
 * @athuor Sarim Siddiqui
 */

public class player2 {

    // Creating Objects  

    Random rnd = new Random();

    // Creating Variables
    
    public int space = 1;
    
    public double playersMoney = 10000;
    
    public int diceRoller = rnd.nextInt(1, 6);

    public int totalSpace = space + diceRoller;

    public String name;

    public void playerTurn() {
        System.out.println(name + ", it's your turn! What would you like to do?");
        System.out.println("\nPress (H) to view game instructions");
        System.out.println("\nPress (I) to view inventory");
        System.out.println("\nPress (M) to view your current money total");
        System.out.println("\nPress (S) to view what space you're currently on");
        System.out.println("\nPress (R) to roll and begin your turn!");
    }
}
