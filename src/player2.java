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

    public int diceRoller;

    public int totalSpace;

    public String name;

    String choice;

    public double gameEarnings = 0;

    public String showMoney;

    public void rollDice() {
        diceRoller = rnd.nextInt(1, 6);
        totalSpace = space + diceRoller;
    }

    public void bankAccount() {
        playersMoney = playersMoney + gameEarnings;
        showMoney = ("\nYour current Balance In Your Account is now : " + String.format("$%.2f", playersMoney).replace("$0.", "$."));
    }
}
