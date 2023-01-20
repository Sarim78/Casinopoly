package src;

// Importing Libraries 
import java.util.Random;

/**
 * Player 1 Data
 * @author adil
 */

public class player {

    // Creating Objects  

    Random rnd = new Random();

    // Creating Variables
    
    public int space = 1;

    public int diceRoller;

    public static int totalSpace = 1; //game space player is in

    public static String name;

    String choice;

    public static double gameEarnings; //money earned playing the game

    public String showMoney;

    public static double playersMoney; //bank account

    //to store total space
    public int plsworktoo(int totalSpace) {
        return totalSpace;
    }

    //to roll the dice
    public void rollDice() {
        diceRoller = rnd.nextInt(1, 6);
        totalSpace = totalSpace + diceRoller;
        plsworktoo(totalSpace);
    }

    //to store players money
    public double plsWorklol(double playersMoney, String name) {
        showMoney = ("\n" + name + ", Your current Balance In Your Account is now : " + String.format("$%.2f", playersMoney).replace("$0.", "$."));
        System.out.println(showMoney);
        return playersMoney;
    }

    //to add game earnings to bank account
    public void bankAccount() {
        playersMoney = 10000;
        playersMoney = playersMoney + gameEarnings;
        plsWorklol(playersMoney, name);
    }
}