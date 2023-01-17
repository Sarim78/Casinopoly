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

    public String name = "player2";
}
